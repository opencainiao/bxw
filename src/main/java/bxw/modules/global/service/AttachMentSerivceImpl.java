package bxw.modules.global.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mou.common.DateUtil;
import org.mou.common.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.mou.mongodb.base.springdb.dao.IBaseDaoMongo;

import bxw.common.util.EncoderHandler;
import bxw.common.util.FileUtil;
import bxw.modules.base.BaseService;
import bxw.modules.global.model.Attachment;
import bxw.modules.global.model.ThumbParam;

@Service("attachmentService")
public class AttachMentSerivceImpl extends BaseService implements IAttachmentService {

	@Resource(name = "commonDaoMongo")
	private IBaseDaoMongo commonDaoMongo;

	private static final Logger logger = LogManager.getLogger(AttachMentSerivceImpl.class);

	// 默认上传文件的路径
	public final static String UPLOAD_PATH = "/resources/upload";
	// 压缩器
	@Resource(name = "picThumbService")
	private IPicThumb picThumbService;

	@Override
	public File doUploadOneFileToServerDisk(MultipartFile attach, String newFileName, String dirpath)
			throws IOException {
		if (StringUtil.isEmpty(dirpath) || StringUtil.isEmpty(newFileName)) {
			return null;
		}

		String newFilePath = dirpath + "/" + newFileName;

		FileUtil.creatParentDir(newFilePath);

		// 进行文件拷贝
		File f = new File(newFilePath);
		FileUtils.copyInputStreamToFile(attach.getInputStream(), f);
		return f;
	}

	@Override
	public Attachment uploadOneAttachmentToServerDisk(MultipartFile attach, HttpServletRequest request, String dirpath,
			boolean needCompress, List<ThumbParam> tps) throws IOException {

		if (attach.isEmpty()) {
			return null;
		}
		String ext = FilenameUtils.getExtension(attach.getOriginalFilename());
		String newFileName = EncoderHandler.encodeByAES(this.getUserId() + String.valueOf(new Date().getTime())) + "."
				+ ext;

		String uploadDir = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
		if (StringUtil.isNotEmpty(dirpath)) {
			uploadDir = uploadDir + "/" + dirpath;
		}

		// 1.进行文件上传
		File uploadedFile = doUploadOneFileToServerDisk(attach, newFileName, uploadDir);

		// 2.创建附件文件
		Attachment att = new Attachment();
		att.setSuffix(ext);
		att.setIsAttach(request.getParameter("isattach"));
		att.setIsIndexPic(request.getParameter("isindexpic"));
		att.setOriName(FilenameUtils.getBaseName(attach.getOriginalFilename()));
		att.setNewName(newFileName);
		att.setType(attach.getContentType());
		att.setSize(attach.getSize());
		att.setUploadDate(DateUtil.getCurdate());
		att.setUploadTime(DateUtil.getCurrentTimsmp());
		if (StringUtil.isNotEmpty(dirpath)) {
			att.setUploadDir(dirpath);
		}
		if (FileUtil.isImage(uploadedFile)) {
			att.setIsImg(true);
		} else {
			att.setIsImg(false);
		}
		att.setUploadFileAbsolutePath(uploadedFile.getAbsolutePath());

		// 3.进行缩略图压缩
		if (att.getIsImg().equals("1")) {
			if (needCompress && tps != null && tps.size() > 0) {

				for (ThumbParam tp : tps) {

					String folderName = tp.getFolderName();

					String thisFolderPath = uploadDir + "/" + folderName + "/";
					String thisThumbPath = thisFolderPath + newFileName;

					tp.setThumbParmPath(thisThumbPath);

					logger.debug(tp);
				}

				this.picThumbService.thumbFile(uploadedFile, tps);

				String compressedDir = dirpath + "/" + tps.get(0).getFolderName();
				if (StringUtil.isEmpty(dirpath)) {
					compressedDir = tps.get(0).getFolderName();
				}
				att.setCompressedDir(compressedDir);
				att.setThumb_info(tps);
			}
		}

		// 3.将附件写入附件表
		String _id = this.commonDaoMongo.insertOne(att);

		logger.debug("上传文件完毕，上传之后att---\n{}", att);
		// att.set_id(_id);

		logger.debug("上传文件完毕，上传之后的文件信息");
		logger.debug(this.commonDaoMongo.findOneById(_id, Attachment.class));

		return att;
	}

	/****
	 * 删除一个附件<br>
	 * 1.删除数据库中的信息 <br>
	 * 2.删除存储目录中的文件 <br>
	 * 3.如果文件是图片，删除缩略图的文件
	 * 
	 * @param _id_m
	 */
	public void deleteOneAttachment(String _id_m, HttpServletRequest request) {

		logger.debug("remove[" + _id_m + "]");
		Attachment att = this.commonDaoMongo.findOneById(_id_m, Attachment.class);

		// 1.删除数据库文件
		this.commonDaoMongo.removeById(_id_m, Attachment.class);

		// 2.删除原文件目录的文件
		String path = att.getUploadFileAbsolutePath();
		FileUtil.deleteFile(path);
		logger.debug("deleted[" + path + "]");

		// 3.删除图片缩略图文件
		if (att.getIsImg().equals("1")) {

			List<ThumbParam> tps = att.getThumb_info();

			if (tps != null && tps.size() > 0) {
				for (ThumbParam tp : tps) {
					String filetp = tp.getThumbParmPath();
					FileUtil.deleteFile(filetp);

					logger.debug("deleted-[{}]", filetp);
				}
			}
		}
	}

	@Override
	public String doUploadOneFileToMongo(File file) throws IOException {

		return this.commonDaoMongo.saveFile(file);
	}

	@Override
	public String doUploadOneFileToMongo(MultipartFile attach, String newFileName) throws IOException {

		return this.commonDaoMongo.saveFile(attach.getInputStream(), newFileName);
	}

	public void doRemoveOneFileFromMongo(String fileId) {

		this.commonDaoMongo.removeFile(fileId);

		logger.debug("从数据库中删除文件，文件的_id【{}】", fileId);
	}

	@Override
	public Attachment uploadOneAttachmentToMongo(MultipartFile attach, HttpServletRequest request, boolean needCompress,
			List<ThumbParam> tps) throws IOException {
		if (attach.isEmpty()) {
			return null;
		}

		String ext = FilenameUtils.getExtension(attach.getOriginalFilename());
		String newFileName = EncoderHandler.encodeByAES(this.getUserId() + String.valueOf(new Date().getTime())) + "."
				+ ext;

		// 0.存储到本地
		String uploadDir = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
		File savedFile = new File(uploadDir + "/" + newFileName);
		FileUtils.copyInputStreamToFile(attach.getInputStream(), savedFile);

		logger.debug("本地文件存放路径:\n{}", savedFile.getParentFile().getAbsolutePath());

		// 1.进行文件上传
		String id = doUploadOneFileToMongo(attach, newFileName);

		// 2.创建附件文件
		Attachment att = new Attachment();
		att.setFile_id(id);
		att.setSuffix(ext);
		att.setIsAttach(request.getParameter("isattach"));
		att.setIsIndexPic(request.getParameter("isindexpic"));
		att.setOriName(FilenameUtils.getBaseName(attach.getOriginalFilename()));
		att.setNewName(newFileName);
		att.setType(attach.getContentType());
		att.setSize(attach.getSize());
		att.setUploadDate(DateUtil.getCurdate());
		att.setUploadTime(DateUtil.getCurrentTimsmp());
		if (FileUtil.isImage(attach.getInputStream())) {
			att.setIsImg(true);
		} else {
			att.setIsImg(false);
		}

		// 3.进行缩略图压缩
		if (att.isImage()) {
			if (needCompress && tps != null && tps.size() > 0) {

				for (ThumbParam tp : tps) {

					String folderName = tp.getFolderName();

					String thisFolderPath = uploadDir + "/" + folderName + "/";
					String thisThumbPath = thisFolderPath + newFileName;

					tp.setThumbParmPath(thisThumbPath);

					logger.debug(tp);
				}

				this.picThumbService.thumbFile(savedFile, tps);

				att.setThumb_info(tps);
			}
		}

		// 4.将附件写入附件表
		String _id = this.commonDaoMongo.insertOne(att);
		att.set_id_m(_id);

		// 5.删除本地原文件（不删除压缩文件）
		boolean deletedflag = savedFile.delete();

		logger.debug("上传文件完毕，上传之后的文件信息");
		logger.debug(this.commonDaoMongo.findOneById(_id, Attachment.class));
		logger.debug("删除文件结果: {}", deletedflag);
		return att;
	}

	@Override
	public GridFSDBFile getById(String _id) {

		return this.commonDaoMongo.findFileBy_Id(_id);
	}

	@Override
	public Attachment getAttachMent(String _id) {

		return this.commonDaoMongo.findOneById(_id, Attachment.class);
	}

	@Override
	public Attachment uploadOneAttachmentToMongoOnlyCj(MultipartFile attach, MultipartHttpServletRequest request,
			boolean isCompress, ThumbParam tp) throws IOException {

		if (attach.isEmpty()) {
			return null;
		}

		String ext = FilenameUtils.getExtension(attach.getOriginalFilename());
		String newFilePath = EncoderHandler.encodeByAES(this.getUserId() + String.valueOf(new Date().getTime()));

		String newFileName = newFilePath + "." + ext;

		// 0.存储到本地
		String uploadDir = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
		File savedFile = new File(uploadDir + "/" + newFileName);
		FileUtils.copyInputStreamToFile(attach.getInputStream(), savedFile);

		logger.debug("本地文件存放路径:\n{}", savedFile.getParentFile().getAbsolutePath());

		// 裁剪图的绝对路径
		String thumbPath = null;

		boolean isImage = FileUtil.isImage(attach.getInputStream());

		// 1.如果需要裁剪，则直接裁剪，生成裁剪后的图片
		// 3.进行缩略图压缩
		if (isImage) {
			if (isCompress && tp != null) {

				String surfix = tp.getFolderName();

				thumbPath = uploadDir + "/" + newFilePath + surfix + "." + ext;

				tp.setThumbParmPath(thumbPath);

				this.picThumbService.thumbFileExactlyNoCompressFixed(savedFile, tp);

				logger.debug("裁剪文件路径\n{}", thumbPath);
			} else {
				thumbPath = savedFile.getAbsolutePath();
			}
		}

		// 1.上传裁剪的文件到数据库
		String id = doUploadOneFileToMongo(new File(thumbPath));

		// 2.创建附件文件
		Attachment att = new Attachment();
		att.setFile_id(id);
		att.setSuffix(ext);
		att.setIsAttach(request.getParameter("isattach"));
		att.setIsIndexPic(request.getParameter("isindexpic"));
		att.setOriName(FilenameUtils.getBaseName(attach.getOriginalFilename()));
		att.setNewName(newFileName);
		att.setType(attach.getContentType());
		att.setSize(attach.getSize());
		att.setUploadDate(DateUtil.getCurdate());
		att.setUploadTime(DateUtil.getCurrentTimsmp());
		att.setIsImg(isImage);

		// 4.将附件写入附件表
		String _id = this.commonDaoMongo.insertOne(att);
		att.set_id_m(_id);

		// 5.删除本地原文件
		String oriPath = savedFile.getAbsolutePath();
		logger.debug("原文件路径\n{}", oriPath);
		FileUtil.deleteFile(oriPath);
		FileUtil.deleteFile(thumbPath);

		logger.debug("上传文件完毕，上传之后的文件信息");
		logger.debug(this.commonDaoMongo.findOneById(_id, Attachment.class));

		return att;
	}

	@Override
	public void updateAttachById(String attachId, DBObject update) {
		DBObject updateResult = this.commonDaoMongo.updateOneById(attachId, null, update, Attachment.class);

		logger.debug("更新后，附件信息[{}]", updateResult);
	}

	@Override
	public void updateAttachOwnerIdById(String attachId, String ownerId) {

		DBObject update = new BasicDBObject();
		DBObject updateSet = new BasicDBObject();

		updateSet.put("owner_id", ownerId);
		update.put("$set", updateSet);

		this.updateAttachById(attachId, update);
		;
	}

	@Override
	public void deleteOneAttachment(String _id_m)  {

		Attachment att = this.commonDaoMongo.findOneById(_id_m, Attachment.class);
		if (att == null) {
			logger.debug("\n{}对应的附件不存在",_id_m);
			return;
		}

		// 1.删除附件对应的存储在数据库文件
		String fileId = att.getFile_id();
		doRemoveOneFileFromMongo(fileId);
		logger.debug("\n删除文件成功【{}】",fileId);

		// 2.删除attachment
		this.commonDaoMongo.removeById(_id_m, Attachment.class);

		// 3.删除图片缩略图文件
		if (att.getIsImg().equals("1")) {

			List<ThumbParam> tps = att.getThumb_info();

			if (tps != null && tps.size() > 0) {
				for (ThumbParam tp : tps) {
				}
			}
		}
	}

	/****
	 * 上传一个无任何处理的文件
	 */
	@Override
	public Attachment uploadOneAttachmentToMongo(HttpServletRequest request) {

		String oriFileName = ""; // 文件的全路径，绝对路径名加文件名
		String contentType = ""; // 文件的类型
		long size = 0; // 文件的大小，以字节为单位
		String ext = "";
		String uploadDir = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
		String newFilePath = uploadDir + "/";
		String newFileName = EncoderHandler.encodeByAES(this.getUserId() + DateUtil.getCurrentTimsmp());

		Attachment att = new Attachment();

		try {
			if ("application/octet-stream".equals(request.getContentType())) {
				String dispoString = request.getHeader("Content-Disposition");

				int iFindStart = dispoString.indexOf("filename=\"") + 10;
				int iFindEnd = dispoString.indexOf("\"", iFindStart);

				oriFileName = dispoString.substring(iFindStart, iFindEnd);
				ext = FilenameUtils.getExtension(oriFileName);
				newFileName = newFileName + "." + ext;
				newFilePath = newFilePath + newFileName;

				logger.debug("sFileName--[{}]", oriFileName);

				int i = request.getContentLength();

				byte buffer[] = new byte[i];
				int j = 0;
				while (j < i) { // 获取表单的上传文件
					int k = request.getInputStream().read(buffer, j, i - j);
					j += k;
				}

				if (buffer.length == 0) { // 文件是否为空
					return null;
				}

				OutputStream out = new BufferedOutputStream(new FileOutputStream(newFilePath, true));
				out.write(buffer);
				out.close();

				logger.debug("\n存储到文件成功\n{}", newFilePath);

				Path path = Paths.get(newFilePath);

				File f = new File(newFilePath);
				contentType = Files.probeContentType(path); // 文件的类型
				size = FileUtils.sizeOf(f);// 文件的大小，以字节为单位
			} else {

				String tempDirectory = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(1024 * 1024); // 设定了1M的缓冲区
				factory.setRepository(new File(tempDirectory)); // 设置上传文件的临时目录

				ServletFileUpload upload = new ServletFileUpload(factory);

				List<FileItem> items = upload.parseRequest(request); // 解析request请求
				Iterator iter = items.iterator();

				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (!item.isFormField()) { // 如果是表单域 ，就是非文件上传元素

						oriFileName = item.getName(); // 文件的全路径，绝对路径名加文件名
						contentType = item.getContentType(); // 文件的类型
						size = item.getSize(); // 文件的大小，以字节为单位

						ext = FilenameUtils.getExtension(oriFileName);
						newFileName = newFileName + "." + ext;
						newFilePath = newFilePath + newFileName;

						// 0.存储到本地
						File savedFile = new File(newFilePath);
						item.write(savedFile); // 把上传的内容写到一个文件中

						logger.debug("\n存储到目录{}\n文件\n{}", newFilePath, newFileName);
						logger.debug("本地文件存放路径:\n{}", savedFile.getParentFile().getAbsolutePath());
					}
				}
			}

			boolean isImage = FileUtil.isImage(new FileInputStream(newFilePath));

			// 1.上传到数据库
			String id = doUploadOneFileToMongo(new File(newFilePath));

			// 2.创建附件文件
			att.setFile_id(id);
			att.setSuffix(ext);
			att.setIsAttach(request.getParameter("isattach"));
			att.setIsIndexPic(request.getParameter("isindexpic"));
			att.setOriName(FilenameUtils.getBaseName(oriFileName));
			att.setNewName(newFileName);
			att.setType(contentType);
			att.setSize(size);
			att.setUploadDate(DateUtil.getCurdate());
			att.setUploadTime(DateUtil.getCurrentTimsmp());
			att.setIsImg(isImage);

			// 4.将附件写入附件表
			String _id = this.commonDaoMongo.insertOne(att);
			att.set_id_m(_id);

			// 5.删除本地原文件
			logger.debug("原文件路径\n{}", newFilePath);
			FileUtil.deleteFile(newFilePath);

			logger.debug("上传文件完毕，上传之后的文件信息");
			logger.debug(this.commonDaoMongo.findOneById(_id, Attachment.class));

			return att;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
