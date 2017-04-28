package fr.pizzeria.dao;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.dao.IPizzaDao;

public class DaoJdbcFactory implements DaoFactory {
	
	private IPizzaDao pizzaDao;
	
	public DaoJdbcFactory()
	{
		pizzaDao = new PizzaDaoJdbc();
	}

	@Override
	public IPizzaDao getPizzaDao() {
		// TODO Auto-generated method stub
		return pizzaDao;
	}

}
