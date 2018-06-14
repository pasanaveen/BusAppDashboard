package com.xpo.app.model;

public class ServerInstanceDetails {
	private int Id;
	private String serverName;
	private String serverInstance1;
	private String serverInstance2;
	private String serverInstance3;
	private String serverInstance4;
	private String client;
	private String environment;
	private String description;
	
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
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getServerInstance1() {
		return serverInstance1;
	}
	public void setServerInstance1(String serverInstance1) {
		this.serverInstance1 = serverInstance1;
	}
	public String getServerInstance2() {
		return serverInstance2;
	}
	public void setServerInstance2(String serverInstance2) {
		this.serverInstance2 = serverInstance2;
	}
	public String getServerInstance3() {
		return serverInstance3;
	}
	public void setServerInstance3(String serverInstance3) {
		this.serverInstance3 = serverInstance3;
	}
	public String getServerInstance4() {
		return serverInstance4;
	}
	public void setServerInstance4(String serverInstance4) {
		this.serverInstance4 = serverInstance4;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
