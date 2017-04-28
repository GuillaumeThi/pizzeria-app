package fr.pizzeria.ihm;

import java.sql.SQLException;

public abstract class OptionMenu<T>
{
	
	protected String libelle;
	protected T dao;
	
	
	public OptionMenu(T dao)
	{
		this.dao = dao;
	}

	
	public abstract boolean execute() throws SQLException;
	
	public String getLibelle()
	{
		return this.libelle;
	}

}
