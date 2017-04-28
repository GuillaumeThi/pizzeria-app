package fr.pizzeria.client;

import java.sql.SQLException;

import fr.pizzeria.dao.IClientDao;
import fr.pizzeria.ihm.OptionMenu;

public class ConnexionOptionMenu extends OptionMenu<IClientDao> {

	public ConnexionOptionMenu(IClientDao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
