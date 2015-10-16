package org.apache.jsp.WEB_002dINF.jsp.front.client.client_005finfo.full;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class detail_005fpersinal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
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
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("dl {\r\n");
      out.write("    border-bottom: 1px solid #eee;\r\n");
      out.write("    bottom: -1px;\r\n");
      out.write("    position: relative;\r\n");
      out.write("    margin-bottom: 8px!important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("dl dt {\r\n");
      out.write("    clear: left;\r\n");
      out.write("    color: #888;\r\n");
      out.write("    float: left;\r\n");
      out.write("    line-height: 1.5;\r\n");
      out.write("    width: 150px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("dl dd {\r\n");
      out.write("    line-height: 1.5;\r\n");
      out.write("    margin-left: 60px;\r\n");
      out.write("    min-height: 18px;\r\n");
      out.write("    width: 320px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".panel-heading button{\r\n");
      out.write("\tmargin-top: -4px!important; \r\n");
      out.write("\tpadding-bottom: 3px!important; \r\n");
      out.write("\tpadding-top: 3px!important;\"\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("var client = {};\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("//$.alertObjJson(client);\r\n");
      out.write("\r\n");
      out.write("// 生成内容\r\n");
      out.write("function genContent(client,title,name){\r\n");
      out.write("\t\r\n");
      out.write("\tvar content = \"\";\r\n");
      out.write("\r\n");
      out.write("\tfor(var i=0;i<name.length;i++){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar item_name =  name[i];\r\n");
      out.write("\t\tvar item_title =  title[i];\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar item_value = client[item_title];\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (item_value != undefined){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar type_item = typeof(item_value);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif (type_item == \"string\"){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif (item_value != \"\"){\r\n");
      out.write("\t\t\t\t\tvar item_str = \"<dl><dt>\" + item_name + \"</dt><dd style='margin-left: 150px;'>\" + item_value + \"</dd></dl>\";\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tcontent = content + item_str;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tvar item_str = \"<dl><dt>\" + item_name + \"</dt><dd  style='margin-left: 150px;'>\" + item_value + \"</dd></dl>\";\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tcontent = content + item_str;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\treturn content;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var base_prop_title = [];\r\n");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("//alert(base_prop_title.join(\"\\n\"));\r\n");
      out.write("\r\n");
      out.write("var base_prop_name = [];\r\n");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("//$.alertObjJson(base_prop_name);\r\n");
      out.write("\r\n");
      out.write("// 生成基本模块内容\r\n");
      out.write("function genBaseContent(client){\r\n");
      out.write("\tvar content = genContent(client,base_prop_title,base_prop_name);\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#base_info_content\").html(content);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function toEditBase(){\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tvar url = $.getSitePath() + '/clientpartinfo/' + $(\"#_id_m\").val() + \"/update?part_flg=0\";\r\n");
      out.write("\t\r\n");
      out.write("\t//alert(url);\r\n");
      out.write("\r\n");
      out.write("\t$.popUpWindow(\"编辑客户基本信息\", url, \"90%\", \"90%\", \"edit\", $(\"#edit_base\"));\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function closeEditBase(){\r\n");
      out.write("\t\r\n");
      out.write("\t$.closeWindow(\"edit\", $(\"#edit_base\"));\r\n");
      out.write("}\r\n");
      out.write("function initBase(){\r\n");
      out.write("\tgenBaseContent(client);\r\n");
      out.write("\t\r\n");
      out.write("\t$('#edit_base').unbind();\r\n");
      out.write("\t$(\"#edit_base\").bind(\"click\", toEditBase);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function refreshBase(){\r\n");
      out.write("\t\r\n");
      out.write("\tvar url_to = $.getSitePath() + '/clientpartinfo/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client._id_m }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("\t\r\n");
      out.write("\t $.ajax({\r\n");
      out.write("        type: 'POST',\r\n");
      out.write("        url: url_to,\r\n");
      out.write("        data: {\r\n");
      out.write("            ts: new Date().getTime()\r\n");
      out.write("        },\r\n");
      out.write("        type: 'POST',\r\n");
      out.write("        dataType: 'json',\r\n");
      out.write("        success: function(data) {\r\n");
      out.write("       \t   client = data;\r\n");
      out.write("       \t   initBase();\r\n");
      out.write("        },\r\n");
      out.write("        complete: function(XMLHttpRequest, textStatus) {\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//-----------------------------------------------------------------------------------------------income\r\n");
      out.write("\r\n");
      out.write("var income_prop_title = [];\r\n");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("//alert(base_prop_title.join(\"\\n\"));\r\n");
      out.write("\r\n");
      out.write("var income_prop_name = [];\r\n");
      if (_jspx_meth_c_forEach_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("//$.alertObjJson(base_prop_name);\r\n");
      out.write("\r\n");
      out.write("// 生成模块内容\r\n");
      out.write("function genIncomeContent(client){\r\n");
      out.write("\tvar content = genContent(client,income_prop_title,income_prop_name);\r\n");
      out.write("\t$(\"#income_info_content\").html(content);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function toEditIncome(){\r\n");
      out.write("\t\r\n");
      out.write("\tvar url = $.getSitePath() + '/clientpartinfo/' + $(\"#_id_m\").val() + \"/update?part_flg=3\";\r\n");
      out.write("\t\r\n");
      out.write("\t$.popUpWindow(\"编辑客户收入信息\", url, \"90%\", \"80%\", \"edit\", $(\"#edit_income\"));\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function closeEditIncome(){\r\n");
      out.write("\t$.closeWindow(\"edit\", $(\"#edit_income\"));\r\n");
      out.write("}\r\n");
      out.write("function initIncome(){\r\n");
      out.write("\tgenIncomeContent(client);\r\n");
      out.write("\t\r\n");
      out.write("\t$('#edit_income').unbind();\r\n");
      out.write("\t$(\"#edit_income\").bind(\"click\", toEditIncome);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function refreshIncome(){\r\n");
      out.write("\t\r\n");
      out.write("\tvar url_to = $.getSitePath() + '/clientpartinfo/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client._id_m }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("\t\r\n");
      out.write("\t $.ajax({\r\n");
      out.write("        type: 'POST',\r\n");
      out.write("        url: url_to,\r\n");
      out.write("        data: {\r\n");
      out.write("            ts: new Date().getTime()\r\n");
      out.write("        },\r\n");
      out.write("        type: 'POST',\r\n");
      out.write("        dataType: 'json',\r\n");
      out.write("        success: function(data) {\r\n");
      out.write("       \t   client = data;\r\n");
      out.write("       \t   initIncome();\r\n");
      out.write("        },\r\n");
      out.write("        complete: function(XMLHttpRequest, textStatus) {\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//-----------------------------------------------------------------------------------------------family\r\n");
      out.write("\r\n");
      out.write("var family_prop_title = [];\r\n");
      if (_jspx_meth_c_forEach_4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("//alert(base_prop_title.join(\"\\n\"));\r\n");
      out.write("\r\n");
      out.write("var family_prop_name = [];\r\n");
      if (_jspx_meth_c_forEach_5(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("//$.alertObjJson(base_prop_name);\r\n");
      out.write("\r\n");
      out.write("// 生成基本模块内容\r\n");
      out.write("function genFamilyContent(client){\r\n");
      out.write("\tvar content = genContent(client,family_prop_title,family_prop_name);\r\n");
      out.write("\t$(\"#family_info_content\").html(content);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function toEditFamily(){\r\n");
      out.write("\t\r\n");
      out.write("\tvar url = $.getSitePath() + '/clientpartinfo/' + $(\"#_id_m\").val() + \"/update?part_flg=1\";\r\n");
      out.write("\t\r\n");
      out.write("\t//alert(url);\r\n");
      out.write("\t$.popUpWindow(\"编辑客户家庭信息\", url, \"90%\", \"60%\", \"edit\", $(\"#edit_family\"));\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function closeEditFamily(){\r\n");
      out.write("\t\r\n");
      out.write("\t$.closeWindow(\"edit\", $(\"#edit_family\"));\r\n");
      out.write("}\r\n");
      out.write("function initFamily(){\r\n");
      out.write("\tgenFamilyContent(client);\r\n");
      out.write("\t\r\n");
      out.write("\t$('#edit_family').unbind();\r\n");
      out.write("\t$(\"#edit_family\").bind(\"click\", toEditFamily);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function refreshFamily(){\r\n");
      out.write("\t\r\n");
      out.write("\tvar url_to = $.getSitePath() + '/clientpartinfo/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client._id_m }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("\t\r\n");
      out.write("\t $.ajax({\r\n");
      out.write("        type: 'POST',\r\n");
      out.write("        url: url_to,\r\n");
      out.write("        data: {\r\n");
      out.write("            ts: new Date().getTime()\r\n");
      out.write("        },\r\n");
      out.write("        type: 'POST',\r\n");
      out.write("        dataType: 'json',\r\n");
      out.write("        success: function(data) {\r\n");
      out.write("       \t   client = data;\r\n");
      out.write("       \t   initFamily();\r\n");
      out.write("        },\r\n");
      out.write("        complete: function(XMLHttpRequest, textStatus) {\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//-----------------------------------------------------------------------------------------------source\r\n");
      out.write("\r\n");
      out.write("var source_prop_title = [];\r\n");
      if (_jspx_meth_c_forEach_6(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("var source_prop_name = [];\r\n");
      if (_jspx_meth_c_forEach_7(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("// 生成模块内容\r\n");
      out.write("function genSourceContent(client){\r\n");
      out.write("\tvar content = genContent(client,source_prop_title,source_prop_name);\r\n");
      out.write("\t$(\"#source_info_content\").html(content);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function toEditSource(){\r\n");
      out.write("\t\r\n");
      out.write("\tvar url = $.getSitePath() + '/clientpartinfo/' + $(\"#_id_m\").val() + \"/update?part_flg=4\";\r\n");
      out.write("\t\r\n");
      out.write("\t$.popUpWindow(\"编辑客户收入信息\", url, \"90%\", \"70%\", \"edit\", $(\"#edit_source\"));\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function closeEditSource(){\r\n");
      out.write("\t$.closeWindow(\"edit\", $(\"#edit_source\"));\r\n");
      out.write("}\r\n");
      out.write("function initSource(){\r\n");
      out.write("\tgenSourceContent(client);\r\n");
      out.write("\t\r\n");
      out.write("\t$('#edit_source').unbind();\r\n");
      out.write("\t$(\"#edit_source\").bind(\"click\", toEditSource);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function refreshSource(){\r\n");
      out.write("\t\r\n");
      out.write("\tvar url_to = $.getSitePath() + '/clientpartinfo/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client._id_m }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("\t\r\n");
      out.write("\t $.ajax({\r\n");
      out.write("        type: 'POST',\r\n");
      out.write("        url: url_to,\r\n");
      out.write("        data: {\r\n");
      out.write("            ts: new Date().getTime()\r\n");
      out.write("        },\r\n");
      out.write("        type: 'POST',\r\n");
      out.write("        dataType: 'json',\r\n");
      out.write("        success: function(data) {\r\n");
      out.write("       \t   client = data;\r\n");
      out.write("       \t   initSource();\r\n");
      out.write("        },\r\n");
      out.write("        complete: function(XMLHttpRequest, textStatus) {\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//-----------------------------------------------------------------------------------------------work\r\n");
      out.write("\r\n");
      out.write("var work_prop_title = [];\r\n");
      if (_jspx_meth_c_forEach_8(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("var work_prop_name = [];\r\n");
      if (_jspx_meth_c_forEach_9(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("// 生成模块内容\r\n");
      out.write("function genWorkContent(client){\r\n");
      out.write("\tvar content = genContent(client,work_prop_title,work_prop_name);\r\n");
      out.write("\t$(\"#work_info_content\").html(content);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function toEditWork(){\r\n");
      out.write("\t\r\n");
      out.write("\tvar url = $.getSitePath() + '/clientpartinfo/' + $(\"#_id_m\").val() + \"/update?part_flg=2\";\r\n");
      out.write("\t\r\n");
      out.write("\t$.popUpWindow(\"编辑客户收入信息\", url, \"90%\", \"60%\", \"edit\", $(\"#edit_work\"));\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function closeEditWork(){\r\n");
      out.write("\t$.closeWindow(\"edit\", $(\"#edit_work\"));\r\n");
      out.write("}\r\n");
      out.write("function initWork(){\r\n");
      out.write("\tgenWorkContent(client);\r\n");
      out.write("\t\r\n");
      out.write("\t$('#edit_work').unbind();\r\n");
      out.write("\t$(\"#edit_work\").bind(\"click\", toEditWork);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function refreshWork(){\r\n");
      out.write("\t\r\n");
      out.write("\tvar url_to = $.getSitePath() + '/clientpartinfo/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client._id_m }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("\t\r\n");
      out.write("\t $.ajax({\r\n");
      out.write("        type: 'POST',\r\n");
      out.write("        url: url_to,\r\n");
      out.write("        data: {\r\n");
      out.write("            ts: new Date().getTime()\r\n");
      out.write("        },\r\n");
      out.write("        type: 'POST',\r\n");
      out.write("        dataType: 'json',\r\n");
      out.write("        success: function(data) {\r\n");
      out.write("       \t   client = data;\r\n");
      out.write("       \t   initWork();\r\n");
      out.write("        },\r\n");
      out.write("        complete: function(XMLHttpRequest, textStatus) {\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//-----------------------------------------------------------------------------------------------xg\r\n");
      out.write("\r\n");
      out.write("var xg_prop_title = [];\r\n");
      if (_jspx_meth_c_forEach_10(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("var xg_prop_name = [];\r\n");
      if (_jspx_meth_c_forEach_11(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("// 生成模块内容\r\n");
      out.write("function genXgContent(client){\r\n");
      out.write("\tvar content = genContent(client,xg_prop_title,xg_prop_name);\r\n");
      out.write("\t$(\"#xg_info_content\").html(content);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function toEditXg(){\r\n");
      out.write("\t\r\n");
      out.write("\tvar url = $.getSitePath() + '/clientpartinfo/' + $(\"#_id_m\").val() + \"/update?part_flg=5\";\r\n");
      out.write("\t\r\n");
      out.write("\t$.popUpWindow(\"编辑客户收入信息\", url, \"90%\", \"80%\", \"edit\", $(\"#edit_xg\"));\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function closeEditXg(){\r\n");
      out.write("\t$.closeWindow(\"edit\", $(\"#edit_xg\"));\r\n");
      out.write("}\r\n");
      out.write("function initXg(){\r\n");
      out.write("\tgenXgContent(client);\r\n");
      out.write("\t\r\n");
      out.write("\t$('#edit_xg').unbind();\r\n");
      out.write("\t$(\"#edit_xg\").bind(\"click\", toEditXg);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function refreshXg(){\r\n");
      out.write("\t\r\n");
      out.write("\tvar url_to = $.getSitePath() + '/clientpartinfo/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client._id_m }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("\t\r\n");
      out.write("\t $.ajax({\r\n");
      out.write("        type: 'POST',\r\n");
      out.write("        url: url_to,\r\n");
      out.write("        data: {\r\n");
      out.write("            ts: new Date().getTime()\r\n");
      out.write("        },\r\n");
      out.write("        type: 'POST',\r\n");
      out.write("        dataType: 'json',\r\n");
      out.write("        success: function(data) {\r\n");
      out.write("       \t   client = data;\r\n");
      out.write("       \t   initXg();\r\n");
      out.write("        },\r\n");
      out.write("        complete: function(XMLHttpRequest, textStatus) {\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function setPWindowH(part_flag,H){\r\n");
      out.write("\t\r\n");
      out.write("\tvar key = \"edit\";\r\n");
      out.write("\tvar $obj = null;\r\n");
      out.write("\t\r\n");
      out.write("\tif (part_flag == 0){\r\n");
      out.write("\t\t$obj = $(\"#edit_base\");\r\n");
      out.write("\t}else if (part_flag == 1){\r\n");
      out.write("\t\t$obj = $(\"#edit_family\");\r\n");
      out.write("\t}else if (part_flag == 2){\r\n");
      out.write("\t\t$obj = $(\"#edit_work\");\r\n");
      out.write("\t}else if (part_flag == 3){\r\n");
      out.write("\t\t$obj = $(\"#edit_income\");\r\n");
      out.write("\t}else if (part_flag == 4){\r\n");
      out.write("\t\t$obj = $(\"#edit_source\");\r\n");
      out.write("\t}else if (part_flag == 5){\r\n");
      out.write("\t\t$obj = $(\"#edit_xg\");\r\n");
      out.write("\t}else if (part_flag == 6){\r\n");
      out.write("\t\t$obj = $(\"#edit_source\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t$.setPWindowH(key,$obj,H);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("$().ready(function() {\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"button\").each(function(e){\r\n");
      out.write("\t\t$(this).css(\"margin-left\",\"10px\");\r\n");
      out.write("\t\t$(this).addClass(\"btn-sm\");\r\n");
      out.write("\t\t$(this).addClass(\"btn-primary\");\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\tinitBase();\r\n");
      out.write("\tinitFamily();\r\n");
      out.write("\tinitIncome();\r\n");
      out.write("\tinitSource();\r\n");
      out.write("\tinitWork();\r\n");
      out.write("\tinitXg();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<input type=\"hidden\" name=\"ctx\" value=\"");
      out.print(request.getContextPath());
      out.write("\" />\r\n");
      out.write("<input type='hidden' id=\"_id_m\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client._id_m }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("<input type='hidden' id=\"client_name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.client_name }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("<input type='hidden' id=\"client_sex\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client.sex }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("<div class=\"container-fluid\">\r\n");
      out.write("  <div class=\"row\">\r\n");
      out.write("   \t<div class=\"col-md-6\">\r\n");
      out.write("   \t\t<div class=\"row\">\r\n");
      out.write("\t\t   \t<div class=\"col-md-12\">\r\n");
      out.write("\t\t   \t\t<div class=\"row\">\r\n");
      out.write("\t\t   \t\t\t<div class=\"col-md-11 col-md-offset-1\">\r\n");
      out.write("\t\t   \t\t\t\t<div class=\"panel panel-info\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel-heading\">基本信息<button type=\"button\" id=\"edit_base\" class=\"btn btn-default pull-right\"  >编辑</button></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel-body\" id=\"base_info_content\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t   \t\t\t</div>\r\n");
      out.write("\t\t   \t\t</div>\r\n");
      out.write("\t\t   \t\t<div class=\"row\">\r\n");
      out.write("\t\t   \t\t\t<div class=\"col-md-11 col-md-offset-1\">\r\n");
      out.write("\t\t   \t\t\t\t<div class=\"panel panel-info\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel-heading\">家庭信息<button type=\"button\" id=\"edit_family\" class=\"btn btn-default pull-right\">编辑</button></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel-body\" id=\"family_info_content\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t   \t\t\t</div>\r\n");
      out.write("\t\t   \t\t</div>\r\n");
      out.write("\t\t   \t\t<div class=\"row\">\r\n");
      out.write("\t\t   \t\t\t<div class=\"col-md-11 col-md-offset-1\">\r\n");
      out.write("\t\t   \t\t\t\t<div class=\"panel panel-info\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel-heading\">收入相关<button type=\"button\" id=\"edit_income\" class=\"btn btn-default pull-right\">编辑</button></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel-body\" id=\"income_info_content\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t   \t\t\t</div>\r\n");
      out.write("\t\t   \t\t</div>\r\n");
      out.write("\t\t   \t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("   \t</div>\r\n");
      out.write("  \t<div class=\"col-md-6\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t   \t<div class=\"col-md-12\">\r\n");
      out.write("\t\t   \t\t<div class=\"row\">\r\n");
      out.write("\t\t   \t\t\t<div class=\"col-md-11 \">\r\n");
      out.write("\t\t   \t\t\t\t<div class=\"panel panel-info\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel-heading\">来源信息<button type=\"button\" id=\"edit_source\" class=\"btn btn-default pull-right\">编辑</button></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel-body\" id=\"source_info_content\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t   \t\t\t</div>\r\n");
      out.write("\t\t   \t\t</div>\r\n");
      out.write("\t\t   \t\t<div class=\"row\">\r\n");
      out.write("\t\t   \t\t\t<div class=\"col-md-11 \">\r\n");
      out.write("\t\t   \t\t\t\t<div class=\"panel panel-info\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel-heading\">工作信息<button type=\"button\" id=\"edit_work\" class=\"btn btn-default pull-right\">编辑</button></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel-body\" id=\"work_info_content\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t   \t\t\t</div>\r\n");
      out.write("\t\t   \t\t</div>\r\n");
      out.write("\t\t   \t\t<div class=\"row\">\r\n");
      out.write("\t\t   \t\t\t<div class=\"col-md-11 \">\r\n");
      out.write("\t\t   \t\t\t\t<div class=\"panel panel-info\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel-heading\">性格相关<button type=\"button\" id=\"edit_xg\" class=\"btn btn-default pull-right\">编辑</button></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel-body\" id=\"xg_info_content\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t   \t\t\t</div>\r\n");
      out.write("\t\t   \t\t</div>\r\n");
      out.write("\t\t   \t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\tclient = ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${client}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(";\r\n");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("title");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${base_prop_title}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\tbase_prop_title.push(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\");\r\n");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setVar("title_name");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${base_prop_name}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\tbase_prop_name.push(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\");\r\n");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setVar("title");
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${income_prop_title}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\tincome_prop_title.push(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\");\r\n");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_3.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_3.setParent(null);
    _jspx_th_c_forEach_3.setVar("title_name");
    _jspx_th_c_forEach_3.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${income_prop_name}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_3 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_3 = _jspx_th_c_forEach_3.doStartTag();
      if (_jspx_eval_c_forEach_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\tincome_prop_name.push(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\");\r\n");
          int evalDoAfterBody = _jspx_th_c_forEach_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_3.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_3);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_4 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_4.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_4.setParent(null);
    _jspx_th_c_forEach_4.setVar("title");
    _jspx_th_c_forEach_4.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${family_prop_title}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_4 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_4 = _jspx_th_c_forEach_4.doStartTag();
      if (_jspx_eval_c_forEach_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\tfamily_prop_title.push(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\");\r\n");
          int evalDoAfterBody = _jspx_th_c_forEach_4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_4.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_4);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_5 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_5.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_5.setParent(null);
    _jspx_th_c_forEach_5.setVar("title_name");
    _jspx_th_c_forEach_5.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${family_prop_name}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_5 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_5 = _jspx_th_c_forEach_5.doStartTag();
      if (_jspx_eval_c_forEach_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\tfamily_prop_name.push(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\");\r\n");
          int evalDoAfterBody = _jspx_th_c_forEach_5.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_5[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_5.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_5.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_5);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_6 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_6.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_6.setParent(null);
    _jspx_th_c_forEach_6.setVar("title");
    _jspx_th_c_forEach_6.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${source_prop_title}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_6 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_6 = _jspx_th_c_forEach_6.doStartTag();
      if (_jspx_eval_c_forEach_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\tsource_prop_title.push(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\");\r\n");
          int evalDoAfterBody = _jspx_th_c_forEach_6.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_6[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_6.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_6.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_6);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_7 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_7.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_7.setParent(null);
    _jspx_th_c_forEach_7.setVar("title_name");
    _jspx_th_c_forEach_7.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${source_prop_name}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_7 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_7 = _jspx_th_c_forEach_7.doStartTag();
      if (_jspx_eval_c_forEach_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\tsource_prop_name.push(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\");\r\n");
          int evalDoAfterBody = _jspx_th_c_forEach_7.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_7[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_7.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_7.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_7);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_8 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_8.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_8.setParent(null);
    _jspx_th_c_forEach_8.setVar("title");
    _jspx_th_c_forEach_8.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${work_prop_title}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_8 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_8 = _jspx_th_c_forEach_8.doStartTag();
      if (_jspx_eval_c_forEach_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\twork_prop_title.push(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\");\r\n");
          int evalDoAfterBody = _jspx_th_c_forEach_8.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_8[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_8.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_8.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_8);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_9 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_9.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_9.setParent(null);
    _jspx_th_c_forEach_9.setVar("title_name");
    _jspx_th_c_forEach_9.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${work_prop_name}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_9 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_9 = _jspx_th_c_forEach_9.doStartTag();
      if (_jspx_eval_c_forEach_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\twork_prop_name.push(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\");\r\n");
          int evalDoAfterBody = _jspx_th_c_forEach_9.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_9[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_9.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_9.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_9);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_10 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_10.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_10.setParent(null);
    _jspx_th_c_forEach_10.setVar("title");
    _jspx_th_c_forEach_10.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${xg_prop_title}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_10 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_10 = _jspx_th_c_forEach_10.doStartTag();
      if (_jspx_eval_c_forEach_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\txg_prop_title.push(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\");\r\n");
          int evalDoAfterBody = _jspx_th_c_forEach_10.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_10[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_10.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_10.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_10);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_11 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_11.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_11.setParent(null);
    _jspx_th_c_forEach_11.setVar("title_name");
    _jspx_th_c_forEach_11.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${xg_prop_name}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_11 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_11 = _jspx_th_c_forEach_11.doStartTag();
      if (_jspx_eval_c_forEach_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\txg_prop_name.push(\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\");\r\n");
          int evalDoAfterBody = _jspx_th_c_forEach_11.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_11[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_11.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_11.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_11);
    }
    return false;
  }
}
