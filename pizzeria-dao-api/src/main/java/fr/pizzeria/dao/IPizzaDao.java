package fr.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao 
{
	List<Pizza> findAllPizzas() throws SQLException;
	Pizza findPizzaById(int id);
	Pizza findPizzaByCode(String code);
	Pizza findPizzaByName(String name);
	boolean saveNewPizza(Pizza pizza) throws SQLException;
	boolean updatePizza(String codePizza, Pizza pizza) throws SQLException;
	boolean deletePizza(String codePizza) throws SQLException;
}
