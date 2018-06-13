package com.xpo.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xpo.app.model.Deployment;

public class DeploymentMapper implements RowMapper<Deployment> {

	@Override
	public Deployment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Deployment deployment = new Deployment();
		
		deployment.setAppId(rs.getString("APP_ID"));
		deployment.setClient(rs.getString("CLIENT"));
		deployment.setDbName(rs.getString("DB_NAME"));
		deployment.setEnvironment(rs.getString("ENVIRONMENT"));
		deployment.setReleaseDate(rs.getDate("REL_DATE"));
		deployment.setReleaseVersion(rs.getString("RELEASE_VERSION"));
		deployment.setReleaseWho(rs.getString("RELEASE_WHO"));
		deployment.setBuildNumber(rs.getString("BUILD_NUMBER"));

		return deployment;
	}

}
