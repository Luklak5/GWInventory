package com.luklak.inventory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class KeyManagementServlet
 */
@WebServlet("/user/KeyManagement")
public class KeyManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KeyManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Layout lo = new Layout(pw);
		lo.header("API Key Management");
		HttpSession session = request.getSession();
		String key = null;
		Sql sql = new Sql();
		try {
			key = sql.getApi((int) session.getAttribute("id"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.println("<form action=\"\" method=\"post\">");
		pw.println("<label for=\"key\">Api key:</label>");
		if(key != null)
		{
			pw.println("<input type=\"text\" name=\"key\" size=\"85\" value=\" " +  key  + " \">");
		}
		else
		{
			pw.println("<input type=\"text\" name=\"key\" size=\"85\" placeholder=\"API Key\">");
		}
		pw.println("<button type=\"KeySave\">Save key</button>");
		pw.println("<button type=\"KeyDelete\">Delete key</button>");
		pw.println("</form>");
		lo.footer();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
