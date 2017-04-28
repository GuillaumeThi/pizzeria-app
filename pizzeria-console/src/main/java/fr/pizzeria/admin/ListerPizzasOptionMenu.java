package fr.pizzeria.admin;

import java.sql.SQLException;

import fr.pizzeria.dao.*;
import fr.pizzeria.ihm.OptionMenu;

public class ListerPizzasOptionMenu extends OptionMenu<IPizzaDao> {

	public ListerPizzasOptionMenu(IPizzaDao dao) {
		super(dao);
		this.libelle = "1. Lister les pizzas";
	}

	public boolean execute() throws SQLException {
		for (int i = 0; i < dao.findAllPizzas().size(); i++) {
			if (dao.findAllPizzas().get(i) == null) {
				continue;
			}
			System.out.println(dao.findAllPizzas().get(i).toString());
		}
		System.out.println();

		return true;
	}

}
