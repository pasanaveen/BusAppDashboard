package com.xpo.app.service;

import java.sql.SQLException;
import java.util.List;

import com.xpo.app.model.Client;
import com.xpo.app.model.DataBaseDetails;
import com.xpo.app.model.ServerDetails;
import com.xpo.app.model.ServerInstanceDetails;
import com.xpo.app.model.UrlDetails;

public interface IClientService {

	List<Client> getAllClients() throws SQLException;
	List<Client> getAllClientsByClient(String client) throws SQLException;
	List<Client> getAllClientsByClientName(String clientName) throws SQLException;
	List<Client> getAllClientsBySharedEnvironment(String sharedEnv) throws SQLException;
	List<Client> filterClients(String clientName) throws SQLException;
    boolean addClient(Client client);
    boolean updateClient(Client client);
    int deleteClient(int id);
    public List<DataBaseDetails> getDBListByClient(String client) throws SQLException;
    boolean addClientDB(DataBaseDetails db);
    boolean updateClientDB(DataBaseDetails db);
    int deleteClientDB(int id);
    public List<ServerDetails> getSDListByClient(String client) throws SQLException;
    public List<ServerInstanceDetails> getSIListByClient(String client) throws SQLException;
    public List<UrlDetails> getLinkListByClient(String client) throws SQLException;
}
