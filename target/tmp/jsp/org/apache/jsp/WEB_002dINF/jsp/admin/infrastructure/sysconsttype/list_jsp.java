package org.apache.jsp.WEB_002dINF.jsp.admin.infrastructure.sysconsttype;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta content=\"IE=edge,chrome=1\" http-equiv=\"X-UA-Compatible\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/include/common_css.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/include/common_js.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/include/common_flexigrid.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<input type=\"hidden\" name=\"ctx\" value=\"");
      out.print(request.getContextPath());
      out.write("\" />\r\n");
      out.write("\r\n");
      out.write("\t<ul class=\"breadcrumb\">\r\n");
      out.write("\t\t<li class=\"active\">系统常量类型管理</li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"content_inner_page\" class=\"innercontent\" >\r\n");
      out.write("\t\t<div class=\"navbar navbar-default\">\r\n");
      out.write("\t\t    <form class=\"navbar-form navbar-left\" >\r\n");
      out.write("\t\t        <div class=\"form-group \" >\r\n");
      out.write("\t\t            <input class=\"form-control \" style=\"width:300px\" type=\"text\" id=\"search_condition\" name=\"search_condition\"  placeholder=\"输入名称进行查询\">\r\n");
      out.write("\t\t        </div>\r\n");
      out.write("\t\t        <button class=\"btn btn-info\" type=\"button\" id=\"btn_search\">\r\n");
      out.write("\t\t            查询\r\n");
      out.write("\t\t        </button>\r\n");
      out.write("\t\t        <button class=\"btn btn-primary\" type=\"button\" id=\"btn_add\" style=\"margin-left: 50px ;\">\r\n");
      out.write("\t\t            添加常量类型\r\n");
      out.write("\t\t        </button>\r\n");
      out.write("\t\t        <button class=\"btn btn-primary\" type=\"button\" id=\"btn_download\" style=\"margin-left: 50px ;\">\r\n");
      out.write("\t\t            <span class=\"glyphicon glyphicon-download-alt\" aria-hidden=\"true\"  style=\"margin-right: 8px;\"></span>下载所有常量信息\r\n");
      out.write("\t\t        </button>\r\n");
      out.write("\t\t    </form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"data_manage\" >\r\n");
      out.write("\t\t\t<table id=\"list\"></table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\"\r\n");
      out.write("\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/admin/infrastructure/sysconsttype/list.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
