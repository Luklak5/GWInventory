package com.luklak.inventory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class MaterialStorage
 */
@WebServlet("/user/MaterialStorage")
public class MaterialStorage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaterialStorage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Sql sql = new Sql();
		Api ap = new Api();
		String key = new String("a");
		try {
			String destPage = "login.jsp";
			key = sql.getApi((int) session.getAttribute("id"));
			System.out.println("Key: " + key);
			if(key == null)
			{
				String message = "No valid key found.";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
                dispatcher.forward(request, response);
			}
			boolean valid = ap.ApiCheck(key, "inventories");
			if(valid == false)
			{
				String message = "Key is missing required scope: inventories";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
                dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		URL url = new URL("https://api.guildwars2.com/v2/account/materials?access_token=" + key);
		GetJSON json = new GetJSON();
		Gson gson = new Gson();
		String str = json.read(url);
		Material mats[] = gson.fromJson(str, Material[].class);
		Item item[] = new Item[mats.length];
		int priceCount = 0,y = 0, storageValue = 0;
		int itemId[] = new int[mats.length];
		for(int i = 0;i<mats.length;i++)
		{
			itemId[i] = mats[i].getId();
		}
		item = json.ItemRequestById(itemId);
		for(int i = 0;i<item.length;i++)
		{
			if(!item[i].isAccountBound())
			{
				priceCount++;
			}
		}
		Price prices[] = new Price[priceCount];
		int priceId[] = new int[priceCount];
		for(int i = 0;i<item.length;i++)
		{
			if(!item[i].isAccountBound())
			{
				priceId[y] = item[i].getId();
				y++;
			}
		}
		prices = json.PriceRequestById(priceId);
		y = 0;
		System.out.println(priceCount);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Layout lo = new Layout(pw);
		lo.header("Material Storage");
		pw.println("<input type=\"checkbox\" id=\"cCount\" name=\"cCount\" value=\"Count\" onclick=\"filter()\">");
		pw.println("<label for=\"cCount\"> Hide unowned material</label>");
		pw.println("<input type=\"checkbox\" id=\"cTrade\" name=\"cTrade\" value=\"Trade\" onclick=\"filter()\">");
		pw.println("<label for=\"cTrade\"> Hide untradable material</label>");
		pw.println("<table id=\"tabl\">");
		pw.println("<tr><th>Id</th><th>Icon</th><th>Name</th><th>Count</th><th>Binding</th><th>Price per item</th><th>Value on account</th></tr>");
		for(int i = 0;i<mats.length;i++)
		{
			pw.println("<tr>");
			pw.println("<td>" + mats[i].getId() + "</td>");
			pw.println("<td> <img src=\""+ item[i].getIcon() + "\" width=\"40\" height=\"40\"> </td>");
			pw.println("<td>" + item[i].getName() + "</td>");
			pw.println("<td class=\"icount\">" + mats[i].getCount() + "</td>");
			pw.println("<td class=\"ibound\">" + item[i].isAccountBound() + "</td>");
			if(!item[i].isAccountBound() && !item[i].isSoulbound())
			{
				int itemValue = prices[y].getSells().getUnit_price() * mats[i].getCount();
				storageValue += itemValue; 
				pw.println("<td>" + json.moneyStr(prices[y].getSells().getUnit_price()) + "</td>");
				pw.println("<td>" + json.moneyStr(itemValue) + "</td>");
				y++;
			}
			pw.println("</tr>");
		}
		pw.println("</table>");
		pw.println("Total storage value: " + json.moneyStr(storageValue));
		lo.footer();
	}

}
