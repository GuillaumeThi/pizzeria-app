package fr.pizzeria.dao;

import java.util.*;

import org.junit.Test;
import org.junit.Assert;

import fr.pizzeria.model.Pizza;


public class PizzaDaoMemoireTest {
	
	@Test
	public void test_findAllPizzas()
	{
		List<Pizza> pizzas = new ArrayList<Pizza>();
		
		pizzas.add(new Pizza(PizzaDaoMemoire.id++, "PEP", "Pépéroni" , 12.5));
		pizzas.add(new Pizza(PizzaDaoMemoire.id++, "MAR", "Margherita", 14));
		pizzas.add(new Pizza(PizzaDaoMemoire.id++, "REI", "La Reine", 11.5));
		pizzas.add(new Pizza(PizzaDaoMemoire.id++, "FRO", "La 4 fromages", 12));
		pizzas.add(new Pizza(PizzaDaoMemoire.id++, "CAN", "La cannibale", 12.5));
		pizzas.add(new Pizza(PizzaDaoMemoire.id++, "SAV", "La savoyarde", 13));
		pizzas.add(new Pizza(PizzaDaoMemoire.id++, "ORI", "L'orientale", 13.5));
		pizzas.add(new Pizza(PizzaDaoMemoire.id++, "IND", "L'indienne", 14));
		
		PizzaDaoMemoire dao = new PizzaDaoMemoire(pizzas);
		
		
	}
}
