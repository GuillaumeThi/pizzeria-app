package fr.pizzeria;

import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import fr.pizzeria.model.Commande;

public class TestRelation {
	
	@Test
	public void test() {
		
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		EntityManagerFactory emf = null;
		

		emf = Persistence.createEntityManagerFactory("pizzeria-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Query query = em.createQuery("select c from Commande c where c.id=5");
		Commande c = (Commande)query.getSingleResult();
		System.out.println(c.getLivreur().getNom());
		System.out.println(c.getClient().getNom());
		System.out.println(c.getPizzas().iterator().next().toString());

	}

}
