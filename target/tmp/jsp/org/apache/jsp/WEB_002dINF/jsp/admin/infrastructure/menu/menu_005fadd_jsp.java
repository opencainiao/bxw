package org.apache.jsp.WEB_002dINF.jsp.admin.infrastructure.menu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sf_form_modelAttribute;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_sf_form_modelAttribute = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_sf_form_modelAttribute.release();
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
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<input type=\"hidden\" name=\"ctx\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("\t<div id=\"content_inner_page\">\r\n");
      out.write("\t\t<ul class=\"breadcrumb\">\r\n");
      out.write("\t\t\t<li class=\"active\"><div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t\t<button class=\"btn btn-info btn-sm\" type=\"button\" id=\"btn_save\">\r\n");
      out.write("\t\t\t\t\t\t保存</button>\r\n");
      out.write("\t\t\t\t</div></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_sf_form_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$(\"#btn_save\").click(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t// 控制按钮为禁用\r\n");
      out.write("\t\t\t$.disableButton(\"btn_save\");\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar paramForm = $('form').getFormParam_ux();\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar successstr = \"添加菜单成功\";\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar url_to = $.getSitePath() + \"/backend/menu/add\";\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar params = [];\r\n");
      out.write("\t\t\tparams.push(\"ts=\" + new Date().getTime());\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//url_success = url_success + \"?\" + params.join(\"&\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\turl : url_to,\r\n");
      out.write("\t\t\t\tdata : $.extend({\r\n");
      out.write("\t\t\t\t\tts : new Date().getTime()\r\n");
      out.write("\t\t\t\t}, paramForm),\r\n");
      out.write("\t\t\t\ttype : 'POST',\r\n");
      out.write("\t\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tif (data['success'] == 'n') {\r\n");
      out.write("\t\t\t\t\t\tif (data['brErrors']) {\r\n");
      out.write("\t\t\t\t\t\t\t$.showBRErrors_mou_abs(data['brErrors'], $(\"#content_inner_page\"));\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t$.alertError(data['message']);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\tvar callback = parent.closeAddSubMenuWindow;\r\n");
      out.write("\t                \t\r\n");
      out.write("\t                \t$.alertSuccessCallback(\"成功\", successstr,callback);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tcomplete : function(XMLHttpRequest, textStatus) {\r\n");
      out.write("\t\t\t\t\t$.enableButton(\"btn_save\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
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

  private boolean _jspx_meth_sf_form_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:form
    org.springframework.web.servlet.tags.form.FormTag _jspx_th_sf_form_0 = (org.springframework.web.servlet.tags.form.FormTag) _jspx_tagPool_sf_form_modelAttribute.get(org.springframework.web.servlet.tags.form.FormTag.class);
    _jspx_th_sf_form_0.setPageContext(_jspx_page_context);
    _jspx_th_sf_form_0.setParent(null);
    _jspx_th_sf_form_0.setModelAttribute("menu");
    int[] _jspx_push_body_count_sf_form_0 = new int[] { 0 };
    try {
      int _jspx_eval_sf_form_0 = _jspx_th_sf_form_0.doStartTag();
      if (_jspx_eval_sf_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t<input type=\"hidden\" id=\"sup_menu_code\" name=\"sup_menu_code\"\r\n");
          out.write("\t\t\t\tvalue=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${SUPMNUCOD}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" />\r\n");
          out.write("\t\t\t<div class=\"container-fluid\" style=\"margin-top: 10px\">\r\n");
          out.write("\t\t\t\t<div class=\"row\">\r\n");
          out.write("\t\t\t\t\t<div class=\"col-xs-6\">\r\n");
          out.write("\t\t\t\t\t\t<div class=\"row\">\r\n");
          out.write("\t\t\t\t\t\t\t<div class=\"col-md-12 form-horizontal\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<label for=\"menu_name\" class=\"col-sm-3 control-label\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t菜单名称 </label>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"menu_name\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"menu_name\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu.menu_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" placeholder=\"\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<label for=\"module_code\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\tclass=\"col-sm-3 col-xs-3 control-label\"> 所属模块</label>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-8 col-xs-8\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<select id=\"module_code\" name=\"module_code\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"form-control\" data-src=\"constant\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\tdata-typecode=\"SYS_MODULE\" \r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\tdata-value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu.module_code}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></select> </select>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<label for=\"leaf_flg_name\" class=\"col-sm-3 control-label\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t是否启用 </label>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<select name=\"useflg\" class=\"form-control\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"0\">不启用</option>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"1\" selected=\"selected\">启用</option>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t</div>\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t<div class=\"col-xs-6\">\r\n");
          out.write("\t\t\t\t\t\t<div class=\"row\">\r\n");
          out.write("\t\t\t\t\t\t\t<div class=\"col-md-12 form-horizontal\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<label for=\"SUPMNUCODNAM\" class=\"col-sm-3 control-label\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t父菜单 </label>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<input id=\"SUPMNUCODNAM\" name=\"SUPMNUCODNAM\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\tplaceholder=\"请输入日期\" class=\"laydate-icon form-control dateipt\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${SUPMNUCODNAM}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" readonly>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<label for=\"menu_level\" class=\"col-sm-3 control-label\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t级次 </label>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<input id=\"menu_level\" name=\"menu_level\" placeholder=\"请输入日期\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"laydate-icon form-control dateipt\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${THISMNULVL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" readonly>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<label for=\"iclass\" class=\"col-sm-3 control-label\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t图标class </label>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"iclass\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"iclass\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu.iclass}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" placeholder=\"\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t<div class=\"row\">\r\n");
          out.write("\t\t\t\t\t<div class=\"col-xs-6\">\r\n");
          out.write("\t\t\t\t\t\t<div class=\"row\">\r\n");
          out.write("\t\t\t\t\t\t\t<div class=\"col-md-12 form-horizontal\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<label for=\"path\" class=\"col-xs-3 control-label\"> 链接 </label>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-9\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"path\" name=\"path\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu.path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" placeholder=\"\" style=\"width: 500px;\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"form-group form-group-sm  \">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<label for=\"remark\" class=\"col-xs-3 control-label\"> 备注\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</label>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-9\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"remark\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"remark\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu.remark}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" placeholder=\"\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: 500px;\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t<hr />\r\n");
          out.write("\t\t\t</div>\r\n");
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
      _jspx_tagPool_sf_form_modelAttribute.reuse(_jspx_th_sf_form_0);
    }
    return false;
  }
}
