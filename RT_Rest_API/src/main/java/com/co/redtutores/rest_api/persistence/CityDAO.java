package com.co.redtutores.rest_api.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.*;
import org.springframework.stereotype.Repository;

import com.co.redtutores.rest_api.commons.entities.City;
/**
 * 
 * @author kevin david
 *
 */
@Repository
public class CityDAO implements ICityDAO{
	
	private final static Logger log = LoggerFactory.getLogger(CityDAO.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void createCity(City city) throws Exception {
		// TODO Auto-generated method stub
		try {
		log.info("[Persistence] city name : "+ city.getCityName());
		log.info("[Persistence] city id: " + city.getCityId());
		entityManager.persist(city);
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new Exception("An error ocurred at the persistence layer: " + e.getMessage());
		}
		
	}

	@Override
	public City findById(int id) throws Exception {
		// TODO Auto-generated method stub
		City city = null;
		city = entityManager.find(City.class, id);
		return city;
	}

	@Override
	public City findByNameAndStateName(String cityName, String stateName) throws Exception {
		// TODO Auto-generated method stub
		
		String jp = "SELECT a FROM City a WHERE a.cityName = :cityNa AND a.state.stateName = :stateNa";
		Query q = entityManager.createQuery(jp);
		q.setParameter("cityNa", cityName);
		q.setParameter("stateNa", stateName);
		
		return (City) q.getSingleResult();
	}

}
