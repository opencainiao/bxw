package org.apache.jsp.WEB_002dINF.jsp.front.client.client_005finfo.include_005fseg;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class work_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<div class=\"panel-heading\">工作信息</div>\r\n");
      out.write("\t<div class=\"panel-body\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-xs-6\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"company\" class=\"col-sm-3 control-label\"> 工作单位\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"company\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"company\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.company}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"trade_type\" class=\"col-sm-3 control-label\">行业类型\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t<select id=\"trade_type\" name=\"trade_type\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-src=\"constant\" data-typecode=\"TRADE_TYPE\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.trade_type}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"job_position\" class=\"col-sm-3 control-label\">职位\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t<select id=\"job_position\" name=\"job_position\" data-src=\"constant\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-typecode=\"JOB_POSITION\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.job_position}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-xs-6\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-12 form-horizontal\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"company_nature\" class=\"col-sm-3 control-label\">企业性质\r\n");
      out.write("\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"company_nature\" name=\"company_nature\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"form-control\" data-src=\"constant\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-typecode=\"COMPANY_NATURE\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.company_nature}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"career_type\" class=\"col-sm-3 control-label\">职业类型\r\n");
      out.write("\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"career_type\" name=\"career_type\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-src=\"constant\" data-typecode=\"CAREER_TYPE\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.career_type}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"job_level\" class=\"col-sm-3 control-label\">职级\r\n");
      out.write("\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"job_level\" name=\"job_level\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-src=\"constant\" data-typecode=\"JOB_LEVEL\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.job_level}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
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
      out.write("</script>\r\n");
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
