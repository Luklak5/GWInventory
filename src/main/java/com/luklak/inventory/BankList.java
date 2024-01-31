package com.luklak.inventory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class BankList
 */
@WebServlet("/BankList")
public class BankList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URL url = new URL("https://api.guildwars2.com/v2/account/bank?access_token=DD62D499-9E75-4942-9099-C17D1761E1DB77B1170A-0059-4A44-8994-A641CFB146F0");
		GetJSON json = new GetJSON();
		Gson gson = new Gson();
		String str = json.read(url);
		Bank bank[] = gson.fromJson(str, Bank[].class);
		String strh = new String("https://api.guildwars2.com/v2/items?ids=");
		for(int i = 0;i<bank.length;i++)
		{
			if(Objects.isNull(bank[i])!= true)
			{
				strh = strh + bank[i].getId();
				if(i != (bank.length -1))
				{
					strh = strh + ",";
				}
			}
		}
		System.out.println(strh);
		URL url2 = new URL(strh);
		String str2 = json.read(url2);
		Item item[] = gson.fromJson(str2, Item[].class);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int y = 0;
		pw.println("<html><body>");
		pw.println("<table>");
		pw.println("<tr><th>Bank slot</th><th>Id</th><th>Count</th><th>Binding</th><th>Name</th><th>Icon</th><th>Description</th></tr>");
		for(int i = 0;i<bank.length;i++)
		{
			pw.println("<tr>");
			pw.println("<td>" + i + "</td>");
			if(Objects.isNull(bank[i]))
			{
				pw.println("<td>Empty</td><td></td><td></td><td></td><td></td><td></td>");
			}
			else
			{
				pw.println("<td>" + bank[i].getId() + "</td>");
				pw.println("<td>" + bank[i].getCount() + "</td>");
				pw.println("<td>" + bank[i].getBinding() + "</td>");
				pw.println("<td>" + item[y].getName() + "</td>");
				pw.println("<td> <img src=\""+ item[y].getIcon() + "\" width=\"40\" height=\"40\"> </td>");
				pw.println("<td>" + item[y].getDescription() + "</td>");
				y++;
			}
			pw.println("</tr>");
		}
		
	}

}
