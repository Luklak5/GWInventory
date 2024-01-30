package com.luklak.inventory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class Achievements
 */
@WebServlet("/Achievements")
public class Achievements extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Achievements() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URL url = new URL("https://api.guildwars2.com/v2/achievements/daily?v=latest");
		GetJSON json = new GetJSON();
		Gson gson = new Gson();
		String str = json.read(url);
		AchiSet today = gson.fromJson(str, AchiSet.class);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println("Pve: \n");
		pw.println("<table>");
		pw.println("<tr><th>Id</th><th>Min level</th><th>Max level</th><th>Product</th><th>Condition</th></tr>");
		for(int i = 0;i<today.getPveLength();i++)
		{
			pw.println("<tr>");
			pw.println("<td>" + today.getPve(i).getId() + "</td>");
			pw.println("<td>" + today.getPve(i).getLevel().getMin() + "</td>");
			pw.println("<td>" + today.getPve(i).getLevel().getMax() + "</td>");
			if(today.getPve(i).getAccess().getProduct()!= null)
			{
				pw.println("<td>" + today.getPve(i).getAccess().getProduct() + "</td>");
				pw.println("<td>" + today.getPve(i).getAccess().getCondition() + "</td>");
			}
			else
			{
				pw.println("<td></td>");
				pw.println("<td></td>");
			}
			pw.println("</tr>");
		}
		pw.println("</table>");
		pw.println("Pvp: \n");
		pw.println("<table>");
		pw.println("<tr><th>Id</th><th>Min level</th><th>Max level</th><th>Product</th><th>Condition</th></tr>");
		for(int i = 0;i<today.getPvpLength();i++)
		{
			pw.println("<tr>");
			pw.println("<td>" + today.getPvp(i).getId() + "</td>");
			pw.println("<td>" + today.getPvp(i).getLevel().getMin() + "</td>");
			pw.println("<td>" + today.getPvp(i).getLevel().getMax() + "</td>");
			if(today.getPvp(i).getAccess().getProduct()!= null)
			{
				pw.println("<td>" + today.getPvp(i).getAccess().getProduct() + "</td>");
				pw.println("<td>" + today.getPvp(i).getAccess().getCondition() + "</td>");
			}
			else
			{
				pw.println("<td></td>");
				pw.println("<td></td>");
			}
			pw.println("</tr>");
		}
		pw.println("</table>");
		pw.println("Wvw: \n");
		pw.println("<table>");
		pw.println("<tr><th>Id</th><th>Min level</th><th>Max level</th><th>Product</th><th>Condition</th></tr>");
		for(int i = 0;i<today.getWvwLength();i++)
		{
			pw.println("<tr>");
			pw.println("<td>" + today.getWvw(i).getId() + "</td>");
			pw.println("<td>" + today.getWvw(i).getLevel().getMin() + "</td>");
			pw.println("<td>" + today.getWvw(i).getLevel().getMax() + "</td>");
			if(today.getWvw(i).getAccess().getProduct()!= null)
			{
				pw.println("<td>" + today.getWvw(i).getAccess().getProduct() + "</td>");
				pw.println("<td>" + today.getWvw(i).getAccess().getCondition() + "</td>");
			}
			else
			{
				pw.println("<td></td>");
				pw.println("<td></td>");
			}
			pw.println("</tr>");
		}
		pw.println("</table>");
		pw.println("Fractals: \n");
		pw.println("<table>");
		pw.println("<tr><th>Id</th><th>Min level</th><th>Max level</th><th>Product</th><th>Condition</th></tr>");
		for(int i = 0;i<today.getFractalsLength();i++)
		{
			pw.println("<tr>");
			pw.println("<td>" + today.getFractals(i).getId() + "</td>");
			pw.println("<td>" + today.getFractals(i).getLevel().getMin() + "</td>");
			pw.println("<td>" + today.getFractals(i).getLevel().getMax() + "</td>");
			if(today.getFractals(i).getAccess().getProduct()!= null)
			{
				pw.println("<td>" + today.getFractals(i).getAccess().getProduct() + "</td>");
				pw.println("<td>" + today.getFractals(i).getAccess().getCondition() + "</td>");
			}
			else
			{
				pw.println("<td></td>");
				pw.println("<td></td>");
			}
			pw.println("</tr>");
		}
		pw.println("</table>");
		pw.println("</body></html>");
	}

}
