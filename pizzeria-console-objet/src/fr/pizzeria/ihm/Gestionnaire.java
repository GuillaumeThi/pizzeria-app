package fr.pizzeria.ihm;

import fr.pizzeria.model.Pizza;
import java.util.Scanner;
import fr.pizzeria.dao.*;
import java.util.*;

public class Gestionnaire
{
	
	
	public static void initialiserPizza(List<Pizza> pizzas)
	{
		pizzas.add(new Pizza(PizzaDaoMemoire.id++, "PEP", "Pépéroni" , 12.5));
		pizzas.add(new Pizza(PizzaDaoMemoire.id++, "MAR", "Margherita", 14));
		pizzas.add(new Pizza(PizzaDaoMemoire.id++, "REI", "La Reine", 11.5));
		pizzas.add(new Pizza(PizzaDaoMemoire.id++, "FRO", "La 4 fromages", 12));
		pizzas.add(new Pizza(PizzaDaoMemoire.id++, "CAN", "La cannibale", 12.5));
		pizzas.add(new Pizza(PizzaDaoMemoire.id++, "SAV", "La savoyarde", 13));
		pizzas.add(new Pizza(PizzaDaoMemoire.id++, "ORI", "L'orientale", 13.5));
		pizzas.add(new Pizza(PizzaDaoMemoire.id++, "IND", "L'indienne", 14));
	}
	
	public static void main(String[] args)
	{
		
		List<Pizza> pizzas = new ArrayList<Pizza>();
		initialiserPizza(pizzas);
		
		Scanner s = new Scanner(System.in);
		OptionUser o = new OptionUser(s);
		

		// choix de la strategie de dao
		
		//DaoFactory daoFactory = new DaoMemoireFactory(pizzas);
		DaoFactory daoFactory = new DaoFichierFactory();

		Menu menu = new Menu(daoFactory.getPizzaDao(), o);
		
		
		
		menu.execute();
			
	}
}
