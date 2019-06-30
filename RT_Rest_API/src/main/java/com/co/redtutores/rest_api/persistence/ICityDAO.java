package com.co.redtutores.rest_api.persistence;


import com.co.redtutores.rest_api.commons.entities.City;

public interface ICityDAO {

	
	public void createCity(City city) throws Exception;
	
	public City findById(int id) throws Exception;
	
	public City findByNameAndStateName(String cityName, String stateName) throws Exception;
	
}
