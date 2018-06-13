package com.xpo.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.xpo.app.model.Deployment;

public interface IDeploymentsDAO {
	public abstract void addDeployment(Deployment deployment);
	public abstract List<Deployment> getDeploymentByAppId(String appId) throws SQLException;
	public abstract List<Deployment> getAllDeployments();
	public abstract List<Deployment> getTopTwoDeployments();
	public abstract void updateDeploymentByClient(Deployment deployment);
	public abstract void deleteDeploymentByClient(String client);
	boolean deploymentExists(String client, String appId);
}
