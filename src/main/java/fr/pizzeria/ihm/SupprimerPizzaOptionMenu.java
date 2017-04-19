package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;

public class SupprimerPizzaOptionMenu extends OptionMenu
{
	private OptionUser optionUser;
	private ListerPizzasOptionMenu lister;
	
	public SupprimerPizzaOptionMenu(IPizzaDao dao, OptionUser o)
	{
		super(dao);
		this.optionUser = o;
		this.libelle = "4. Supprimer une pizza";
		this.lister = new ListerPizzasOptionMenu(dao);
	}

	public boolean execute()
	{
		boolean ok = false;
		
		lister.execute();
		System.out.println("Veuillez choisir la pizza à supprimer");
		System.out.println("(99 pour abandonner)");
		
		String code = this.optionUser.choixPizza();
		
		for(int i=0; i<dao.findAllPizzas().size(); i++)
		{
			if(dao.findAllPizzas().get(i).code.toUpperCase().equals(code))
			{
				dao.findAllPizzas().remove(i);
				break;
			}
		}
		
		return ok;
	}

}
