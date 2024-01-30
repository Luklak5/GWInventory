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
 * Servlet implementation class Money
 */
@WebServlet("/Money")
public class Money extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Money() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URL url = new URL("https://api.guildwars2.com/v2/account/wallet?access_token=DD62D499-9E75-4942-9099-C17D1761E1DB77B1170A-0059-4A44-8994-A641CFB146F0");
		GetJSON json = new GetJSON();
		Gson gson = new Gson();
		String str = json.read(url);
		Wallet money[] = gson.fromJson(str, Wallet[].class);
		String strh = new String("https://api.guildwars2.com/v2/currencies?ids=");
		for(int i = 0;i<money.length;i++)
		{
			strh = strh + money[i].getId();
			if(i != (money.length -1))
			{
				strh = strh + ",";
			}
		}
		System.out.println(strh);
		URL url2 = new URL(strh);
		String str2 = json.read(url2);
		Currency curr[] = gson.fromJson(str2, Currency[].class);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println("Wallet: \n");
		pw.println("<table>");
		pw.println("<tr><th>Id</th><th>Amount</th><th>Name</th><th>Description</th></tr>");
		for(int i = 0;i<money.length;i++)
		{
			pw.println("<tr><td>" + money[i].getId() + "</td><td>" + money[i].getValue() + "</td><td>" + curr[i].getName() + "</td><td>" + curr[i].getDescription() + "</td></tr>");
		}
		pw.println("</table>");
	}

}
