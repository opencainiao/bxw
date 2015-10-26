package org.apache.jsp.WEB_002dINF.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class common_005fjs_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"http://cdn.bootcss.com/jquery/2.1.3/jquery.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\twindow.jQuery || document.write('<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/js/jquery-2.1.3.min.js\" type=\"text/javascript\"><\\/script>');\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/jquery.ba-resize.js\"></script>\r\n");
      out.write("<script src=\"http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/mou.ajax.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/layer/layer.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/layer/extend/layer.ext.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/jquery.nbq.ux.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/jquery_ux_select.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/mou.data.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/mou.multiselectpanel.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/jquery.artDialog.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/laydate-v1.1/laydate/laydate.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("#laydate_YY {\r\n");
      out.write("\twidth: 123px !important;\r\n");
      out.write("\theight: 26px !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#laydate_MM {\r\n");
      out.write("\twidth: 101px !important;\r\n");
      out.write("\theight: 26px !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#laydate_table {\r\n");
      out.write("\tborder-top-width: 0px !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#laydate_box {\r\n");
      out.write("\twidth: 242px !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".laydate_ym   label {\r\n");
      out.write("\tmargin-right: -3px !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#laydate_ys {\r\n");
      out.write("\twidth: 124px !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div.laydate_yms {\r\n");
      out.write("\twidth: 124px !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".laydate_bottom {\r\n");
      out.write("\theight: 30px !important;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t$().ready(function() {\r\n");
      out.write("\t\tdocument.onkeydown = function(event) {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tif (event.keyCode == 13) {\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar name = event.target.tagName.toLowerCase();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t//alert(name);\r\n");
      out.write("\t\t\t\tif (name == \"button\"){\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"a\").bind(\"focus\", function() {\r\n");
      out.write("\t\t\tif (this.blur) {\r\n");
      out.write("\t\t\t\tthis.blur();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t//给面板添加折叠\r\n");
      out.write("\t\t$(\".panel-heading\").each(function() {\r\n");
      out.write("\t\t\t$(this).append('<span class=\"glyphicon glyphicon-chevron-down pull-right spncollapse\"></span>');\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t//处理面板的折叠\r\n");
      out.write("\t\t$(\".spncollapse\", $(\".panel-heading\")).click(function() {\r\n");
      out.write("\t\t\tvar content = $(this).parent().next();\r\n");
      out.write("\t\t\tcontent.slideToggle(200);\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t// 将页面的按钮图标，换成小图标\r\n");
      out.write("\t\t$(\"button\", $(\".navbar\")).each(function(e) {\r\n");
      out.write("\t\t\t$(this).addClass(\"btn-sm\");\r\n");
      out.write("\t\t})\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("</script>");
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
