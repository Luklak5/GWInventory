package com.luklak.inventory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.luklak.gwDAO.User;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URL url = new URL("https://api.guildwars2.com/v2/currencies?ids=1,2,3");
		GetJSON json = new GetJSON();
		Gson gson = new Gson();
		List<User> users = new ArrayList<>();
		String str = json.read(url);
		Currency carray[] = gson.fromJson(str, Currency[].class);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Layout lo = new Layout(pw);
		lo.header("DemoServlet");
		for(int i = 0; i< carray.length; i++)
		{
			pw.println(carray[i].toStringNoURL() + "<img src=\""+ carray[i].getIcon() + "\" width=\"50\" height=\"50\"> ");
		}
		pw.println(json.moneyStr(101010));
		URL url2 = new URL("https://api.guildwars2.com/v2/items/12337");
		String str2 = json.read(url2);
		Item almond = gson.fromJson(str2, Item.class);
		String almondflags[] = almond.getFlags();
		for(int i = 0;i<almond.getFlags().length;i++)
		{
			System.out.println(almondflags[i]);
		}
		System.out.println(almond.isAccountBound());
		Sql sql = new Sql();
		try {
			sql.open();
			users = sql.readUsers();
			for(int i = 0;i< users.size();i++)
			{
				pw.println(users.get(i).toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lo.footer();
		
	}

}
