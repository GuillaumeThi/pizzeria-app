package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoMemoire;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends OptionMenu
{

	private OptionUser optionUser;
	
	public NouvellePizzaOptionMenu(IPizzaDao dao, OptionUser o)
	{
		super(dao);
		this.libelle = "2. Ajouter une nouvelle pizza";
		this.optionUser = o;
	}
	
	public boolean execute()
	{
		boolean ok = false;
			
		Pizza pizza = this.optionUser.creerPizza(PizzaDaoMemoire.id++);
		
		dao.saveNewPizza(pizza);
		
		return ok;
	}

}
