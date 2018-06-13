package com.xpo.app.model;

public class Client {
	private int id;

	private String client;
	private String clientName;
	private String description;
	private String sharedEnvironment;
	private String whSite;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSharedEnvironment() {
		return sharedEnvironment;
	}
	public void setSharedEnvironment(String sharedEnvironment) {
		this.sharedEnvironment = sharedEnvironment;
	}
	public String getWhSite() {
		return whSite;
	}
	public void setWhSite(String whSite) {
		this.whSite = whSite;
	}
}
