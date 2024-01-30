package com.luklak.inventory;

import java.io.PrintWriter;

public class Layout {
	private PrintWriter pw;
	
	public Layout(PrintWriter pw) {
		super();
		this.pw = pw;
	}
	
	public void header(String title)
	{
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>" + title + "</title>");
		pw.println("<link rel=\"stylesheet\" href=\"/GWInventory/css/style.css\">");
		pw.println("<script src=\"/GWInventory/script/jscript.js\"></script>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<table>");
		pw.println("<tr>");
		pw.println("<td><a href=\"/GWInventory/\">Index</a></td>");
		pw.println("<td><a href=\"/GWInventory/DemoServlet\">Demo</a></td>");
		pw.println("<td><a href=\"/GWInventory/user/MaterialStorage\">Material Storage</a></td>");
		pw.println("</tr>");
		pw.println("</table>");
	}
	
	public void footer()
	{
		pw.println("</body>");
		pw.println("</html>");
	}
}
