package controller;

import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * @author krebs jjkrebs1
 * CIS 175 - Fall 2021
 * Oct 17, 2021
 */
import model.garageDetails;;
public class GarageHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Cars");

	public void insertNewListDetails(garageDetails g) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<garageDetails> getLists(){
		EntityManager em = emfactory.createEntityManager();
		List<garageDetails> allDetails = em.createQuery("SELECT d FROM garageDetails d").getResultList();
		return allDetails;
	}
	
	public garageDetails searchForGarageDetailsById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		garageDetails found = em.find(garageDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void deleteList(garageDetails listToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<garageDetails> typedQuery = em.createQuery("SELECT detail from garageDetails detail where detail.id= :selectedId", garageDetails.class);
		typedQuery.setParameter("selectedId", listToDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		garageDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void updateList(garageDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
