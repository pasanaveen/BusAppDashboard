package com.xpo.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xpo.app.model.Client;


public class ClientMapper implements RowMapper<Client> {

	@Override
	public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
		Client client = new Client();
		
		client.setId(rs.getInt("ID"));
		client.setClient(rs.getString("CLIENT"));
		client.setClientName(rs.getString("CLIENT_NAME"));
		client.setDescription(rs.getString("DESCRIPTION"));
		client.setSharedEnvironment(rs.getString("SHARED_ENVIRONMENT"));
		client.setWhSite(rs.getString("WH_SITE"));
		
		return client;
	}
}
