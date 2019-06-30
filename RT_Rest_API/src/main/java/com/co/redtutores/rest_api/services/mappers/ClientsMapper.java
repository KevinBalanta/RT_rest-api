package com.co.redtutores.rest_api.services.mappers;

import java.time.LocalDate;

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
		c.setClientLastname(dto.getLastName());
		c.setClientBirth(dto.getBirthday());
		c.setClientPhone(dto.getPhoneNumber());
		c.setClientSemester(dto.getSemesterNumber());
		
		
		return c;
	}

	@Override
	public ClientsDTO clientToClientDTO(Client client) {
		ClientsDTO dto = new ClientsDTO();
		dto.setClientCode(client.getClientId());
		dto.setClientName(client.getClientName());
		dto.setLastName(client.getClientLastname());
		dto.setBirthday(client.getClientBirth());
		dto.setPhoneNumber(client.getClientPhone());
		dto.setPhoneNumber(client.getClientPhone());
		
		return dto;
	}

}
