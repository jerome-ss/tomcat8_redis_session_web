package tomcat8_redis_session_web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestRedisSessionServlet extends HttpServlet {

	/**  */
	private static final long serialVersionUID = -3515847085632085206L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		/*
		// 1. 设置Session
		for (int i = 0; i < 10; i++) {
			session.setAttribute("name" + i, "session_data_" + i);
		}
		*/
		// 2. 注释第一步,重启tomcat后看是否还可以读取到Session
		String str = "";
		for (int i = 0; i < 10; i++) {
			str = str + session.getAttribute("name" + i) + "<br>";
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(str);
		out.flush();
		out.close();
		
		// 访问: http://localhost:8080/tomcat8_redis_session_web/servlet/TestRedisSessionServlet
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
