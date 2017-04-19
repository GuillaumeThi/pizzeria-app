package fr.pizzeria.ihm;

import fr.pizzeria.dao.*;

public class ListerPizzasOptionMenu extends OptionMenu
{

	public ListerPizzasOptionMenu(IPizzaDao dao)
	{
		super(dao);
		this.libelle = "1. Lister les pizzas";
	}
	
	public boolean execute()
	{
		boolean ok = false;
		for(int i=0; i<dao.findAllPizzas().size(); i++)
		{
			if(dao.findAllPizzas().get(i) == null)
			{
				break;
			}
			System.out.println(dao.findAllPizzas().get(i).toString());
		}
		System.out.println();
		
		return ok;
	}

}
