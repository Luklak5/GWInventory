package com.luklak.inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.luklak.gwDAO.User;

public class Sql 
{
	String url = "jdbc:mysql://localhost:3306/gwinventory";
	String id = "gwinv";
	String pass = "gwinventory";
	
	Connection con;
	
	public void open() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		con = DriverManager.getConnection(url, id, pass);
	}
	
	public void close() throws SQLException 
	{
		con.close();
	}
	
	public List<User> readUsers() throws SQLException
	{
		List<User> users = new ArrayList<>();
		String selectSql = "SELECT * FROM users";
		try (Statement stmt = con.createStatement()) {
			try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
			    while(resultSet.next()) {
			    	User usr = new User();
			    	usr.setId(resultSet.getInt("id"));
			    	usr.setUsername(resultSet.getString("username"));
			    	usr.setPassword(resultSet.getString("passwd"));
			    	users.add(usr);
			    }
			}
		}
		return users;
	}
	
	public User checkLogin(String username, String password) throws SQLException, ClassNotFoundException
	{
		open();
		User user = null;
		
		String sql = "SELECT * FROM users where username = ? and passwd = ?";
		PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        
        ResultSet resultSet = statement.executeQuery();
        
        if(resultSet.next())
        {
        	user = new User();
        	user.setUsername(resultSet.getString("username"));
        	user.setId(resultSet.getInt("id"));
        }
        close();
		return user;
	}
	
	public String getApi(int uId) throws SQLException, ClassNotFoundException
	{
		open();
		String api = null;
		
		System.out.println("Id: " + uId);
		
		String sql = "SELECT * FROM u_keys where u_id = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, uId);
		
		ResultSet resultSet = statement.executeQuery();
		
		if(resultSet.next())
        {
        	api = new String();
        	api = resultSet.getString("api_key");
        }
		
		close();
		return api;
	}
	
	public void newUser(String username,String password) throws ClassNotFoundException, SQLException 
	{
		open();
		
		String sql = "insert into users(username,passwd) value(?,?)";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);
		
		statement.execute();
		
		close();
	}
	
	public void newKey(int id, String key) throws ClassNotFoundException, SQLException
	{
		open();
		
		String sql = "insert into u_keys(u_id,api_key) value(?,?)";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, id);
		statement.setString(2, key);
		
		statement.execute();
		
		close();
	}
}
