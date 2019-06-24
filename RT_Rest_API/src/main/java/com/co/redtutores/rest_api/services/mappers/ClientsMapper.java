package com.co.redtutores.rest_api.services.mappers;

import org.springframework.stereotype.Component;

import com.co.redtutores.rest_api.commons.dto.ClientsDTO;
import com.co.redtutores.rest_api.commons.entities.Client;

@Component
public class ClientsMapper implements IClientsMapper {

	@Override
	public Client clientDTOtoClient(ClientsDTO dto) {
		Client c = new Client();
		c.setClientId(dto.getClientCode());
		c.setClientName(dto.getClientName());
		return c;
	}

	@Override
	public ClientsDTO clientToClientDTO(Client client) {
		ClientsDTO dto = new ClientsDTO();
		dto.setClientCode(client.getClientId());
		dto.setClientName(client.getClientName());
		return dto;
	}

}
