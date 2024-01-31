package com.luklak.gwDAO;

public class Apikey {
	private String id;
	private String name;
	private String permissions[];
	private String type;
	private String expires_at;
	private String issued_at;
	private String urls[];
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getPermissions() {
		return permissions;
	}
	public void setPermissions(String[] permissions) {
		this.permissions = permissions;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExpires_at() {
		return expires_at;
	}
	public void setExpires_at(String expires_at) {
		this.expires_at = expires_at;
	}
	public String getIssued_at() {
		return issued_at;
	}
	public void setIssued_at(String issued_at) {
		this.issued_at = issued_at;
	}
	public String[] getUrls() {
		return urls;
	}
	public void setUrls(String[] urls) {
		this.urls = urls;
	}

}
