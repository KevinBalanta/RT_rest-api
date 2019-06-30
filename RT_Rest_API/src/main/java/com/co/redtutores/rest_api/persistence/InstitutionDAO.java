package com.co.redtutores.rest_api.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.*;
import org.springframework.stereotype.Repository;

import com.co.redtutores.rest_api.commons.entities.Institution;

@Repository
public class InstitutionDAO implements IInstitutionDAO{
	
	private final static Logger log = LoggerFactory.getLogger(InstitutionDAO.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void createInstitution(Institution inst) throws Exception {
		// TODO Auto-generated method stub
		try {
		log.info("[Persistence] institution Name: " +inst.getInstitutionName());
		log.info("[Persistence] institution Id: "+ inst.getInstitutionId());
		entityManager.persist(inst);
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new Exception("An error ocurred at the persistence layer: " + e.getMessage());
		}
	}

	@Override
	public Institution findById(int id) throws Exception {
		// TODO Auto-generated method stub
		Institution inst = null;
		inst = entityManager.find(Institution.class, id);
		return inst;
	}

	@Override
	public Institution findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		String b = "SELECT a FROM Institution a WHERE a.institutionName = :instName";
		Query q = entityManager.createQuery(b);
		q.setParameter("instName", name);
		
		return (Institution) q.getSingleResult();
	}

}
