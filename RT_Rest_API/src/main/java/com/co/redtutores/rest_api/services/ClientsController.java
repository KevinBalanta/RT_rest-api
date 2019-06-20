/**
 * 
 */
package com.co.redtutores.rest_api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.co.redtutores.rest_api.commons.dto.ClientsDTO;
import com.co.redtutores.rest_api.commons.entities.Client;
import com.co.redtutores.rest_api.delegate.ClientsDelegate;
import com.co.redtutores.rest_api.services.mappers.IClientsMapper;

/**
 * @author Santiago
 *
 */
@Controller
@RequestMapping("/clients")
public class ClientsController {
	
	private final static Logger log = LoggerFactory.getLogger(ClientsController.class);
	
	@Autowired
	private ClientsDelegate clientsDelegate;
	
	@Autowired
	private IClientsMapper clientsMapper;
	
	//@PostMapping(value = "/createClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@RequestMapping(value = "/createClient", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void createClient(@RequestBody ClientsDTO c) {
		try {
			Client newClient = clientsMapper.clientDTOtoClient(c);
			log.info(newClient.getClientCode());
			log.info(newClient.getClientName());
			clientsDelegate.createClient(newClient);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	//@GetMapping(value = "/findClient/{clientCode}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@RequestMapping(value = "/findClient", method = RequestMethod.GET)
	@ResponseBody
	public ClientsDTO findClient(@RequestParam(name = "clientCode") String clientCode) {
		Client client = null;
		ClientsDTO clientRequired = null;
		try {
			client = clientsDelegate.findClient(clientCode);
			clientRequired = clientsMapper.clientToClientDTO(client);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return clientRequired;
	}
	
}
