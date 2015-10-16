package org.apache.jsp.WEB_002dINF.jsp.front.client.client_005finfo.include_005fseg;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class familly_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div class=\"panel panel-info\">\r\n");
      out.write("\t<div class=\"panel-heading\">家庭信息</div>\r\n");
      out.write("\t<div class=\"panel-body\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-xs-6\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-12 form-horizontal\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group form-group-sm   \">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"marital_status\" class=\"col-sm-3 control-label\">婚姻\r\n");
      out.write("\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"marital_status\" name=\"marital_status\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"form-control\" data-src=\"constant\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-typecode=\"MARITAL_STATUS\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.marital_status}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group form-group-sm   \">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"wedding_date\" class=\"col-sm-3 control-label\">结婚纪念日\r\n");
      out.write("\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"wedding_date\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"wedding_date\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.marital_status}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tplaceholder=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-xs-6\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-12 form-horizontal\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group form-group-sm \">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"boy_num\" class=\"col-sm-3 control-label\"> 男孩数\r\n");
      out.write("\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"boy_num\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"boy_num\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.boy_num}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group form-group-sm \">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"girl_num\" class=\"col-sm-3 control-label\"> 女孩数\r\n");
      out.write("\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"girl_num\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"girl_num\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.girl_num}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group form-group-sm hide\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"children_num\" class=\"col-sm-3 control-label\">\r\n");
      out.write("\t\t\t\t\t\t\t\t子女数 </label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"children_num\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"children_num\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.children_num}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t\r\n");
      out.write("</script>");
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
