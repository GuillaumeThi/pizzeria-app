package fr.pizzeria.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements IPizzaDao {

	private EntityManagerFactory emFactory;

	public PizzaDaoJpa() {
		this.emFactory = Persistence.createEntityManagerFactory("pizzeria-unit");
	}

	@Override
	public List<Pizza> findAllPizzas() throws SQLException {

		List<Pizza> pizzas = new ArrayList<Pizza>();

		EntityManager em = this.emFactory.createEntityManager();
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
		pizzas = query.getResultList();
		em.close();

		return pizzas;
	}

	@Override
	public Pizza findPizzaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pizza findPizzaByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pizza findPizzaByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SQLException {
		
		EntityManager em = this.emFactory.createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		em.persist(pizza);
		transaction.commit();
		
		em.close();
		
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws SQLException {
		
		List<Pizza> pizzas = new ArrayList<Pizza>();
		Pizza p = new Pizza();
		
		EntityManager em = this.emFactory.createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where p.code = :codePizza", Pizza.class);
		query.setParameter("codePizza", codePizza);
		
		pizzas = query.getResultList();
		
		if(!pizzas.isEmpty()){
			p = (Pizza)pizzas.get(0);
			p.setCode(pizza.getCode());
			p.setNom(pizza.getNom());
			p.setPrix(pizza.getPrix());
		}
		
		transaction.commit();
		em.close();
		
		return true;
	}

	@Override
	public boolean deletePizza(String codePizza) throws SQLException {
				
		List<Pizza> pizzas = new ArrayList<Pizza>();
		
		EntityManager em = this.emFactory.createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where p.code = :codePizza", Pizza.class);
		query.setParameter("codePizza", codePizza);
		
		pizzas = query.getResultList();
		
		if(!pizzas.isEmpty()){
			em.remove(pizzas.get(0));
		}
		
		transaction.commit();
		em.close();
		
		return true;
	}

}
