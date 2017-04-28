package fr.pizzeria.client;

import java.sql.SQLException;

import fr.pizzeria.dao.IClientDao;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.OptionUser;

public class InscriptionOptionMenu extends OptionMenu<IClientDao> {
	
	private OptionUser optionUser;

	public InscriptionOptionMenu(IClientDao dao, OptionUser optionUser) {
		super(dao);
		libelle = "1. S'inscrire";
		this.optionUser = optionUser;
	}

	@Override
	public boolean execute() throws SQLException {
		// TODO Auto-generated method stub
		return true;
	}

}
