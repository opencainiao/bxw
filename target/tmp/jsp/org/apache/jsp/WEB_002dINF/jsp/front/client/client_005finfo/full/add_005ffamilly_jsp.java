package org.apache.jsp.WEB_002dINF.jsp.front.client.client_005finfo.full;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_005ffamilly_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sf_form_modelAttribute_class;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_sf_form_modelAttribute_class = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_sf_form_modelAttribute_class.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<input type=\"hidden\" name=\"ctx\" value=\"");
      out.print(request.getContextPath());
      out.write("\" />\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"add_div\">\r\n");
      out.write("\t\t");
      if (_jspx_meth_sf_form_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$().ready(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t$(\"#btn_save\").bind(\"click\", save);\r\n");
      out.write("\r\n");
      out.write("\t\t\t$(\"#family_choose_div\").bind(\"click\", parent.popUpChooseClient);\r\n");
      out.write("\r\n");
      out.write("\t\t\tdocument.onkeydown = function(event) {\r\n");
      out.write("\t\t\t\tif (event.keyCode == 13) {\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t//设置选择的客户\t\t\r\n");
      out.write("\t\tfunction setSelectedClient(obj) {\r\n");
      out.write("\t\t\t//$.alertObjJson(obj);\r\n");
      out.write("\r\n");
      out.write("\t\t\t$(\"#s_id\").val(obj[\"_id_m\"]);\r\n");
      out.write("\t\t\t$(\"#s_name\").val(obj[\"client_name\"]);\r\n");
      out.write("\t\t\t$(\"#s_sex\").val(obj[\"sex\"] == '男' ? 1 : 0);\r\n");
      out.write("\r\n");
      out.write("\t\t\t$(\"#family_choose\").val(obj[\"client_name\"]);\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction refresh_parent() {\r\n");
      out.write("\t\t\tparent.refreshFamillyWindow();\r\n");
      out.write("\t\t\tparent.closeAddFamillyWindow();\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t//保存\r\n");
      out.write("\t\t// 同步（因为要添加成功后，刷新父页面的亲属列表）\r\n");
      out.write("\t\tvar save = function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar paramForm = $('form').getFormParam_ux();\r\n");
      out.write("\r\n");
      out.write("\t\t\t//console.log(JSON.stringify(paramForm));\r\n");
      out.write("\t\t\t//return;\r\n");
      out.write("\r\n");
      out.write("\t\t\t// 控制按钮为禁用\r\n");
      out.write("\t\t\t$.disableButton(\"btn_save\");\r\n");
      out.write("\t\t\tvar successstr = \"新增成功\";\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar url_to = $.getSitePath() + '/front/familly/add';\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\turl : url_to,\r\n");
      out.write("\t\t\t\tdata : $.extend({\r\n");
      out.write("\t\t\t\t\tts : new Date().getTime()\r\n");
      out.write("\t\t\t\t}, paramForm),\r\n");
      out.write("\t\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\t\tasync : false,\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tif (data['success'] == 'n') {\r\n");
      out.write("\t\t\t\t\t\tif (data['brErrors']) {\r\n");
      out.write("\t\t\t\t\t\t\t$.showBRErrors_mou_abs(data['brErrors'], $(\"#add_div\"));\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t$.alertError(data['message']);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\tvar callback = refresh_parent;\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t$.alertSuccessCallback(\"成功\", successstr, callback, [ '30px', '' ]);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tcomplete : function(XMLHttpRequest, textStatus) {\r\n");
      out.write("\t\t\t\t\t$.enableButton(\"btn_save\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t};\r\n");
      out.write("\t</script>\r\n");
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

  private boolean _jspx_meth_sf_form_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:form
    org.springframework.web.servlet.tags.form.FormTag _jspx_th_sf_form_0 = (org.springframework.web.servlet.tags.form.FormTag) _jspx_tagPool_sf_form_modelAttribute_class.get(org.springframework.web.servlet.tags.form.FormTag.class);
    _jspx_th_sf_form_0.setPageContext(_jspx_page_context);
    _jspx_th_sf_form_0.setParent(null);
    _jspx_th_sf_form_0.setModelAttribute("clientrelationship");
    _jspx_th_sf_form_0.setDynamicAttribute(null, "class", new String("form-horizontal"));
    int[] _jspx_push_body_count_sf_form_0 = new int[] { 0 };
    try {
      int _jspx_eval_sf_form_0 = _jspx_th_sf_form_0.doStartTag();
      if (_jspx_eval_sf_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t<input type=\"hidden\" id=\"f_id\" name=\"f_id\"\r\n");
          out.write("\t\t\t\tvalue=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clientrelationship.f_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("\t\t\t<input type=\"hidden\" id=\"f_name\" name=\"f_name\"\r\n");
          out.write("\t\t\t\tvalue=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clientrelationship.f_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("\t\t\t<input type=\"hidden\" id=\"f_sex\" name=\"f_sex\"\r\n");
          out.write("\t\t\t\tvalue=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clientrelationship.f_sex}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("\r\n");
          out.write("\t\t\t<input type=\"hidden\" id=\"s_id\" name=\"s_id\"\r\n");
          out.write("\t\t\t\tvalue=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clientrelationship.s_id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("\t\t\t<input type=\"hidden\" id=\"s_name\" name=\"s_name\"\r\n");
          out.write("\t\t\t\tvalue=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clientrelationship.s_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("\t\t\t<input type=\"hidden\" id=s_sex name=\"s_sex\"\r\n");
          out.write("\t\t\t\tvalue=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clientrelationship.s_sex}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("\r\n");
          out.write("\t\t\t<div class=\"container-fluid\" style=\"margin-top: 30px\">\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t<div class=\"panel panel-info\">\r\n");
          out.write("\t\t\t\t\t<div class=\"panel-heading hide\">添加家庭成员</div>\r\n");
          out.write("\t\t\t\t\t<div class=\"panel-body\">\r\n");
          out.write("\t\t\t\t\t\t<div class=\"row\">\r\n");
          out.write("\t\t\t\t\t\t\t<div class=\"col-xs-6\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"relationship\" class=\"col-sm-3 control-label\">姓名\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</label>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<input class=\"form-control\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clientrelationship.f_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" readonly>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t<div class=\"col-xs-6\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-md-12 form-horizontal\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<label for=\"relationshi_f\" class=\"col-sm-3 control-label\">身份\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</label>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<select id=\"relationship_f\" name=\"relationship_f\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"form-control\" data-src=\"constant\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tdata-typecode=\"FAMILLY_RELATIONSHIP\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tdata-value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clientrelationship.relationship}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</select>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t<div class=\"row\">\r\n");
          out.write("\t\t\t\t\t\t\t<div class=\"col-xs-6\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"family_income_feature\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"col-sm-3 control-label\">选择 </label>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"input-group\" id=\"family_choose_div\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"family_choose\" name=\"family_choose\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"form-control\" readonly> <span\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"input-group-btn\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<button class=\"btn btn-default btn-sm\" type=\"button\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-chevron-right\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\taria-hidden=\"true\"></span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</button>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"relationship_cmt\" class=\"col-sm-3 control-label\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t关系说明 </label>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"relationship_cmt\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\tname=\"relationship_cmt\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clientrelationship.relationship_cmt}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\tplaceholder=\"\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t<div class=\"col-xs-6\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-md-12 form-horizontal\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<label for=\"relationship_s\" class=\"col-sm-3 control-label\">身份\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</label>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<select id=\"relationship_s\" name=\"relationship_s\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"form-control\" data-src=\"constant\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tdata-typecode=\"FAMILLY_RELATIONSHIP\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tdata-value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clientrelationship.relationship}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t</select>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t<hr />\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t<div class=\"col-sm-12\">\r\n");
          out.write("\t\t\t\t\t<button type=\"button\" id=\"btn_save\"\r\n");
          out.write("\t\t\t\t\t\tclass=\"btn btn-primary btn-lg center-block\">提交</button>\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t");
          int evalDoAfterBody = _jspx_th_sf_form_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_sf_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_form_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_form_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_form_0.doFinally();
      _jspx_tagPool_sf_form_modelAttribute_class.reuse(_jspx_th_sf_form_0);
    }
    return false;
  }
}
