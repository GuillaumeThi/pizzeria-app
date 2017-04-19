package fr.pizzeria.ihm;

import fr.pizzeria.dao.*;

public abstract class OptionMenu
{
	
	protected String libelle;
	protected IPizzaDao dao;
	
	
	public OptionMenu(IPizzaDao dao)
	{
		this.dao = dao;
	}

	
	public abstract boolean execute();
	
	public String getLibelle()
	{
		return this.libelle;
	}

}
