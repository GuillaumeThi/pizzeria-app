package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu
{
	private OptionUser optionUser;
	private ListerPizzasOptionMenu lister;
	
	public ModifierPizzaOptionMenu(IPizzaDao dao, OptionUser o)
	{
		super(dao);
		this.lister = new ListerPizzasOptionMenu(dao);
		this.libelle = "3. Mettre à jour une pizza";
		this.optionUser = o;
	}
	
	public boolean execute()
	{
		boolean ok = false;
		
		lister.execute();
		System.out.println("Veuillez choisir la pizza à modifier");
		System.out.println("(99 pour abandonner)");
		
		String oldCode = this.optionUser.choixPizza();
		
		Pizza pizza = this.optionUser.creerPizza(1);
		
		for(int i=0; i<dao.findAllPizzas().size(); i++)
		{
			if(dao.findAllPizzas().get(i).code.equals(oldCode))
			{
				dao.findAllPizzas().get(i).code = pizza.code;
				dao.findAllPizzas().get(i).nom = pizza.nom;
				dao.findAllPizzas().get(i).prix = pizza.prix;
			}
		}
		 return ok;
	}

}
