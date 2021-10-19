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
import model.Car;
public class CarHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebShoppingListwithShoppers");
	
	public void insertItem(Car c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Car> showAllCars(){
		EntityManager em = emfactory.createEntityManager();
		List<Car> allCars = em.createQuery("SELECT i from Car i").getResultList();
		return allCars;
	}
	
	public void deleteItem(Car toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select li from Car li where li.make = :selectedMake and li.model = :selectedModel", Car.class);
		
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		
		typedQuery.setMaxResults(1);
		
		Car result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Car searchForCarById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Car found = em.find(Car.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateItem(Car toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Car> searchForCarByMake(String make) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select li from Car li where li.make = :selectedMake", Car.class);
		
		typedQuery.setParameter("selectedMake", make);
		
		List<Car> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<Car> searchForCarByModel(String model) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select li from Car li where li.model = :selectedModel", Car.class);
		
		typedQuery.setParameter("selectedModel", model);
		
		List<Car> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
