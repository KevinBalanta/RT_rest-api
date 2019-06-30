package com.co.redtutores.rest_api.persistence;

import com.co.redtutores.rest_api.commons.entities.Institution;

public interface IInstitutionDAO {
	
	public void createInstitution(Institution inst) throws Exception;
	

	public Institution findById(int id) throws Exception;
	
	public Institution findByName(String name) throws Exception;

}