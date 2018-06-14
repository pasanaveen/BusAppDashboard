package com.xpo.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.xpo.app.model.ServerDetails;


public interface IServerDetailsDAO {
	public abstract List<ServerDetails> getServerDetailsByClient(String client) throws SQLException ;
}
