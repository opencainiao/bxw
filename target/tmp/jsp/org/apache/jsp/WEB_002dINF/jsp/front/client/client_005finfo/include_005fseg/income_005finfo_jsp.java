package org.apache.jsp.WEB_002dINF.jsp.front.client.client_005finfo.include_005fseg;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class income_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<div class=\"panel-heading\">收入情况</div>\r\n");
      out.write("\t<div class=\"panel-body\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-xs-6\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"annual_income_personal\" class=\"col-sm-3 control-label\">\r\n");
      out.write("\t\t\t\t\t\t\t个人年收入 </label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"annual_income_personal\" name=\"annual_income_personal\"\r\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.annual_income_personal}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"annual_income_personal_type\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"col-sm-3 control-label\">年收入类型（个人） </label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t<select id=\"annual_income_personal_type\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"annual_income_personal_type\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-src=\"constant\" data-typecode=\"ANNUAL_INCOME_PERSONAL_TYPE\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.annual_income_personal_type}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"family_income_feature\" class=\"col-sm-3 control-label\">家庭收入特点\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t<select id=\"family_income_feature\" name=\"family_income_feature\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"form-control\" data-src=\"constant\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-typecode=\"FAMILY_INCOME_FEATURE\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.family_income_feature}", java.lang.String.class, (PageContext)_jspx_page_context, null));
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
      out.write("\t\t\t\t\t\t\t<label for=\"annual_income_family\" class=\"col-sm-3 control-label\">\r\n");
      out.write("\t\t\t\t\t\t\t\t（家庭）年收入 </label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid=\"annual_income_family\" name=\"annual_income_family\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.annual_income_family}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"annual_income_family_type\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"col-sm-3 control-label\">（家庭）年收入分类 </label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"annual_income_family_type\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"annual_income_family_type\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-src=\"constant\" data-typecode=\"ANNUAL_INCOME_FAMILY_TYPE\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.annual_income_family_type}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"family_financial_standing\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"col-sm-3 control-label\">（家庭）财务状况 </label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"family_financial_standing\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"family_financial_standing\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-src=\"constant\" data-typecode=\"FAMILY_FINANCIAL_STANDING\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.family_financial_standing}", java.lang.String.class, (PageContext)_jspx_page_context, null));
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
