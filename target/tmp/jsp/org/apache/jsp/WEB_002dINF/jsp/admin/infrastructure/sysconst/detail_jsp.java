package org.apache.jsp.WEB_002dINF.jsp.admin.infrastructure.sysconst;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class detail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container-fluid inlineone\" style=\"margin-top: 30px\">\r\n");
      out.write("\t\t<div class=\"col form-horizontal center-block \" style=\"width: 400px\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group \">\r\n");
      out.write("\t\t\t\t\t<label for=\"val\" class=\"col-sm-3 control-label\"> 常量值 </label>\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"val\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"val\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sysconst.val}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-group \">\r\n");
      out.write("\t\t\t\t\t<label for=\"dspval\" class=\"col-sm-3 control-label\"> 常量显示值 </label>\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"dspval\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"dspval\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sysconst.dspval}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-group \">\r\n");
      out.write("\t\t\t\t\t<label for=\"typename\" class=\"col-sm-3 control-label\"> 常量类型 </label>\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"typename\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"typename\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sysconst.typename}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-group \">\r\n");
      out.write("\t\t\t\t\t<label for=\"valordernum\" class=\"col-sm-3 control-label\"> 常量值顺序号 </label>\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"valordernum\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"valordernum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sysconst.valordernum}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-group \">\r\n");
      out.write("\t\t\t\t\t<label for=\"type\" class=\"col-sm-3 control-label\"> 常量类型码 </label>\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"type\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"type\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sysconst.type}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
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
