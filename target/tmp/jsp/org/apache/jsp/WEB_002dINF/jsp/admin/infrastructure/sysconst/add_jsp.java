package org.apache.jsp.WEB_002dINF.jsp.admin.infrastructure.sysconst;

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
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("input[readonly]{\r\n");
      out.write("  background-color: #eee;\r\n");
      out.write("    opacity: 1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input{\r\n");
      out.write("   border: 1px solid #ccc;\r\n");
      out.write("    border-radius: 4px;\r\n");
      out.write("    box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;\r\n");
      out.write("    color: #555;\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("    height: 34px;\r\n");
      out.write("    line-height: 1.42857;\r\n");
      out.write("    padding: 6px 12px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-control, input[readonly] , input.form-control[readonly]{\r\n");
      out.write("\tdisplay :inline!important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<input type=\"hidden\" name=\"ctx\" value=\"");
      out.print(request.getContextPath());
      out.write("\" />\r\n");
      out.write("\r\n");
      out.write("<ul class=\"breadcrumb\">\r\n");
      out.write("    <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/backend/sysconsttype/list\">系统常量类型管理</a> <span class=\"divider\"></span></li>\r\n");
      out.write("    <li class=\"active\">添加常量值</li>\r\n");
      out.write("</ul>\r\n");
      out.write("\t\r\n");
      out.write("<div id=\"add_div\" class=\"onepage\">\r\n");
      out.write("    <input type=\"hidden\" name=\"_id\" />\r\n");
      out.write("    ");
      if (_jspx_meth_sf_form_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\t\r\n");
      out.write("<script>\r\n");
      out.write("    $().ready(function() {\r\n");
      out.write("    \t\r\n");
      out.write("        $(\"#btn_save\").bind(\"click\", save);\r\n");
      out.write("        \r\n");
      out.write("        document.onkeydown = function(event) {\r\n");
      out.write("    \t\tif (event.keyCode == 13) {\r\n");
      out.write("    \t\t\treturn false;\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t}\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    //保存\r\n");
      out.write("    var save = function() {\r\n");
      out.write("\r\n");
      out.write("        // 控制按钮为禁用\r\n");
      out.write("        $.disableButton(\"btn_save\");\r\n");
      out.write("\r\n");
      out.write("        var paramForm = $('form').getFormParam_ux();\r\n");
      out.write("\r\n");
      out.write("        var successstr = \"新增成功\";\r\n");
      out.write("\r\n");
      out.write("        var url_to = \"");
      out.print(request.getContextPath());
      out.write("/backend/sysconst/add\";\r\n");
      out.write("        var url_success = \"");
      out.print(request.getContextPath());
      out.write("/backend/sysconsttype/manage_sysconst\";\r\n");
      out.write("        \r\n");
      out.write("        var params = [];\r\n");
      out.write("\t\tparams.push(\"typecode=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sysconst.typecode}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\");\r\n");
      out.write("\t\tparams.push(\"typename=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sysconst.typename}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\");\r\n");
      out.write("\t\tparams.push(\"ts=\" + new Date().getTime());\r\n");
      out.write("\t\t\r\n");
      out.write("\t\turl_success = url_success + \"?\" + params.join(\"&\");\r\n");
      out.write("\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            type: 'POST',\r\n");
      out.write("            url: url_to,\r\n");
      out.write("            data: $.extend({\r\n");
      out.write("                ts: new Date().getTime()\r\n");
      out.write("            },\r\n");
      out.write("            paramForm),\r\n");
      out.write("            type: 'POST',\r\n");
      out.write("            dataType: 'json',\r\n");
      out.write("            success: function(data) {\r\n");
      out.write("\r\n");
      out.write("                if (data['success'] == 'n') {\r\n");
      out.write("                    if (data['brErrors']) {\r\n");
      out.write("                        $.showBRErrors_mou_abs(data['brErrors'], $(\"#add_div\"));\r\n");
      out.write("                    } else {\r\n");
      out.write("                    \t$.alertError(data['message']);\r\n");
      out.write("                    }\r\n");
      out.write("                } else {\r\n");
      out.write("                \t\r\n");
      out.write("                \tvar callback = parent.data_manage_functions.closeAddWindow;\r\n");
      out.write("                \t\r\n");
      out.write("                \t$.alertSuccessCallback(\"成功\", successstr,callback);\r\n");
      out.write("                    //$.alertSuccessNewPage(\"成功\", successstr, url_success);\r\n");
      out.write("                }\r\n");
      out.write("            },\r\n");
      out.write("            complete: function(XMLHttpRequest, textStatus) {\r\n");
      out.write("                $.enableButton(\"btn_save\");\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    };\r\n");
      out.write("</script>\r\n");
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
    _jspx_th_sf_form_0.setModelAttribute("sysconst");
    _jspx_th_sf_form_0.setDynamicAttribute(null, "class", new String("form-horizontal"));
    int[] _jspx_push_body_count_sf_form_0 = new int[] { 0 };
    try {
      int _jspx_eval_sf_form_0 = _jspx_th_sf_form_0.doStartTag();
      if (_jspx_eval_sf_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("    \t\t\r\n");
          out.write("    \t\t<div class=\"form-group \">\r\n");
          out.write("\t            <label for=\"typecode\" class=\"col-sm-2 control-label\">\r\n");
          out.write("\t                常量类型码\r\n");
          out.write("\t            </label>\r\n");
          out.write("\t            <div class=\"col-sm-5\">\r\n");
          out.write("\t                <input type=\"text\" class=\"form-control\"   id=\"typecode\" name=\"typecode\" placeholder=\"\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sysconst.typecode}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" readonly>\r\n");
          out.write("\t            </div>\r\n");
          out.write("\t        </div>\r\n");
          out.write("\t        <div class=\"form-group \">\r\n");
          out.write("\t            <label for=\"typename\" class=\"col-sm-2 control-label\">\r\n");
          out.write("\t                常量类型\r\n");
          out.write("\t            </label>\r\n");
          out.write("\t            <div class=\"col-sm-5\">\r\n");
          out.write("\t                <input type=\"text\" class=\"form-control\" id=\"typename\" name=\"typename\" placeholder=\"\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sysconst.typename}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" readonly>\r\n");
          out.write("\t            </div>\r\n");
          out.write("\t        </div>\r\n");
          out.write("      \t\t<div class=\"form-group \">\r\n");
          out.write("\t            <label for=\"val\" class=\"col-sm-2 control-label\">\r\n");
          out.write("\t                常量值\r\n");
          out.write("\t            </label>\r\n");
          out.write("\t            <div class=\"col-sm-5\">\r\n");
          out.write("\t                <input type=\"text\" class=\"form-control\" id=\"val\" name=\"val\" placeholder=\"\" >\r\n");
          out.write("\t            </div>\r\n");
          out.write("\t        </div>\r\n");
          out.write("      \t\t<div class=\"form-group \">\r\n");
          out.write("\t            <label for=\"dspval\" class=\"col-sm-2 control-label\">\r\n");
          out.write("\t                常量显示值\r\n");
          out.write("\t            </label>\r\n");
          out.write("\t            <div class=\"col-sm-5\">\r\n");
          out.write("\t                <input type=\"text\" class=\"form-control\" id=\"dspval\" name=\"dspval\" placeholder=\"\" >\r\n");
          out.write("\t            </div>\r\n");
          out.write("\t        </div>\r\n");
          out.write("      \t\t<div class=\"form-group \">\r\n");
          out.write("\t            <label for=\"valordernum\" class=\"col-sm-2 control-label\">\r\n");
          out.write("\t                常量值顺序号\r\n");
          out.write("\t            </label>\r\n");
          out.write("\t            <div class=\"col-sm-5\">\r\n");
          out.write("\t                <input type=\"text\" class=\"form-control\" id=\"valordernum\" name=\"valordernum\" placeholder=\"\" >\r\n");
          out.write("\t            </div>\r\n");
          out.write("\t        </div>\r\n");
          out.write("        \r\n");
          out.write("        <hr/>\r\n");
          out.write("        <div class=\"col-sm-7\">\r\n");
          out.write("        \t<button type=\"button\" id=\"btn_save\" class=\"btn btn-primary btn-lg center-block\">提交</button>\r\n");
          out.write("        </div>\r\n");
          out.write("    ");
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
