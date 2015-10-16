package org.apache.jsp.WEB_002dINF.jsp.admin.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("<title></title>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/include/common_css_gentelella.jsp", out, false);
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function handIframeLoad() {\r\n");
      out.write("    autoHeight();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function autoHeight() {\r\n");
      out.write("    var iframe = document.getElementById(\"frame_content_id\");\r\n");
      out.write("\r\n");
      out.write("    var toShow = [];\r\n");
      out.write("\r\n");
      out.write("    var iframeContentH = $(window.frames[\"frame_content_id\"].document).height();\r\n");
      out.write("\r\n");
      out.write("    toShow.push(\"iframeContentH[\" + iframeContentH + \"]\");\r\n");
      out.write("\r\n");
      out.write("    var toSetH = 0;\r\n");
      out.write("\r\n");
      out.write("    var iframeContentH = 0;\r\n");
      out.write("\r\n");
      out.write("    if (iframe.Document) { //ie自有属性\r\n");
      out.write("        iframeContentH = iframe.Document.documentElement.scrollHeight;\r\n");
      out.write("    } else if (iframe.contentDocument) { //ie,firefox,chrome,opera,safari\r\n");
      out.write("        iframeContentH = iframe.contentDocument.body.offsetHeight;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    toShow.push(\"iframeContentH[\" + iframeContentH + \"]\");\r\n");
      out.write("\r\n");
      out.write("    var divH = $(\"#home_content\").height();\r\n");
      out.write("\r\n");
      out.write("    toShow.push(\"divH[\" + divH + \"]\");\r\n");
      out.write("\r\n");
      out.write("    if (iframeContentH > divH) {\r\n");
      out.write("        toSetH = iframeContentH;\r\n");
      out.write("    } else {\r\n");
      out.write("        toSetH = divH - 5;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("     alert(toShow.join(\"\\n\"));\r\n");
      out.write("    iframe.height = toSetH;\r\n");
      out.write("    \r\n");
      out.write("    if (iframe.Document) { //ie自有属性\r\n");
      out.write("        iframeDoc = iframe.Document;\r\n");
      out.write("    } else if (iframe.contentDocument) { //ie,firefox,chrome,opera,safari\r\n");
      out.write("        iframeDoc = iframe.contentDocument;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    iframeDoc.height = toSetH - 5;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<body class=\"nav-md\">\r\n");
      out.write("\t<div class=\"container body\">\r\n");
      out.write("\t\t<div class=\"main_container\">\r\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/admin/include/common_nav_left_gentelella.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/admin/include/common_nav_top_gentelella.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- page content -->\r\n");
      out.write("\t\t\t<div id=\"home_content\" class=\"right_col\" role=\"main\">\r\n");
      out.write("\t\t\t\t<iframe id=\"frame_content_id\" name=\"frame_content_id\"\r\n");
      out.write("\t\t\t\t\tclass=\"frame_content_container\" width=\"100%\"\r\n");
      out.write("\t\t\t\t\tstyle=\"min-height: 500px\" frameborder=\"0\"> </iframe>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/admin/include/common_nav_footer_gentelella.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /page content -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"custom_notifications\" class=\"custom-notifications dsp_none\">\r\n");
      out.write("\t\t<ul class=\"list-unstyled notifications clearfix\"\r\n");
      out.write("\t\t\tdata-tabbed_notifications=\"notif-group\">\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t<div id=\"notif-group\" class=\"tabbed_notifications\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/include/common_js_gentelella.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("    \t\r\n");
      out.write("\t    function refreshHeadImg(_id_m) {\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tvar new_src = $.getSitePath() + \"/attachment/\" + _id_m;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(\"#head_img_top\").attr(\"src\", new_src);\r\n");
      out.write("\t\t\t$(\"#head_img_left\").attr(\"src\", new_src);\r\n");
      out.write("\t\t}\r\n");
      out.write("    \r\n");
      out.write("        $(document).ready(function () {\r\n");
      out.write("            $(\"#frame_content_id\").load(function(){  \r\n");
      out.write("            \tvar iframe_h = $.autoHeight(\"frame_content_id\");\r\n");
      out.write("            });  \r\n");
      out.write("            \r\n");
      out.write("        \tloadTree();\r\n");
      out.write("        \t\r\n");
      out.write("        \tinitTopNavBehave();\r\n");
      out.write("        \t\r\n");
      out.write("        \t$.setSitePath(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\");\r\n");
      out.write("        \t$.setAllConstants(eval(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ALLCONSTANT}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("));\r\n");
      out.write("        \t\r\n");
      out.write("        \tvar sysmodule = $.getConstants(\"SYS_MODULE\");\r\n");
      out.write("        \t//$.alertObjJson(sysmodule);\r\n");
      out.write("        \t\r\n");
      out.write("        \t//$.alertObjJson($.getConstantName(\"SYS_MODULE\",\"02\"));\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
