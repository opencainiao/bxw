package org.apache.jsp.WEB_002dINF.jsp.front.client.client_005finfo.full;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class detail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<ul class=\"breadcrumb\">\r\n");
      out.write("\t\t<li>\r\n");
      out.write("\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/front/client/list\">客户管理</a>\r\n");
      out.write("\t\t\t<span class=\"divider\"></span>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t<li class=\"active\">客户信息（");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ client.client_name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("）</li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<!-- Nav tabs -->\r\n");
      out.write("\t\t<ul class=\"nav nav-tabs\" role=\"tablist\">\r\n");
      out.write("\t\t\t<li role=\"presentation\" class=\"active\">\r\n");
      out.write("\t\t\t\t<a href=\"#personal\" aria-controls=\"home\" role=\"tab\"\r\n");
      out.write("\t\t\t\t\tdata-toggle=\"tab\">个人信息</a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li role=\"presentation\">\r\n");
      out.write("\t\t\t\t<a href=\"#familly\" aria-controls=\"profile\" role=\"tab\"\r\n");
      out.write("\t\t\t\t\tdata-toggle=\"tab\">家庭成员</a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Tab panes -->\r\n");
      out.write("\t\t<div class=\"tab-content\">\r\n");
      out.write("\t\t\t<div role=\"tabpanel\" class=\"tab-pane active\" id=\"personal\">\r\n");
      out.write("\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/front/client/client_info/full/detail_persinal.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div role=\"tabpanel\" class=\"tab-pane\" id=\"familly\">\r\n");
      out.write("\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/front/client/client_info/full/detail_familly.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$().ready(function() {\r\n");
      out.write("\t\t\t$(\"div.tab-pane\").css(\"padding-top\", \"15px\");\r\n");
      out.write("\t\t});\r\n");
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
}
