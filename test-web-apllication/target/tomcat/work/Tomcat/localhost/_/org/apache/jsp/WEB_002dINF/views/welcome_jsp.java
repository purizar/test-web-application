/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-01-27 08:56:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/views/common/navigation.jspf", Long.valueOf(1611737747489L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jspf", Long.valueOf(1611724807605L));
    _jspx_dependants.put("/WEB-INF/views/common/header.jspf", Long.valueOf(1611733116052L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Students Application</title>\r\n");
      out.write("<link href=\"webjars/bootstrap/4.0.0/css/bootstrap.min.css\"\r\n");
      out.write("    rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>");
      out.write('\r');
      out.write('\n');
      out.write("\t<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n");
      out.write("\t  <a class=\"navbar-brand\" href=\"#\">Test-Application</a>\r\n");
      out.write("\t  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavAltMarkup\" aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("\t    <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("\t  </button>\r\n");
      out.write("\t  <div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">\r\n");
      out.write("\t    <div class=\"navbar-nav\">\r\n");
      out.write("\t      <a class=\"nav-item nav-link active\" href=\"welcome.jsp\">Home <span class=\"sr-only\">(current)</span></a>\r\n");
      out.write("\t      <a class=\"nav-item nav-link\" href=\"/list-students\">Students</a>\r\n");
      out.write("\t      <a class=\"nav-item nav-link\" href=\"/list-clases\">Classes</a>\r\n");
      out.write("\t      <a class=\"nav-item nav-link\" href=\"/asig-clases\">Assign Classes</a>\r\n");
      out.write("\t      <a class=\"nav-item nav-link\" href=\"/asig-students\">Assign Students</a>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t</nav>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\tWelcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(". You are now authenticated.\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"webjars/jquery/3.0.0/jquery.min.js\"></script>\r\n");
      out.write("\t<script src=\"webjars/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"webjars/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
