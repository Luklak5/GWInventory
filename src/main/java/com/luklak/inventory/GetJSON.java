package com.luklak.inventory;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import com.google.gson.Gson;

public class GetJSON {
	public String read(URL url) throws IOException {
		String line = new String();
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		int responsecode = conn.getResponseCode();
		if(responsecode != 200 && responsecode != 206)
			throw new RuntimeException("HttpResponseCode: " +responsecode);
			else
			{
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext())
				{
				line+=sc.nextLine();
				}
				System.out.println("\nJSON data in string format");
				System.out.println(line);
				sc.close();
			}
		return line;
	}
	
	public String moneyStr(int i)
	{
		if (i < 1)
		{
			return "0<img src=\"/GWInventory/images/copper.png\" width=\"20\" height=\"20\">";
		}
		String str = new String();
		int copper = i % 100;
		int silver = (i % 10000) / 100;
		int gold = i / 10000;
		if(gold > 0)
		{
			str += gold + "<img src=\"/GWInventory/images/gold.png\" width=\"20\" height=\"20\">";
		}
		if(silver > 0)
		{
			str += silver + "<img src=\"/GWInventory/images/silver.png\" width=\"20\" height=\"20\">";
		}
		if(copper > 0)
		{
			str += copper + "<img src=\"/GWInventory/images/copper.png\" width=\"20\" height=\"20\">";
		}
		return str;		
	}
	
	public Item[] ItemRequestById(int[] id) throws IOException
	{
		Item[] result = new Item[id.length];
		Gson gson = new Gson();
		String strh = new String();
		int idCount = 0,currentCount = 0,requestCount,help;
		strh = new String("https://api.guildwars2.com/v2/items?ids=");
		for(int i = 0;i<id.length;i++)
		{
			if(idCount == 199)
			{
				System.out.println(strh);
				URL url = new URL(strh);
				String str = read(url);
				Item[] hold = gson.fromJson(str, Item[].class);
				requestCount = currentCount + 199;
				help = 0;
				while(currentCount < requestCount)
				{
					result[currentCount] = hold[help];
					currentCount++;
					help++;
				}
				strh = new String("https://api.guildwars2.com/v2/items?ids=");
				idCount = 0;
			}
			if(idCount < 199)
			{
				strh = strh + id[i] + ",";
				idCount++;
			}
		}
		URL url = new URL(strh);
		String str = read(url);
		Item[] hold = gson.fromJson(str, Item[].class);
		help = 0;
		while(currentCount < id.length)
		{
			result[currentCount] = hold[help];
			currentCount++;
			help++;
		}
		return result;
	}
	
	public Price[] PriceRequestById(int[] id) throws IOException
	{
		Price[] result = new Price[id.length];
		Gson gson = new Gson();
		String strh = new String();
		int idCount = 0,currentCount = 0,requestCount,help;
		strh = new String("https://api.guildwars2.com/v2/commerce/prices?ids=");
		for(int i = 0;i<id.length;i++)
		{
			if(idCount == 199)
			{
				System.out.println(strh);
				URL url = new URL(strh);
				String str = read(url);
				Price[] hold = gson.fromJson(str, Price[].class);
				requestCount = currentCount + hold.length;
				help = 0;
				while(currentCount < requestCount)
				{
					System.out.println("currentCount: " + currentCount + ", requestCount:" + requestCount);
					result[currentCount] = hold[help];
					currentCount++;
					help++;
				}
				strh = new String("https://api.guildwars2.com/v2/commerce/prices?ids=");
				idCount = 0;
			}
			strh = strh + id[i] + ",";
			idCount++;
		}
		System.out.println(strh);
		URL url = new URL(strh);
		String str = read(url);
		Price[] hold = gson.fromJson(str, Price[].class);
		requestCount = currentCount + hold.length;
		help = 0;
		while(currentCount < requestCount)
		{
			System.out.println("currentCount: " + currentCount + ", length:" + requestCount + ", help: " + help);
			result[currentCount] = hold[help];
			currentCount++;
			help++;
		}
		return result;
	}

}
