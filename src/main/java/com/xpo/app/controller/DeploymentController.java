package com.xpo.app.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xpo.app.model.Deployment;
import com.xpo.app.service.IDeploymentService;

@RestController 
@RequestMapping("/deployment")
public class DeploymentController {
	
	private static final Logger logger = LogManager.getLogger(DeploymentController.class);
	
	@Autowired
	private IDeploymentService deploymentService;
	
	@CrossOrigin	
	@RequestMapping(value = "/get", produces = {"application/JSON"}, method = RequestMethod.GET)
	public @ResponseBody List<Deployment> getAllDeployments() {
		List<Deployment> list = deploymentService.getAllDeployments();
		return list;
	}
	@CrossOrigin	
	@RequestMapping(value = "/getTopTwo", produces = {"application/JSON"}, method = RequestMethod.GET)
	public @ResponseBody List<Deployment> getTopTwoDeployments() {
		System.out.println("In get Method");
		List<Deployment> list = deploymentService.getTopTwoDeployments();
		//System.out.println("After service call");
		System.out.println("List length = " + list.size());
		return list;
	}
	@CrossOrigin
	@RequestMapping(value = "/getAllDeploymentDetails", produces = {"application/JSON"}, method = RequestMethod.GET)
	public @ResponseBody List<Deployment> getAllDeploymentDetails(String appId) throws SQLException {
		System.out.println("Before \n appId = " + appId);
		List<Deployment> list = deploymentService.getDeploymentByAppId(appId);
		System.out.println("After\n" + list.size());
		return list;
	} 
	@CrossOrigin
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public @ResponseBody boolean addDeployment(@RequestBody Deployment  deployment) throws SQLException {
		System.out.println("In add Method");
		System.out.println("Client = " + deployment.getClient());
		System.out.println("AppId = " + deployment.getAppId());

		boolean addFlag = deploymentService.addDeployment(deployment);
		return addFlag;
	} 
}
