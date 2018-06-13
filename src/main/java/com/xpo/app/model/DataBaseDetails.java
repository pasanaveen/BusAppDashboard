package com.xpo.app.model;

public class DataBaseDetails {
	private int id;
	private String client;
	private String description;
	private String environment;
	private String omDB;
	private String cmDB;
	private String wmDB;
	private String omPort;
	private String cmPort;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOmPort() {
		return omPort;
	}
	public void setOmPort(String omPort) {
		this.omPort = omPort;
	}
	public String getCmPort() {
		return cmPort;
	}
	public void setCmPort(String cmPort) {
		this.cmPort = cmPort;
	}
	public String getOmDB() {
		return omDB;
	}
	public void setOmDB(String omDB) {
		this.omDB = omDB;
	}
	public String getCmDB() {
		return cmDB;
	}
	public void setCmDB(String cmDB) {
		this.cmDB = cmDB;
	}
	public String getWmDB() {
		return wmDB;
	}
	public void setWmDB(String wmDB) {
		this.wmDB = wmDB;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
}
