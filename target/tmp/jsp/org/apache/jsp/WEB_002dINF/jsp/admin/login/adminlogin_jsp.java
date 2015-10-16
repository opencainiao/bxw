package org.apache.jsp.WEB_002dINF.jsp.admin.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminlogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>  \r\n");
      out.write("    <title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sysname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</title>  \r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("\t\t\tbody {\r\n");
      out.write("\t\t\t   margin: 0;\r\n");
      out.write("\t\t\t   font-size: 20px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.formcontainer{\r\n");
      out.write("\t\t\t\t margin-top:40px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t   \r\n");
      out.write("\t\t\t.center_c {\r\n");
      out.write("\t\t\t\t  border: 1px solid threedshadow;\r\n");
      out.write("\t\t\t\t  border-radius: 10px 10px 10px 10px;\r\n");
      out.write("\t\t\t\t  width:800px;\r\n");
      out.write("\t\t\t\t  height:400px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.control-label{\r\n");
      out.write("\t\t\t\t font-size: 18px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t#loginTitle {\r\n");
      out.write("\t\t\t    padding-top:20px;\r\n");
      out.write("\t\t\t    padding-left: 10px;\r\n");
      out.write("\t\t\t    padding-right: 10px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t#loginFooter {\r\n");
      out.write("\t\t\t    border-top: 1px solid threedlightshadow;\r\n");
      out.write("\t\t\t    border-bottom: 1px solid threedlightshadow;\r\n");
      out.write("\t\t\t    margin-top:40px;\r\n");
      out.write("\t\t\t    margin-left: 10px;\r\n");
      out.write("\t\t\t    margin-right: 10px;\r\n");
      out.write("\t\t\t    text-align: center;\r\n");
      out.write("\t\t\t    padding-top:15px;\r\n");
      out.write("\t\t\t    padding-bottom:15px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\th1 {\r\n");
      out.write("\t\t\t    border-bottom: 1px solid threedlightshadow;\r\n");
      out.write("\t\t\t    font-size: 40px;\r\n");
      out.write("\t\t\t    margin: 0 0 0.6em;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\ttd input{\r\n");
      out.write("\t\t\t\tmargin:10px  15px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.xubox_layer{\r\n");
      out.write("\t\t\t\tmargin-top: 120px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("    </style>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/css/admin/main.css\"/>\r\n");
      out.write("   \r\n");
      out.write("   \t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/include/common_css.jsp", out, false);
      out.write("\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/jsp/include/common_js.jsp", out, false);
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\"\thref=\"");
      out.print(request.getContextPath());
      out.write("/resources/layer/skin/layer.css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/admin/login/user_login.js\"></script>\r\n");
      out.write("  \r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("\r\n");
      out.write("  \t<div class=\"center_c\">\r\n");
      out.write("\t\t<div id=\"loginTitle\">\r\n");
      out.write("\t\t\t<h1 id=\"titleText\"><span style=\"width:30px\">&nbsp;</span>LOGIN</h1>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"formcontainer\">\r\n");
      out.write("\t\t\t<form name=\"frm1\" class=\"form-horizontal\">\r\n");
      out.write("\t\t\t<table style=\"margin: 0 auto\">\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>用户名</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" class=\"input-large\"  id=\"ure\" name=\"ure\"  style=\"height:30px\"  /></td>\t\r\n");
      out.write("\t\t\t\t\t\t<td><span class=\"error\" id=\"ure_err\"></span></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr >\r\n");
      out.write("\t\t\t\t\t\t<td>密&nbsp;&nbsp;&nbsp;码</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"password\" class=\"input-large\"  id=\"password\" name=\"password\"  style=\"height:30px\"  /></td>\t\r\n");
      out.write("\t\t\t\t\t\t<td><span class=\"error\" id=\"ure_err\"></span></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr >\r\n");
      out.write("\t\t\t\t\t\t<td>验证码</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" class=\"input-large\"  id=\"vcode\" name=\"vcode\"  style=\"height:30px\"  /></td>\t\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"validateCodeDiv\"   >\r\n");
      out.write("\t\t\t\t\t\t      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t        <tr>\r\n");
      out.write("\t\t\t\t\t\t\t          <td height=\"60\">\r\n");
      out.write("\t\t\t\t\t\t\t            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ValCode/getValCode\" id=\"imgVcode\"/>\r\n");
      out.write("\t\t\t\t\t\t\t          </td>\r\n");
      out.write("\t\t\t\t\t\t\t          <td align=\"center\" valign=\"middle\" height=\"20\" style=\"color:blue\">点图片换一张</td>\r\n");
      out.write("\t\t\t\t\t\t\t        </tr>\r\n");
      out.write("\t\t\t\t\t\t      </table>\r\n");
      out.write("\t\t\t\t\t   \t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><span class=\"error\" id=\"ure_err\"></span></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"loginFooter\">\r\n");
      out.write("\t\t\t<button type=\"submit\"  id=\"submitBtn\" class=\"btn-primary btn-large\" style=\"width: 350px; height: 50px; border-width: 0px; font-size: 23px;\" type=\"submit\">登陆系统</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("  </body>\r\n");
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
