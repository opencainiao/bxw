package org.apache.jsp.WEB_002dINF.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class common_005fcss_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/resources/css/idialog.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("<!--\r\n");
      out.write(".error {\r\n");
      out.write("\tcolor: red;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".onepage .form-horizontal .form-group {\r\n");
      out.write("\tmargin-left: 0px;\r\n");
      out.write("\tmargin-right: 0px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".innercontent {\r\n");
      out.write("\tpadding: 0px 15px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".inlineone .form-group label {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tpadding-top: 7px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".inlineone .form-group div {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\twidth: 240px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a {\r\n");
      out.write("\toutline: none;\r\n");
      out.write("}\r\n");
      out.write("a:active {\r\n");
      out.write("\tstar: expression(this.onFocus = this.blur ());\r\n");
      out.write("}\r\n");
      out.write("a:focus {\r\n");
      out.write("\toutline: 0;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
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
}
