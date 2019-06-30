/**
 * 
 */
package com.co.redtutores.rest_api.services;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.co.redtutores.rest_api.commons.dto.ClientsDTO;
import com.co.redtutores.rest_api.commons.entities.Account;
import com.co.redtutores.rest_api.commons.entities.City;
import com.co.redtutores.rest_api.commons.entities.Client;
import com.co.redtutores.rest_api.commons.entities.Institution;
import com.co.redtutores.rest_api.delegate.AccountDelegate;
import com.co.redtutores.rest_api.delegate.ClientsDelegate;
import com.co.redtutores.rest_api.persistence.CityDAO;
import com.co.redtutores.rest_api.persistence.ICityDAO;
import com.co.redtutores.rest_api.persistence.IInstitutionDAO;
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
	private AccountDelegate accountDelegate;
	@Autowired
	private ICityDAO cityDAO;
	@Autowired
	private IInstitutionDAO instDAO;
	
	@Autowired
	private IClientsMapper clientsMapper;
	
	//@PostMapping(value = "/createClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@RequestMapping(value = "/createClient", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Client> createClient(@RequestBody ClientsDTO c) {
		ResponseEntity<Client> resp = null;
		Client newClient = null;
		try {
			newClient = clientsMapper.clientDTOtoClient(c);
			
			Account account = new Account();
			account.setAccountUsername(c.getUsername());
			account.setAccountPassword(c.getPassword());
			
			if(accountDelegate.findByUserName(account.getAccountUsername()) != null) {
				throw new Exception("el username ya existe : "+ account.getAccountUsername());
			}else {
				
				log.info(newClient.getClientName());
				log.info(newClient.getClientId());
				accountDelegate.createAccount(account);
				newClient.setAccount(account);
				City city = cityDAO.findByNameAndStateName(c.getCity(), c.getState());
				newClient.setCity(city);
				Institution inst = instDAO.findByName(c.getInstitution());
				newClient.setInstitution(inst);
				clientsDelegate.createClient(newClient);
				
			}
			
			resp = new ResponseEntity<Client>(newClient, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			resp = new ResponseEntity<Client>(newClient, HttpStatus.BAD_REQUEST);
		}
		return resp;
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
