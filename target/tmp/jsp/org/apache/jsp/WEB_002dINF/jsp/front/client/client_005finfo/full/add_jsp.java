package org.apache.jsp.WEB_002dINF.jsp.front.client.client_005finfo.full;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<ul class=\"breadcrumb\">\r\n");
      out.write("\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/front/client/list\">客户管理</a>\r\n");
      out.write("\t\t\t<span class=\"divider\"></span></li>\r\n");
      out.write("\t\t<li class=\"active\">添加用户</li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<div id=\"add_div\">\r\n");
      out.write("\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"_id\" />\r\n");
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
      out.write("\t\t\tdocument.onkeydown = function(event) {\r\n");
      out.write("\t\t\t\tif (event.keyCode == 13) {\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t//保存\r\n");
      out.write("\t\tvar save = function() {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar phone_info = getPhoneInfo();\r\n");
      out.write("\t\t\tvar address_info = getAddressInfo();\r\n");
      out.write("\t\t\tvar region_info = getReginInfo();\r\n");
      out.write("\t\t\tvar interesting_service = getIntrestedService();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar paramForm = $('form').getFormParam_ux();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tparamForm =  $.extend(paramForm,phone_info);\r\n");
      out.write("\t\t\tparamForm =  $.extend(paramForm,address_info);\r\n");
      out.write("\t\t\tparamForm =  $.extend(paramForm,region_info);\r\n");
      out.write("\t\t\tparamForm =  $.extend(paramForm,interesting_service);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//console.log(JSON.stringify(paramForm));\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//return;\r\n");
      out.write("\r\n");
      out.write("\t\t\t// 控制按钮为禁用\r\n");
      out.write("\t\t\t$.disableButton(\"btn_save\");\r\n");
      out.write("\t\t\tvar successstr = \"新增成功\";\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar url_to = $.getSitePath() + \"/front/client/add\";\r\n");
      out.write("\t\t\tvar url_success = $.getSitePath() + \"/front/client/list\";\r\n");
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
      out.write("\t\t\t\t\t\t\t$.alertBRErrorMask(data['brErrors']);\r\n");
      out.write("\t\t\t\t\t\t\t$.showBRErrors_mou_abs(data['brErrors'], $(\"#add_div\"));\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t$.alertErrorMask(data['message']);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$.alertSuccessNewPage(\"成功\", successstr, url_success,[0.5, '#000']);\r\n");
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
    HttpServletRequest request = (HttpServletRequest)_jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  sf:form
    org.springframework.web.servlet.tags.form.FormTag _jspx_th_sf_form_0 = (org.springframework.web.servlet.tags.form.FormTag) _jspx_tagPool_sf_form_modelAttribute_class.get(org.springframework.web.servlet.tags.form.FormTag.class);
    _jspx_th_sf_form_0.setPageContext(_jspx_page_context);
    _jspx_th_sf_form_0.setParent(null);
    _jspx_th_sf_form_0.setModelAttribute("client");
    _jspx_th_sf_form_0.setDynamicAttribute(null, "class", new String("form-horizontal"));
    int[] _jspx_push_body_count_sf_form_0 = new int[] { 0 };
    try {
      int _jspx_eval_sf_form_0 = _jspx_th_sf_form_0.doStartTag();
      if (_jspx_eval_sf_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t");
          org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/front/client/client_info/include_seg/base_info.jsp", out, false);
          out.write("\r\n");
          out.write("\t\t\t\t");
          org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/front/client/client_info/include_seg/work_info.jsp", out, false);
          out.write("\r\n");
          out.write("\t\t\t\t");
          org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/front/client/client_info/include_seg/familly_info.jsp", out, false);
          out.write("\r\n");
          out.write("\t\t\t\t");
          org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/front/client/client_info/include_seg/income_info.jsp", out, false);
          out.write("\r\n");
          out.write("\t\t\t\t");
          org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/front/client/client_info/include_seg/source_info.jsp", out, false);
          out.write("\r\n");
          out.write("\t\t\t\t");
          org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/front/client/client_info/include_seg/xg_info.jsp", out, false);
          out.write("\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t<hr />\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\t\t\t\t<div class=\"col-sm-12\">\r\n");
          out.write("\t\t\t\t\t<button type=\"button\" id=\"btn_save\"\r\n");
          out.write("\t\t\t\t\t\tclass=\"btn btn-primary btn-lg center-block\">提交</button>\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\r\n");
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
