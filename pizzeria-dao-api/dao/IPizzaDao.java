package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao
{
	List<Pizza> findAllPizzas();
	Pizza findPizzaById(int id);
	Pizza findPizzaByCode(String code);
	Pizza findPizzaByName(String name);
	boolean saveNewPizza(Pizza pizza);
	boolean updatePizza(String codePizza, Pizza pizza);
	boolean deletePizza(String codePizza);
}
