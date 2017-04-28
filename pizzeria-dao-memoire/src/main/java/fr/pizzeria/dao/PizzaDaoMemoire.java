package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;
import java.util.*;

public class PizzaDaoMemoire implements IPizzaDao
{
	
	public static int id = 0;
	private List<Pizza> pizzas;
	
	public PizzaDaoMemoire()
	{
		pizzas = new ArrayList<>();
		pizzas.add(new Pizza(id++, "PEP", "Pépéroni", 12.5));
		pizzas.add(new Pizza(id++, "MAR", "Margherita", 14));
		pizzas.add(new Pizza(id++, "REI", "La Reine", 11.5));
		pizzas.add(new Pizza(id++, "FRO", "La 4 fromages", 12));
		pizzas.add(new Pizza(id++, "CAN", "La cannibale", 12.5));
		pizzas.add(new Pizza(id++, "SAV", "La savoyarde", 13));
		pizzas.add(new Pizza(id++, "ORI", "L’orientale", 13.5));
		pizzas.add(new Pizza(id++, "IND", "L’indienne", 14));
	}

	
	public List<Pizza> findAllPizzas()
	{
		return this.pizzas;
	}
	
	public Pizza findPizzaById(int id)
	{
		Pizza pizza = new Pizza(0, null, null, 0);
		boolean ok = false;
		for(int i=0; i<this.pizzas.size(); i++)
		{
			if(this.pizzas.get(i).getId() == id)
			{
				pizza = this.pizzas.get(i);
				ok = true;
			}
		}
		
		if(ok)
		{
			return pizza;
		}
		else
		{
			return null;
		}
	}
	
	public Pizza findPizzaByCode(String code)
	{
		Pizza pizza = new Pizza(0, null, null, 0);
		boolean ok = false;
		for(int i=0; i<this.pizzas.size(); i++)
		{
			if(this.pizzas.get(i).getCode().toUpperCase().equals(code))
			{
				pizza = this.pizzas.get(i);
				ok = true;
			}
		}
		
		if(ok)
		{
			return pizza;
		}
		else
		{
			return null;
		}
	}
	
	public Pizza findPizzaByName(String nom)
	{
		Pizza pizza = new Pizza(0, null, null, 0);
		boolean ok = false;
		for(int i=0; i<this.pizzas.size(); i++)
		{
			if(this.pizzas.get(i).getNom().equals(nom))
			{
				pizza = this.pizzas.get(i);
				ok = true;
			}
		}
		
		if(ok)
		{
			return pizza;
		}
		else
		{
			return null;
		}
	}
	
	public boolean saveNewPizza(Pizza pizza)
	{
		pizza.setId(id++);
		pizzas.add(pizza);
		
		return true;
	}
	
	public boolean updatePizza(String codePizza, Pizza pizza)
	{
		for(int i=0; i<pizzas.size(); i++)
		{
			if(pizzas.get(i).getCode().equals(codePizza))
			{
				pizzas.get(i).setCode(pizza.getCode());
				pizzas.get(i).setNom(pizza.getNom());
				pizzas.get(i).setPrix(pizza.getPrix());
			}
		}
		
		return true;
	}
	
	public boolean deletePizza(String codePizza)
	{
		for(int i=0; i<pizzas.size(); i++)
		{
			if(pizzas.get(i).getCode().toUpperCase().equals(codePizza))
			{
				pizzas.remove(i);
				break;
			}
		}
		
		return true;
	}
}
