package org.apache.jsp.WEB_002dINF.jsp.admin.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class common_005fnav_005ftop_005fgentelella_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!-- top navigation -->\r\n");
      out.write("\r\n");
      out.write("<div class=\"top_nav\">\r\n");
      out.write("\t<div class=\"nav_menu\" id=\"nav_menu\">\r\n");
      out.write("\t\t<nav class=\"\" role=\"navigation\">\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t<li class=\"\"><a href=\"javascript:;\"\r\n");
      out.write("\t\t\t\t\tclass=\"user-profile dropdown-toggle\" data-toggle=\"dropdown\"\r\n");
      out.write("\t\t\t\t\taria-expanded=\"false\"> <img id=\"head_img_top\"\r\n");
      out.write("\t\t\t\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/attachment/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user_head_img }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" alt=\"\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${nickname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<span class=\" fa fa-angle-down\"></span>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<ul\r\n");
      out.write("\t\t\t\t\t\tclass=\"dropdown-menu dropdown-usermenu animated fadeInDown pull-right\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"javascript:;\"\r\n");
      out.write("\t\t\t\t\t\t\tdata-link=\"profile/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/update\"> 个人信息</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li class='hide'><a href=\"javascript:;\"> <span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"badge bg-red pull-right\">50%</span> <span>Settings</span>\r\n");
      out.write("\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li class='hide'><a href=\"javascript:;\">Help</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"javascript:;\" data-link=\"adminlogout\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"logout\"><i class=\"fa fa-sign-out pull-right\"></i> 退出</a></li>\r\n");
      out.write("\t\t\t\t\t</ul></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<li role=\"presentation\" class=\"dropdown\"><a href=\"javascript:;\"\r\n");
      out.write("\t\t\t\t\tclass=\"hide dropdown-toggle info-number\" data-toggle=\"dropdown\"\r\n");
      out.write("\t\t\t\t\taria-expanded=\"false\"> <i class=\"fa fa-envelope-o\"></i> <span\r\n");
      out.write("\t\t\t\t\t\tclass=\"badge bg-green\">6</span>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<ul id=\"menu1\"\r\n");
      out.write("\t\t\t\t\t\tclass=\" dropdown-menu list-unstyled msg_list animated fadeInDown\"\r\n");
      out.write("\t\t\t\t\t\trole=\"menu\">\r\n");
      out.write("\t\t\t\t\t\t<li><a> <span class=\"image\"> <img\r\n");
      out.write("\t\t\t\t\t\t\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/gentelella/production/images/img.jpg\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\talt=\"Profile Image\" />\r\n");
      out.write("\t\t\t\t\t\t\t</span> <span> <span>John Smith</span> <span class=\"time\">3\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmins ago</span>\r\n");
      out.write("\t\t\t\t\t\t\t</span> <span class=\"message\"> Film festivals used to be\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdo-or-die moments for movie makers. They were where... </span>\r\n");
      out.write("\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a> <span class=\"image\"> <img\r\n");
      out.write("\t\t\t\t\t\t\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/gentelella/production/images/img.jpg\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\talt=\"Profile Image\" />\r\n");
      out.write("\t\t\t\t\t\t\t</span> <span> <span>John Smith</span> <span class=\"time\">3\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmins ago</span>\r\n");
      out.write("\t\t\t\t\t\t\t</span> <span class=\"message\"> Film festivals used to be\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdo-or-die moments for movie makers. They were where... </span>\r\n");
      out.write("\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a> <span class=\"image\"> <img\r\n");
      out.write("\t\t\t\t\t\t\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/gentelella/production/images/img.jpg\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\talt=\"Profile Image\" />\r\n");
      out.write("\t\t\t\t\t\t\t</span> <span> <span>John Smith</span> <span class=\"time\">3\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmins ago</span>\r\n");
      out.write("\t\t\t\t\t\t\t</span> <span class=\"message\"> Film festivals used to be\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdo-or-die moments for movie makers. They were where... </span>\r\n");
      out.write("\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a> <span class=\"image\"> <img\r\n");
      out.write("\t\t\t\t\t\t\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/gentelella/production/images/img.jpg\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\talt=\"Profile Image\" />\r\n");
      out.write("\t\t\t\t\t\t\t</span> <span> <span>John Smith</span> <span class=\"time\">3\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmins ago</span>\r\n");
      out.write("\t\t\t\t\t\t\t</span> <span class=\"message\"> Film festivals used to be\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdo-or-die moments for movie makers. They were where... </span>\r\n");
      out.write("\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text-center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a> <strong><a href=\"inbox.html\">See All Alerts</strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-angle-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction initTopNavBehave() {\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"a\", $(\"#nav_menu\")).click(function(e) {\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar $this = $(this);\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar data_link = $this.attr(\"data-link\");\r\n");
      out.write("\t\t\tif (data_link == undefined) {\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\tif ($this.attr(\"data-link\") && $this.attr(\"data-link\").indexOf(\"#\") < 0) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\te.preventDefault();\r\n");
      out.write("\t\t\t\te.stopPropagation();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tvar url = $.getSitePath() + \"/\" + $this.attr(\"data-link\");\r\n");
      out.write("\t\t\t\t//alert(url);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tif ($this.attr(\"id\") == \"logout\") {\r\n");
      out.write("\t\t\t\t\t$.loadPage(url);\r\n");
      out.write("\t\t\t\t\t//window.top.location.href = url;\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$(\"#frame_content_id\")[0].src = url;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t$(\"#nav_menu\").trigger(\"click\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<!-- /top navigation -->");
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
