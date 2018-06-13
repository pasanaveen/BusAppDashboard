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
import org.springframework.web.bind.annotation.RestController;

import com.xpo.app.model.Client;
import com.xpo.app.model.DataBaseDetails;
import com.xpo.app.model.ServerDetails;
import com.xpo.app.model.ServerInstanceDetails;
import com.xpo.app.model.UrlDetails;
import com.xpo.app.service.IClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	private static final Logger logger = LogManager.getLogger(ClientController.class);
	
	@Autowired
	private IClientService _clientService;
	public ClientController(IClientService clientService) {
		super();
		logger.debug("In the constructor");
		this._clientService = clientService;
	}
	
	@CrossOrigin
	@RequestMapping(value = "get", produces = {"application/JSON"}, method = RequestMethod.GET)
	public List<Client> getClientList() throws SQLException {
		return _clientService.getAllClients();
	}
	@CrossOrigin
	@RequestMapping(value = "getByClient", produces = {"application/JSON"}, method = RequestMethod.GET)
	public List<Client> getClientListByClient(String client) throws SQLException {
		return _clientService.getAllClientsByClient(client);
	}
	@CrossOrigin
	@RequestMapping(value = "getByClientName", produces = {"application/JSON"}, method = RequestMethod.GET)
	public List<Client> getClientListByClientName(String clientName) throws SQLException {
		return _clientService.getAllClientsByClientName(clientName);
	}
	@CrossOrigin
	@RequestMapping(value = "getBySharedEnv", produces = {"application/JSON"}, method = RequestMethod.GET)
	public List<Client> getClientListBySharedEnvironment(String sharedEnv) throws SQLException {
		return _clientService.getAllClientsBySharedEnvironment(sharedEnv);
	}	
	@CrossOrigin
	@RequestMapping(value = "filterClients", produces = {"application/JSON"}, method = RequestMethod.GET)
	public List<Client> filterClients(String clientName) throws SQLException {
		return _clientService.filterClients(clientName);
	}	
	@CrossOrigin
	@RequestMapping(value = "/add", produces = {"application/JSON"}, method = RequestMethod.POST)
	public boolean addClient(@RequestBody Client client) throws SQLException {
		System.out.println("$$$$ Client Name = " + client.getClientName());
		return _clientService.addClient(client);
	}
	@CrossOrigin
	@RequestMapping(value = "/update", produces = {"application/JSON"}, method = RequestMethod.PUT)
	public boolean updateClient(@RequestBody Client client) throws SQLException {
		System.out.println("Client Name = " + client.getClientName());
		//logger.debug("Client Name = " + client.getClientName());
		return _clientService.updateClient(client);
	}	
	@CrossOrigin
	@RequestMapping(value = "/delete", produces = {"application/JSON"}, method = RequestMethod.DELETE)
	public int deleteClient(int id) throws SQLException {
		logger.debug("id = " + id);
		return _clientService.deleteClient(id);
	}
	/*
	 * DataBase Section
	 * */
	@CrossOrigin
	@RequestMapping(value = "/db/get", produces = {"application/JSON"}, method = RequestMethod.GET)
	public List<DataBaseDetails> getDBListByClient(String client) throws SQLException {
		List<DataBaseDetails> tempList =  _clientService.getDBListByClient(client);
		
		for (DataBaseDetails db: tempList) {
			System.out.println("OM DB VALUE === " + db.getOmDB());
		}
		
		return tempList;
	}
	@CrossOrigin
	@RequestMapping(value = "/db/add", produces = {"application/JSON"}, method = RequestMethod.POST)
	public boolean addClientDB(@RequestBody DataBaseDetails db) throws SQLException {
		System.out.println("$$$$ OM DB Name = " + db.getOmDB());
		return _clientService.addClientDB(db);
	}
	@CrossOrigin
	@RequestMapping(value = "/db/update", produces = {"application/JSON"}, method = RequestMethod.PUT)
	public boolean updateClientDB(@RequestBody DataBaseDetails db) throws SQLException {
		System.out.println("OM DB Name = " + db.getOmDB());
		//logger.debug("Client Name = " + client.getClientName());
		return _clientService.updateClientDB(db);
	}	
	@CrossOrigin
	@RequestMapping(value = "/db/delete", produces = {"application/JSON"}, method = RequestMethod.DELETE)
	public int deleteClientDB(int id) throws SQLException {
		logger.debug("id = " + id);
		return _clientService.deleteClientDB(id);
	}	
	/*
	 * Server Details Section
	 * */
	@CrossOrigin
	@RequestMapping(value = "/sd/get", produces = {"application/JSON"}, method = RequestMethod.GET)
	public List<ServerDetails> getSDListByClient(String client) throws SQLException {
		return _clientService.getSDListByClient(client);
	}
	@CrossOrigin
	@RequestMapping(value = "/sd/add", produces = {"application/JSON"}, method = RequestMethod.POST)
	public boolean addClientSD(@RequestBody DataBaseDetails db) throws SQLException {
		System.out.println("$$$$ OM DB Name = " + db.getOmDB());
		return _clientService.addClientDB(db);
	}
	@CrossOrigin
	@RequestMapping(value = "/sd/update", produces = {"application/JSON"}, method = RequestMethod.PUT)
	public boolean updateClientSD(@RequestBody DataBaseDetails db) throws SQLException {
		System.out.println("OM DB Name = " + db.getOmDB());
		//logger.debug("Client Name = " + client.getClientName());
		return _clientService.updateClientDB(db);
	}	
	@CrossOrigin
	@RequestMapping(value = "/sd/delete", produces = {"application/JSON"}, method = RequestMethod.DELETE)
	public int deleteClientSD(int id) throws SQLException {
		logger.debug("id = " + id);
		return _clientService.deleteClientDB(id);
	}	
	
	/*
	 * Server Instance Section
	 * */
	@CrossOrigin
	@RequestMapping(value = "/si/get", produces = {"application/JSON"}, method = RequestMethod.GET)
	public List<ServerInstanceDetails> getSIListByClient(String client) throws SQLException {
		return _clientService.getSIListByClient(client);
	}
	
	/*
	 * Link Section
	 * */
	@CrossOrigin
	@RequestMapping(value = "/links/get", produces = {"application/JSON"}, method = RequestMethod.GET)
	public List<UrlDetails> getUrlListByClient(String client) throws SQLException {
		return _clientService.getLinkListByClient(client);
	}
}
