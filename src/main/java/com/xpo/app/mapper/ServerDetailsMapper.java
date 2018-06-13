package com.xpo.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.xpo.app.model.ServerDetails;

public class ServerDetailsMapper implements RowMapper<ServerDetails> {
	
	@Override
	public ServerDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		ServerDetails server = new ServerDetails();
		
		server.setId(rs.getInt("ID"));
		server.setClient(rs.getString("CLIENT_ID"));
	 	server.setName(rs.getString("NAME"));
		server.setDescription(rs.getString("DESCRIPTION"));
		server.setEnvironment(rs.getString("ENVIRONMENT"));
		server.setTeam(rs.getString("TEAM"));
		server.setTomcatVersion(rs.getString("TOMCAT_VERSION"));
		server.setJavaVersion(rs.getString("JAVA_VERSION"));	
		
		return server;
	}
}
