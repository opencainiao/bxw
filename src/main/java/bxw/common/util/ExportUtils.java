package bxw.common.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

import bxw.common.globalobj.WorkbookConfig;

public class ExportUtils {

	/****
	 * 创建单sheet的workbook
	 * 
	 * @param wcg
	 * @param data
	 * @return
	 */
	public static HSSFWorkbook createSingSheetHSSFWorkbook(WorkbookConfig wcg, List data) {

		// 创建Excel
		HSSFWorkbook wb = new HSSFWorkbook();

		String sheetName = wcg.getSheetNames().get(0);

		HSSFSheet sheet = wb.createSheet(sheetName);
		try {
			String[] fields = wcg.getSheetFields().get(sheetName);

			// 获取类
			ExportUtils.outputHeaders(wcg, sheet);
			ExportUtils.outputColumns(fields, data, sheet, 1);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return wb;
	}

	/****
	 * 设置reponse的header
	 * 
	 * @param response
	 * @param fileName
	 *            下载的文件名
	 */
	public static void setHeader(HttpServletResponse response, String fileName) {
		try {
			String content_disposition = "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1")
					+ ".xls";
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", content_disposition);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置sheet表头信息
	 * 
	 * @param wcg
	 * @param sheet
	 */
	public static void outputHeaders(WorkbookConfig wcg, HSSFSheet sheet) {

		String sheetName = sheet.getSheetName();

		String[] titles = wcg.getSheetTitles().get(sheetName);

		Map<String, Integer> sheetWidths = null;

		Map<String, Map<String, Integer>> allWidths = wcg.getSheetWidths();
		if (allWidths != null) {
			sheetWidths = allWidths.get(sheetName);
		}

		// 设置颜色
		// http://www.cnblogs.com/caiyun/archive/2012/08/22/2650239.html
		HSSFCellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		cellStyle.setFillForegroundColor(HSSFColor.TEAL.index);
		// cellStyle.setFillForegroundColor(HSSFColor.WHITE.index);
		cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

		HSSFFont font = sheet.getWorkbook().createFont();
		// font.setFontName("黑体");
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 13);// 设置字体大小
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
		font.setColor(HSSFColor.WHITE.index);

		cellStyle.setFont(font);// 选择需要用到的字体格式

		// 设置边框
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框

		// 设置垂直居中
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直

		String[] fields = wcg.getSheetFields().get(sheetName);

		HSSFRow row = sheet.createRow(0);
		row.setHeight((short) 600);
		for (int i = 0; i < titles.length; i++) {

			if (sheetWidths != null) {

				if (sheetWidths.get(fields[i]) != null) {
					sheet.setColumnWidth(i, sheetWidths.get(fields[i]));
				} else {
					sheet.setColumnWidth(i, 4000);
				}
			} else {
				sheet.setColumnWidth(i, 4000);
			}

			HSSFCell cell = row.createCell(i);
			cell.setCellValue(titles[i]);

			cell.setCellStyle(cellStyle);
		}
	}

	public static String getType(Object obj, String propertyName) {
		Field field[] = obj.getClass().getDeclaredFields();

		for (Field f : field) {
			String fName = f.getName();
			String fType = f.getType().getSimpleName();

			if (fName.equals(propertyName)) {
				return fType;
			}
		}

		return "String";
	}

	public static void outputColumns(String[] headersInfo, List columnsInfo, HSSFSheet sheet, int rowIndex) {
		HSSFRow row;
		int headerSize = headersInfo.length;
		int columnSize = columnsInfo.size();
		// 循环插入多少行
		for (int i = 0; i < columnsInfo.size(); i++) {
			row = sheet.createRow(rowIndex + i);
			Object obj = columnsInfo.get(i);
			// 循环每行多少列
			for (int j = 0; j < headersInfo.length; j++) {

				String propertyName = headersInfo[j];
				String type = getType(obj, propertyName);

				// System.out.println(propertyName + "---[" + type + "]");

				Object value = getFieldValueByName(propertyName, obj);

				HSSFCell cell = row.createCell(j);

				HSSFCellStyle cellStyle = sheet.getWorkbook().createCellStyle();

				HSSFFont font = sheet.getWorkbook().createFont();
				font.setFontName("宋体");
				font.setFontHeightInPoints((short) 11);// 设置字体大小
				cellStyle.setFont(font);

				// 设置边框
				cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
				cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
				cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
				cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框

				if (type.equalsIgnoreCase("String")) {

					String cellValue = value.toString();

					if (cellValue.indexOf("<br>") >= 0) {
						cellStyle.setWrapText(true);// 先设置为自动换行

						cellValue = cellValue.replace("<br>", "\r\n");
						cell.setCellValue(cellValue);
					} else {
						cell.setCellValue(cellValue);
					}
				} else if (type.equalsIgnoreCase("int") || type.equalsIgnoreCase("integer")) {
					cell.setCellValue(Integer.parseInt(String.valueOf(value)));
				} else if (type.equalsIgnoreCase("double")) {
					cell.setCellValue(Double.parseDouble(String.valueOf(value)));
				} else {
					String cellValue = value.toString();

					if (cellValue.indexOf("<br>") >= 0) {
						cellStyle.setWrapText(true);// 先设置为自动换行

						cellValue = cellValue.replace("<br>", "\r\n");
						cell.setCellValue(cellValue);
					} else {
						cell.setCellValue(cellValue);
					}
				}

				cell.setCellStyle(cellStyle);
			}
		}

	}

	/**
	 * 根据对象的属性获取值
	 * 
	 * @param string
	 * @param obj
	 * @return
	 */
	private static Object getFieldValueByName(String fieldName, Object obj) {

		Object value = null;
		try {
			value = BeanUtils.getProperty(obj, fieldName);
		} catch (Exception e) {
			value = "";
			e.printStackTrace();
		}

		if (value == null) {
			value = "";
		}

		// System.out.println(fieldName + "--[" + value + "]");
		return value;

		// String firstLetter = fieldName.substring(0, 1).toUpperCase();
		// String getter = "get" + firstLetter + fieldName.substring(1);
		// try {
		// Method method = obj.getClass().getMethod(getter, new Class[] {});
		// Object value = method.invoke(obj, new Object[] {});
		// return value;
		// } catch (Exception e) {
		// e.printStackTrace();
		// return null;
		// }
	}
}
