package com.xpo.app.service;

import java.sql.SQLException;
import java.util.List;
import com.xpo.app.model.Deployment;

public interface IDeploymentService {
	List<Deployment> getAllDeployments();
	List<Deployment> getTopTwoDeployments();
	List<Deployment> getDeploymentByAppId(String appId) throws SQLException;
    boolean addDeployment(Deployment deployment);
    void updateDeployment(Deployment deployment);
    void deleteDeployment(String client);
}
