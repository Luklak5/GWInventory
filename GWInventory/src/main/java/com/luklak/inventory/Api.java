package com.luklak.inventory;

import java.io.IOException;
import java.net.URL;

import com.google.gson.Gson;
import com.luklak.gwDAO.Apikey;

public class Api {
	public boolean ApiCheck(String api,String access) throws IOException
	{
		boolean valid = false;
		URL url = new URL("https://api.guildwars2.com/v2/tokeninfo?access_token=" + api);
		GetJSON json = new GetJSON();
		Gson gson = new Gson();
		System.out.println(api);
		System.out.println(url);
		String str = json.read(url);
		Apikey key = gson.fromJson(str, Apikey.class);
		String perms[] = key.getPermissions();
		for(int i = 0;i<key.getPermissions().length;i++)
		{
			if(perms[i] == access)
			{
				valid = true;
			}
		}
		return valid;
	}
}
