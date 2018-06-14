package com.xpo.app.dao.impl;

import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xpo.app.dao.IClientDAO;
import com.xpo.app.mapper.ClientMapper;
import com.xpo.app.mapper.DatabaseDetailsMapper;
import com.xpo.app.mapper.ServerDetailsMapper;
import com.xpo.app.mapper.ServerInstanceMapper;
import com.xpo.app.mapper.URLMapper;
import com.xpo.app.model.Client;
import com.xpo.app.model.DataBaseDetails;
import com.xpo.app.model.ServerDetails;
import com.xpo.app.model.ServerInstanceDetails;
import com.xpo.app.model.UrlDetails;
import com.xpo.app.util.Utils;

@Transactional
@Repository
public class ClientDAOImpl implements IClientDAO {
	private static final Logger logger = LogManager.getLogger(ToDoDAOImpl.class);
	private JdbcTemplate jdbcTemplate;
	private Utils utils = new Utils();
	
	@Autowired
    public ClientDAOImpl(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
    }
	
	String GET_CLIENT_SQL = "SELECT ID, CLIENT, CLIENT_NAME, DESCRIPTION, SHARED_ENVIRONMENT, WH_SITE FROM CLIENT ORDER BY CLIENT_NAME";
	String GET_CLIENT_BY_CLIENT_SQL = "SELECT ID, CLIENT, CLIENT_NAME, DESCRIPTION, SHARED_ENVIRONMENT, WH_SITE FROM CLIENT WHERE CLIENT like upper(?)";
	String GET_CLIENT_BY_CLIENT_NAME_SQL = "SELECT ID, CLIENT, CLIENT_NAME, DESCRIPTION, SHARED_ENVIRONMENT, WH_SITE FROM CLIENT WHERE CLIENT_NAME like upper(?)";
	String FILTER_CLIENTS = "SELECT ID, CLIENT, CLIENT_NAME, DESCRIPTION, SHARED_ENVIRONMENT, WH_SITE FROM CLIENT WHERE CLIENT_NAME like upper(?) OR CLIENT like upper(?) ORDER BY CLIENT_NAME";
	String GET_CLIENT_BY_SHARED_ENVIRONMENT_SQL = "SELECT ID, CLIENT, CLIENT_NAME, DESCRIPTION, SHARED_ENVIRONMENT, WH_SITE FROM CLIENT WHERE SHARED_ENVIRONMENT like upper(?)";
	String ADD_CLIENT_SQL = "INSERT INTO client(CLIENT,CLIENT_NAME,DESCRIPTION,SHARED_ENVIRONMENT, WH_SITE) VALUES (?,?,?,?, ?)";
	String UPDATE_CLIENT_SQL = "UPDATE client SET CLIENT = ?,CLIENT_NAME = ?,DESCRIPTION = ?,SHARED_ENVIRONMENT = ?, WH_SITE = ? WHERE ID = ?";
	String DELETE_CLIENT_SQL = "DELETE FROM client WHERE ID = ?";
	
	//CLIENT DATABASE SECTION
	String GET_CLIENT_DATABASE_BY_CLIENT_SQL = "SELECT ID, CLIENT_ID, DESCRIPTION, ENVIRONMENT, OM_PORT, OM_DB, CM_DB, WM_DB, CM_PORT FROM database_details WHERE CLIENT_ID like upper(?)";
	String ADD_CLIENT_DATABASE_DETAILS_SQL = "INSERT INTO database_details(CLIENT_ID,DESCRIPTION,ENVIRONMENT,OM_PORT,OM_DB,CM_DB,WM_DB,CM_PORT) VALUES (?,?,?,?,?,?,?,?)";
	String UPDATE_CLIENT_DATABASE_DETAILS_SQL = "UPDATE database_details SET CLIENT_ID = ? , DESCRIPTION = ?, ENVIRONMENT = ?, OM_PORT = ?, OM_DB = ?, CM_DB = ?, WM_DB = ?, CM_PORT = ? WHERE ID = ?";
	String DELETE_CLIENT_DATABASE_DETAILS_SQL = "DELETE FROM database_details WHERE ID = ?";
	
	//CLIENT SERVER DETAILS SECTION
	String GET_CLIENT_SERVER_DETAILS_BY_CLIENT_SQL = "SELECT ID, CLIENT_ID, NAME, DESCRIPTION, ENVIRONMENT, TEAM, TOMCAT_VERSION, JAVA_VERSION FROM server_details WHERE CLIENT_ID like upper(?)";

	//CLIENT SERVER INSTANCE SECTION
	String GET_CLIENT_SERVER_INSTANCE_BY_CLIENT_SQL = "SELECT ID, CLIENT_ID, DESCRIPTION, ENVIRONMENT, SERVER_NAME, INSTANCE1, INSTANCE2, INSTANCE3, INSTANCE4 FROM server_instance WHERE CLIENT_ID like upper(?)";

	//CLIENT LINK SECTION
	String GET_CLIENT_LINK_DETAILS_BY_CLIENT_SQL = "SELECT ID, CLIENT_ID, NAME, DESCRIPTION, ENVIRONMENT, JOBS_HTTP_URL, WEB_HTTP_URL, WEB_HTTPS_URL, UF_WEB_URL, UF_SRV_URL, UF_MC_URL FROM url WHERE CLIENT_ID like upper(?)";

	@Override
	public List<Client> getAllClients()  throws SQLException {
		RowMapper<Client> clientMapper = new ClientMapper();
		return this.jdbcTemplate.query(GET_CLIENT_SQL, clientMapper);
	}

	@Override
	public List<Client> getAllClientsByClient(String client) throws SQLException {
		Object[] args = {utils.addWildCard(client)};
		RowMapper<Client> clientMapper = new ClientMapper();
		return this.jdbcTemplate.query(GET_CLIENT_BY_CLIENT_SQL, args, clientMapper);
	}

	@Override
	public List<Client> getAllClientsByClientName(String clientName) throws SQLException {
		Object[] args = {utils.addWildCard(clientName)};
		System.out.println("Inside the getAllClientsByClientName method");
		RowMapper<Client> clientMapper = new ClientMapper();
		return this.jdbcTemplate.query(GET_CLIENT_BY_CLIENT_NAME_SQL, args, clientMapper);
	}

	@Override
	public List<Client> getAllClientsBySharedEnvironment(String sharedEnv) throws SQLException {
		Object[] args = {utils.addWildCard(sharedEnv)};
		RowMapper<Client> clientMapper = new ClientMapper();
		return this.jdbcTemplate.query(GET_CLIENT_BY_SHARED_ENVIRONMENT_SQL, args, clientMapper);
	}
	
	@Override
	public List<Client> filterClients(String clientName) throws SQLException {
		Object[] args = {utils.addWildCard(clientName), utils.addWildCard(clientName)};
		System.out.println("Inside the filter client method");
		RowMapper<Client> clientMapper = new ClientMapper();
		return this.jdbcTemplate.query(FILTER_CLIENTS, args, clientMapper);
	}
	
	@Override
	public boolean addClient(Client client) {
		System.out.println("client name = " + client.getClientName());
		int add = jdbcTemplate.update(ADD_CLIENT_SQL, client.getClient(), client.getClientName(), client.getDescription(), client.getSharedEnvironment(), client.getWhSite());
		
		if(add == 1) {
			logger.debug("Created a Client Record");
			return true;
		} else {
			logger.error("Record not added");
			return false;
		}
	}

	@Override
	public boolean updateClient(Client client) {
		System.out.println("id value = " + client.getId());
		int add = jdbcTemplate.update(UPDATE_CLIENT_SQL, client.getClient(), client.getClientName(), client.getDescription(), client.getSharedEnvironment(), client.getWhSite(), client.getId());		
		
		if(add == 1) {
			logger.debug("Created a Client Record");
			return true;
		} else {
			logger.error("Record not added");
			return false;
		}
	}

	@Override
	public int deleteClient(int id) {
		Object[] params = { id };
		int[] types = {Types.VARCHAR};
		
		int rows = jdbcTemplate.update(DELETE_CLIENT_SQL, params, types);
		
		logger.debug("Row Deleted = " + rows);
		return rows;
	}
	
	@Override
	public List<DataBaseDetails> getDBListByClient(String client) throws SQLException{
		Object[] args = {utils.addWildCard(client)};
		RowMapper<DataBaseDetails> dbMapper = new DatabaseDetailsMapper();
		return this.jdbcTemplate.query(GET_CLIENT_DATABASE_BY_CLIENT_SQL, args, dbMapper);
	}
	@Override
	public boolean addClientDB(DataBaseDetails db) {
		System.out.println("db name = " + db.getOmDB());
		int add = jdbcTemplate.update(ADD_CLIENT_DATABASE_DETAILS_SQL, db.getClient(), db.getDescription(), db.getEnvironment(), db.getOmPort(), db.getOmDB(), db.getCmDB(), db.getWmDB(), db.getCmPort() );
		
		if(add == 1) {
			logger.debug("Created a Client DataBase Record");
			return true;
		} else {
			logger.error("Record not added");
			return false;
		}
	}

	@Override
	public boolean updateClientDB(DataBaseDetails db) {
		System.out.println("db name = " + db.getOmDB());
		int add = jdbcTemplate.update(UPDATE_CLIENT_DATABASE_DETAILS_SQL, db.getClient(), db.getDescription(), db.getEnvironment(), db.getOmPort(), db.getOmDB(), db.getCmDB(), db.getWmDB(), db.getCmPort(), db.getId());		
		
		if(add == 1) {
			logger.debug("Created a Client Record");
			return true;
		} else {
			logger.error("Record not added");
			return false;
		}
	}

	@Override
	public int deleteClientDB(int id) {
		Object[] params = { id };
		int[] types = {Types.VARCHAR};
		
		int rows = jdbcTemplate.update(DELETE_CLIENT_DATABASE_DETAILS_SQL, params, types);
		
		logger.debug("Row Deleted = " + rows);
		return rows;
	}
	
	
	@Override
	public List<ServerDetails> getSDListByClient(String client) throws SQLException{
		Object[] args = {utils.addWildCard(client)};
		RowMapper<ServerDetails> sdMapper = new ServerDetailsMapper();
		return this.jdbcTemplate.query(GET_CLIENT_SERVER_DETAILS_BY_CLIENT_SQL, args, sdMapper);
	}
	
	@Override
	public List<ServerInstanceDetails> getSIListByClient(String client) throws SQLException{
		Object[] args = {utils.addWildCard(client)};
		RowMapper<ServerInstanceDetails> siMapper = new ServerInstanceMapper();
		return this.jdbcTemplate.query(GET_CLIENT_SERVER_INSTANCE_BY_CLIENT_SQL, args, siMapper);
	}
	
	@Override
	public List<UrlDetails> getLinkListByClient(String client) throws SQLException{
		Object[] args = {utils.addWildCard(client)};
		RowMapper<UrlDetails> urlMapper = new URLMapper();
		return this.jdbcTemplate.query(GET_CLIENT_LINK_DETAILS_BY_CLIENT_SQL, args, urlMapper);
	}
}
