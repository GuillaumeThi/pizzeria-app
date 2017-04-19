package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;
import java.util.*;

public class PizzaDaoMemoire implements IPizzaDao
{
	
	public static int id = 0;
	private List<Pizza> pizzas;
	
	public PizzaDaoMemoire(List<Pizza> pizzas)
	{
		this.pizzas = pizzas;
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
			if(this.pizzas.get(i).id == id)
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
			if(this.pizzas.get(i).code.toUpperCase().equals(code))
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
			if(this.pizzas.get(i).nom.equals(nom))
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
		pizzas.add(pizza);
		
		return true;
	}
	
	public boolean updatePizza(String codePizza, Pizza pizza)
	{
		for(int i=0; i<pizzas.size(); i++)
		{
			if(pizzas.get(i).code.equals(codePizza))
			{
				pizzas.get(i).code = pizza.code;
				pizzas.get(i).nom = pizza.nom;
				pizzas.get(i).prix = pizza.prix;
			}
		}
		
		return true;
	}
	
	public boolean deletePizza(String codePizza)
	{
		for(int i=0; i<pizzas.size(); i++)
		{
			if(pizzas.get(i).code.toUpperCase().equals(codePizza))
			{
				pizzas.remove(i);
				break;
			}
		}
		
		return true;
	}
}
