package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.model.Pizza;

public class DaoMemoireFactory implements DaoFactory{

	private IPizzaDao pizzaDao;
	
	
	public DaoMemoireFactory(List<Pizza> pizzas)
	{
		this.pizzaDao = new PizzaDaoMemoire(pizzas);
	}

	@Override
	public IPizzaDao getPizzaDao() {
		// TODO Auto-generated method stub
		return this.pizzaDao ;
	}

}
