package org.apache.jsp.WEB_002dINF.jsp.front.client.client_005finfo.include_005fseg;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class xg_005finfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<div class=\"panel-heading\">性格相关</div>\r\n");
      out.write("\t<div class=\"panel-body\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-xs-6\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"birth_ages\" class=\"col-sm-3 control-label\">出生年代\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t<select id=\"birth_ages\" name=\"birth_ages\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-src=\"constant\" data-typecode=\"BIRTH_AGES\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.birth_ages}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"blood_group\" class=\"col-sm-3 control-label\">血型\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t<select id=\"blood_group\" name=\"blood_group\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-src=\"constant\" data-typecode=\"BLOOD_GROUP\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.blood_group}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"pdp_type\" class=\"col-sm-3 control-label\">PDP类型\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t<select id=\"pdp_type\" name=\"pdp_type\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-src=\"constant\" data-typecode=\"PDP_TYPE\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.pdp_type}", java.lang.String.class, (PageContext)_jspx_page_context, null));
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
      out.write("\t\t\t\t\t\t\t<label for=\"age_group\" class=\"col-sm-3 control-label\">年龄段\r\n");
      out.write("\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"age_group\" name=\"age_group\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-src=\"constant\" data-typecode=\"AGE_GROUP\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.age_group}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"constellation\" class=\"col-sm-3 control-label\">星座\r\n");
      out.write("\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"constellation\" name=\"constellation\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"form-control\" data-src=\"constant\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-typecode=\"CONSTELLATION\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.constellation}", java.lang.String.class, (PageContext)_jspx_page_context, null));
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
      out.write("\t\t\t\t\t\t\t\t性格特点 </label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-xs-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"temperament_type\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"temperament_type\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.temperament_type}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"width: 480px;\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"phone_info\" class=\"col-xs-3 control-label\">\r\n");
      out.write("\t\t\t\t\t\t\t\t兴趣爱好 </label>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-xs-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"hobbies\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"hobbies\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.hobbies}", java.lang.String.class, (PageContext)_jspx_page_context, null));
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
