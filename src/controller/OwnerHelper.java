package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Owner;


/**
 * @author krebs jjkrebs1
 * CIS 175 - Fall 2021
 * Oct 17, 2021
 */
public class OwnerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebShoppingListwithShoppers");
	
	public void insertOwner(Owner o) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Owner> showAllOwners(){
		EntityManager em = emfactory.createEntityManager();
		List<Owner> allOwners = em.createQuery("SELECT o from Owner o").getResultList();
		return allOwners;
	}
	
	public Owner findOwner(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select sh from Owner sh where sh.ownerName = :selectedName",Owner.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		Owner foundOwner;
		try {
			foundOwner = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundOwner = new Owner(nameToLookUp);
		}
		em.close();

		return foundOwner;
	}
	
	
}











