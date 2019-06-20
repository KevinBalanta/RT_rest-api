package com.co.redtutores.rest_api.services.mappers;

import com.co.redtutores.rest_api.commons.dto.ClientsDTO;
import com.co.redtutores.rest_api.commons.entities.Client;

public interface IClientsMapper {
	
	public Client clientDTOtoClient(ClientsDTO dto);
	
	public ClientsDTO clientToClientDTO(Client client);

}
