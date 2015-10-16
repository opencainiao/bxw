package org.apache.jsp.WEB_002dINF.jsp.admin.infrastructure.sysconsttype;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manage_005fsysconst_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/admin/infrastructure/sysconst/list.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write(".content_label {\r\n");
      out.write("\tpadding-bottom: 7px;\r\n");
      out.write("\tbackground-color: #eee;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<input type=\"hidden\" name=\"ctx\" value=\"");
      out.print(request.getContextPath());
      out.write("\" />\r\n");
      out.write("\r\n");
      out.write("\t<ul class=\"breadcrumb\">\r\n");
      out.write("\t\t<li><a\r\n");
      out.write("\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/backend/sysconsttype/list\">系统常量类型管理</a>\r\n");
      out.write("\t\t\t<span class=\"divider\"></span></li>\r\n");
      out.write("\t\t<li class=\"active\">管理常量值</li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"content_inner_page\" class=\"innercontent\">\r\n");
      out.write("\t\t<div class=\"navbar navbar-default\">\r\n");
      out.write("\t\t\t<form class=\"navbar-form navbar-left\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-primary\" type=\"button\" id=\"btn_add\" style=\"\">\r\n");
      out.write("\t\t\t\t\t添加常量</button>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"panel panel-default\">\r\n");
      out.write("\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-6 col-sm-6 col-xs-6 form-horizontal\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"typecode\" class=\"col-sm-3 col-xs-3 control-label\">\r\n");
      out.write("\t\t\t\t\t\t\t\t类型编码 </label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-6 col-xs-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"typecode\" id=\"typecode\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sysconsttype.typecode }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-6 col-sm-6 col-xs-6 form-horizontal\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"typename\" class=\"col-sm-3 col-xs-3 control-label\">\r\n");
      out.write("\t\t\t\t\t\t\t\t类型名称 </label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-6 col-xs-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"typename\" id=\"typename\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sysconsttype.typename  }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"data_manage\" style=\"margin-top: 20px;\">\r\n");
      out.write("\t\t\t<table id=\"list\"></table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
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
