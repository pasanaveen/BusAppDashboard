package com.xpo.app.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xpo.app.model.ServerInstanceDetails;

public class ServerInstanceMapper implements RowMapper<ServerInstanceDetails> {
	
	@Override
	public ServerInstanceDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
	ServerInstanceDetails serverInstance = new ServerInstanceDetails();
	
	serverInstance.setId(rs.getInt("ID"));
	serverInstance.setClient(rs.getString("CLIENT_ID"));
	serverInstance.setEnvironment(rs.getString("ENVIRONMENT"));
	serverInstance.setDescription(rs.getString("DESCRIPTION"));
	serverInstance.setServerName(rs.getString("SERVER_NAME"));
	serverInstance.setServerInstance1(rs.getString("INSTANCE1"));
	serverInstance.setServerInstance2(rs.getString("INSTANCE2"));
	serverInstance.setServerInstance3(rs.getString("INSTANCE3"));
	serverInstance.setServerInstance4(rs.getString("INSTANCE4"));
	return serverInstance;
	}
}
