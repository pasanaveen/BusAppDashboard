package com.xpo.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xpo.app.dao.IDeploymentsDAO;
import com.xpo.app.mapper.DeploymentMapper;
import com.xpo.app.model.Deployment;

@Transactional
@Repository
public class DeploymentsDAOImpl implements IDeploymentsDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public DeploymentsDAOImpl(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
    }
	
	String ADD_DEPLOYMENT_SQL = "INSERT INTO jenkins_deployment(CLIENT,APP_ID,RELEASE_DATE,RELEASE_VERSION,DB_NAME,RELEASE_WHO,ENVIRONMENT) VALUES ( ? ,? ,?, ?, ?, ?, ?)";
	String UPDATE_DEPLOYMENT_SQL = "UPDATE JENKINS_DEPLOYMENT set CLIENT=?,APP_ID=?,RELEASE_DATE=?,RELEASE_VERSION=?,DB_NAME=?,RELEASE_WHO=?,ENVIRONMENT=? where CLIENT = ?";
	String DELETE_DEPLOYMENT_SQL = "DELETE FROM JENKINS_DEPLOYMENT WHERE CLIENT = ? ";
	String GET_DEPLOYMENT_SQL = "SELECT JD.APP_ID, C.CLIENT_NAME AS CLIENT, JD.RELEASE_DATE AS REL_DATE, JD.RELEASE_VERSION, JD.DB_NAME, JD.RELEASE_WHO, JD.ENVIRONMENT, JD.BUILD_NUMBER FROM JENKINS_DEPLOYMENT AS JD INNER JOIN CLIENT AS C ON JD.APP_ID = C.CLIENT WHERE JD.APP_ID = ? ORDER BY RELEASE_DATE;";
	String GET_LATEST_TWO_DEPLOYMENT_SQL = "SELECT JD.APP_ID, C.CLIENT_NAME AS CLIENT, MAX(JD.RELEASE_DATE) AS REL_DATE, JD.RELEASE_VERSION, JD.DB_NAME, JD.RELEASE_WHO, JD.ENVIRONMENT, JD.BUILD_NUMBER FROM JENKINS_DEPLOYMENT AS JD INNER JOIN CLIENT AS C ON JD.APP_ID = C.CLIENT GROUP BY JD.ENVIRONMENT, JD.CLIENT ORDER BY JD.RELEASE_DATE DESC LIMIT 2;";
	String GET_ALL_DEPLOYMENTS_SQL = "SELECT CLIENT,APP_ID,RELEASE_DATE,RELEASE_VERSION,DB_NAME,RELEASE_WHO,ENVIRONMENT, BUILD_NUMBER FROM JENKINS_DEPLOYMENT";
	String GET_LATEST_DEPLOYMENT_SQL = "SELECT JD.APP_ID, C.CLIENT_NAME AS CLIENT, MAX(JD.RELEASE_DATE) AS REL_DATE, JD.RELEASE_VERSION, JD.DB_NAME, JD.RELEASE_WHO, JD.ENVIRONMENT, JD.BUILD_NUMBER FROM JENKINS_DEPLOYMENT AS JD INNER JOIN CLIENT AS C ON JD.APP_ID = C.CLIENT GROUP BY ENVIRONMENT, CLIENT ORDER BY CLIENT;";
	
	@Override
	public void addDeployment(Deployment deployment) {
		int create = jdbcTemplate.update(ADD_DEPLOYMENT_SQL, deployment.getClient(), deployment.getAppId(), deployment.getReleaseDate(), deployment.getReleaseVersion(), deployment.getDbName(), deployment.getReleaseWho(), deployment.getEnvironment());
		
		if(create == 1) {
			System.out.println("Created a Deployment Record");
		}
	}

	@Override
	public List<Deployment> getDeploymentByAppId(String appId) throws SQLException {
		Object[] args = {appId};
		return jdbcTemplate.query(GET_DEPLOYMENT_SQL, args, new DeploymentMapper());
		
	}

	@Override
	public void updateDeploymentByClient(Deployment deployment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDeploymentByClient(String client) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Deployment> getAllDeployments() {
	   //RowMapper<Deployment> rowMapper = new BeanPropertyRowMapper<Deployment>(Deployment.class);
	   RowMapper<Deployment> deploymentMapper = new DeploymentMapper();
	   return this.jdbcTemplate.query(GET_LATEST_DEPLOYMENT_SQL, deploymentMapper);
	}

	@Override
	public boolean deploymentExists(String client, String appId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Deployment> getTopTwoDeployments() {
		   RowMapper<Deployment> rowMapper = new BeanPropertyRowMapper<Deployment>(Deployment.class);
		   return this.jdbcTemplate.query(GET_LATEST_TWO_DEPLOYMENT_SQL, rowMapper);
	} 

}
