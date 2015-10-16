package org.apache.jsp.WEB_002dINF.jsp.admin.user.profile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pic_005fupload_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<!-- add styles -->\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/pic-upload/css/main.css\" rel=\"stylesheet\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/pic-upload/css/jquery.Jcrop.min.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<!-- add scripts -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/include/common_js.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/include/common_css.jsp", out, false);
      out.write("\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/pic-upload/js/jquery.Jcrop.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/pic-upload/js/script.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/js/jquery.form.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<form id=\"upload_form\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"_id\" name=\"_id\" value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userid }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" />\r\n");
      out.write("\t\t<div class=\"input-group\" style=\"padding: 8px; padding-left: 10px\">\r\n");
      out.write("\t\t\t<input type=\"file\" name=\"image_file\" id=\"image_file\"\r\n");
      out.write("\t\t\t\tstyle=\"width: 88px;\" onChange=fileSelectHandler() class=\"pull-left\"\r\n");
      out.write("\t\t\t\trequired />\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"input-group-btn pull-left\" style=\"margin-left: 10px\">\r\n");
      out.write("\t\t\t\t<button name=\"btn_up\" id=\"btn_up\" type=\"button\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-primary\"\r\n");
      out.write("\t\t\t\t\tstyle=\"border-radius: 4px; margin-top: 2px;\">提交</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"bbody\" style=\"border-top: 1px solid black\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"x1\" name=\"x1\" /> <input type=\"hidden\"\r\n");
      out.write("\t\t\t\tid=\"y1\" name=\"y1\" /> <input type=\"hidden\" id=\"x2\" name=\"x2\" /> <input\r\n");
      out.write("\t\t\t\ttype=\"hidden\" id=\"y2\" name=\"y2\" />\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"step2\">\r\n");
      out.write("\t\t\t\t<img id=\"preview\" />\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"info\">\r\n");
      out.write("\t\t\t\t\t<label>文件大小</label> <input type=\"text\" id=\"filesize\"\r\n");
      out.write("\t\t\t\t\t\tname=\"filesize\" /> <label>类型</label> <input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\tid=\"filetype\" name=\"filetype\" /> <label>图像尺寸</label> <input\r\n");
      out.write("\t\t\t\t\t\ttype=\"text\" id=\"filedim\" name=\"filedim\" /> <label>宽度</label> <input\r\n");
      out.write("\t\t\t\t\t\ttype=\"text\" id=\"w\" name=\"w\" /> <label>高度</label> <input\r\n");
      out.write("\t\t\t\t\t\ttype=\"text\" id=\"h\" name=\"h\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tfunction validate() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t// 控制按钮为禁用\r\n");
      out.write("\t\t\t$.disableButton(\"btn_up\");\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (!checkForm()) {\r\n");
      out.write("\t\t\t\t$.enableButton(\"btn_up\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction uploadFile() {\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (!validate()) {\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar xhr = new XMLHttpRequest();\r\n");
      out.write("\t\t\tvar fd = new FormData(document.getElementById('upload_form'));\r\n");
      out.write("\r\n");
      out.write("\t\t\t//$.logJson(fd, \"参数\");\r\n");
      out.write("\t\t\txhr.addEventListener(\"load\", uploadComplete, false);\r\n");
      out.write("\t\t\txhr.addEventListener(\"error\", uploadFailed, false);\r\n");
      out.write("\t\t\txhr.open(\"POST\", \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/profile/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/update_head_img\");\r\n");
      out.write("\r\n");
      out.write("\t\t\txhr.send(fd);\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction uploadComplete(evt) {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$.enableButton(\"btn_up\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar data = JSON.parse(evt.target.responseText);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$.logJson(data);\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (data['success'] == 'n') {\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$.alertError(data['message']);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tvar _id_m = data[\"attach_id\"];\r\n");
      out.write("\t\t\t\tparent.refreshHeadImg(_id_m);\r\n");
      out.write("\t\t\t\twindow.top.refreshHeadImg(_id_m);\r\n");
      out.write("\t\t\t\tparent.closeUploadHeadImg();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction uploadFailed(evt) {\r\n");
      out.write("\t\t\talert(\"上传出错\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t$(document).ready(function() {\r\n");
      out.write("\t\t\t$(\"#btn_up\").click(function(e) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tuploadFile();\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
