package com.xpo.app.service;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpo.app.dao.IClientDAO;
import com.xpo.app.model.Client;
import com.xpo.app.model.DataBaseDetails;
import com.xpo.app.model.ServerDetails;
import com.xpo.app.model.ServerInstanceDetails;
import com.xpo.app.model.UrlDetails;

@Service
public class ClientService implements IClientService {

	@Autowired
	private IClientDAO clientDAO;
	
	@Override
	public List<Client> getAllClients()  throws SQLException{
		return clientDAO.getAllClients();
	}
	
	@Override
	public List<Client> getAllClientsByClient(String client) throws SQLException {
		return clientDAO.getAllClientsByClient(client);
	}

	@Override
	public List<Client> getAllClientsByClientName(String clientName) throws SQLException {
		return clientDAO.getAllClientsByClientName(clientName);
	}

	@Override
	public List<Client> getAllClientsBySharedEnvironment(String sharedEnv) throws SQLException {
		return clientDAO.getAllClientsBySharedEnvironment(sharedEnv);
	}
	
	@Override
	public List<Client> filterClients(String clientName) throws SQLException {
		return clientDAO.filterClients(clientName);
	}
	
	@Override
	public boolean addClient(Client client) {
		return clientDAO.addClient(client);
	}

	@Override
	public boolean updateClient(Client client) {
		return clientDAO.updateClient(client);

	}

	@Override
	public int deleteClient(int id) {
		return clientDAO.deleteClient(id);

	}
	@Override
	public List<DataBaseDetails> getDBListByClient(String client) throws SQLException {
		return clientDAO.getDBListByClient(client);
	}
	@Override
	public boolean addClientDB(DataBaseDetails db) {
		return clientDAO.addClientDB(db);
	}

	@Override
	public boolean updateClientDB(DataBaseDetails db) {
		return clientDAO.updateClientDB(db);
	}

	@Override
	public int deleteClientDB(int id) {
		return clientDAO.deleteClientDB(id);
	}

	@Override
	public List<ServerDetails> getSDListByClient(String client) throws SQLException {
		return clientDAO.getSDListByClient(client);
	}

	@Override
	public List<ServerInstanceDetails> getSIListByClient(String client) throws SQLException {
		return clientDAO.getSIListByClient(client);
	}

	@Override
	public List<UrlDetails> getLinkListByClient(String client) throws SQLException {
		return clientDAO.getLinkListByClient(client);
	}

}
