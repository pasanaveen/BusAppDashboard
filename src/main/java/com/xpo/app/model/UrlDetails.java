package com.xpo.app.model;

public class UrlDetails {
	private int Id;
	private String jobsHttpUrl;
	private String webHttpUrl;
	private String webHttpsUrl;
	private String userFriendlyWebUrl;
	private String userFriendlyServiceUrl;
	private String userFriendlyMCUrl;
	private String client;
	private String environment;	
	private String name;
	private String description;
	
	
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getUserFriendlyWebUrl() {
		return userFriendlyWebUrl;
	}
	public void setUserFriendlyWebUrl(String userFriendlyWebUrl) {
		this.userFriendlyWebUrl = userFriendlyWebUrl;
	}
	public String getUserFriendlyServiceUrl() {
		return userFriendlyServiceUrl;
	}
	public void setUserFriendlyServiceUrl(String userFriendlyServiceUrl) {
		this.userFriendlyServiceUrl = userFriendlyServiceUrl;
	}
	public String getUserFriendlyMCUrl() {
		return userFriendlyMCUrl;
	}
	public void setUserFriendlyMCUrl(String userFriendlyMCUrl) {
		this.userFriendlyMCUrl = userFriendlyMCUrl;
	}
	public String getJobsHttpUrl() {
		return jobsHttpUrl;
	}
	public void setJobsHttpUrl(String jobsHttpUrl) {
		this.jobsHttpUrl = jobsHttpUrl;
	}
	public String getWebHttpUrl() {
		return webHttpUrl;
	}
	public void setWebHttpUrl(String webHttpUrl) {
		this.webHttpUrl = webHttpUrl;
	}
	public String getWebHttpsUrl() {
		return webHttpsUrl;
	}
	public void setWebHttpsUrl(String webHttpsUrl) {
		this.webHttpsUrl = webHttpsUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
