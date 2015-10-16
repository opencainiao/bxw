package org.apache.jsp.WEB_002dINF.jsp.front.client.client_005finfo.include_005fseg;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class source_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<div class=\"panel-heading\">来源信息</div>\r\n");
      out.write("\t<div class=\"panel-body\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-xs-6\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"introducer_name\" class=\"col-sm-3 control-label\">\r\n");
      out.write("\t\t\t\t\t\t\t介绍人 </label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"introducer_name\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"introducer_name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.introducer_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"source_type\" class=\"col-sm-3 control-label\">客户来源\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t<select id=\"source_type\" name=\"source_type\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-src=\"constant\" data-typecode=\"SOURCE_TYPE\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.source_type}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"contact_type\" class=\"col-sm-3 control-label\">可接触度\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t<select id=\"contact_type\" name=\"contact_type\" data-src=\"constant\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-typecode=\"CONTACT_TYPE\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.contact_type}", java.lang.String.class, (PageContext)_jspx_page_context, null));
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
      out.write("\t\t\t\t\t\t\t<label for=\"introducer_relationship\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"col-sm-3 control-label\">与介绍人关系 </label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"introducer_relationship\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"introducer_relationship\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-src=\"constant\" data-typecode=\"INTRODUCER_RELATIONSHIP\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.introducer_relationship}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"introducer_closeness\" class=\"col-sm-3 control-label\">与介绍人亲密度\r\n");
      out.write("\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"introducer_closeness\" name=\"introducer_closeness\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-src=\"constant\" data-typecode=\"INTRODUCER_CLOSENESS\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.introducer_closeness}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-xs-6\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-12 form-horizontal\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"phone_info\" class=\"col-xs-3 control-label\">\r\n");
      out.write("\t\t\t\t\t\t\t\t介绍人评价 </label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-xs-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid=\"introducer_evaluation\" name=\"introducer_evaluation\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.introducer_evaluation}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"width: 480px;\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"phone_info\" class=\"col-xs-3 control-label\">\r\n");
      out.write("\t\t\t\t\t\t\t\t联系注意问题 </label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-xs-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"contact_attention\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"contact_attention\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.contact_attention}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"width: 480px;\">\r\n");
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
