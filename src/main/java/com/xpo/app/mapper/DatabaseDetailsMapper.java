package com.xpo.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xpo.app.model.DataBaseDetails;

public class DatabaseDetailsMapper  implements RowMapper<DataBaseDetails> {
	
	@Override
	public DataBaseDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		DataBaseDetails db = new DataBaseDetails();
		
		db.setId(rs.getInt("ID"));
		db.setClient(rs.getString("CLIENT_ID"));
		db.setEnvironment(rs.getString("ENVIRONMENT"));
		db.setOmPort(rs.getString("OM_PORT"));
		db.setOmDB(rs.getString("OM_DB"));
		db.setCmPort(rs.getString("CM_PORT"));
		db.setCmDB(rs.getString("CM_DB"));
		db.setWmDB(rs.getString("WM_DB"));
	
	return db;
	}
}
