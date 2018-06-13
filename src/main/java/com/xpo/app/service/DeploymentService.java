package com.xpo.app.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xpo.app.dao.IDeploymentsDAO;
import com.xpo.app.model.Deployment;

@Service
public class DeploymentService implements IDeploymentService {

	@Autowired
	private IDeploymentsDAO deploymentsDAO;
	
	@Override
	public List<Deployment> getAllDeployments() {
		return deploymentsDAO.getAllDeployments();
	}

	@Override
	public List<Deployment> getDeploymentByAppId(String appId) throws SQLException {
		return deploymentsDAO.getDeploymentByAppId(appId);
		
	}

	@Override
	public synchronized boolean addDeployment(Deployment deployment) {
		if (deploymentsDAO.deploymentExists(deployment.getClient(), deployment.getAppId())) {
	          return false;
          } else {
        	  deploymentsDAO.addDeployment(deployment);
	          return true;
          }
	}

	@Override
	public void updateDeployment(Deployment deployment) {
		deploymentsDAO.updateDeploymentByClient(deployment);

	}

	@Override
	public void deleteDeployment(String client) {
		deploymentsDAO.deleteDeploymentByClient(client);

	}

	@Override
	public List<Deployment> getTopTwoDeployments() {
		return deploymentsDAO.getTopTwoDeployments();
	}

}
