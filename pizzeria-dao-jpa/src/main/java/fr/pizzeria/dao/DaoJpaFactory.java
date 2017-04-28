package fr.pizzeria.dao;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.dao.IPizzaDao;

public class DaoJpaFactory implements DaoFactory {
	
	private IPizzaDao pizzaDao;
	
	public DaoJpaFactory()
	{
		pizzaDao = new PizzaDaoJpa();
	}

	@Override
	public IPizzaDao getPizzaDao() {
		// TODO Auto-generated method stub
		return pizzaDao;
	}

}
