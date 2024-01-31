package com.luklak.inventory;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.luklak.gwDAO.User;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserLoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");       
        Sql sql = new Sql();        
        try
        {
        	User user = sql.checkLogin(username, password);
        	String destPage = "/login.jsp";        	
        	if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("username", user.getUsername());
                session.setAttribute("id", user.getId());
                destPage = "/index.jsp";
            } else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
            }
        	System.out.println(destPage);
        	RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
        }
        catch (SQLException | ClassNotFoundException ex) 
        {
            throw new ServletException(ex);
        }        
	}
}
