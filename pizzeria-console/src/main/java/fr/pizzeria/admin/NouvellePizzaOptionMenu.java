package fr.pizzeria.admin;

import java.sql.SQLException;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.OptionUser;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends OptionMenu<IPizzaDao> {

	private OptionUser optionUser;

	public NouvellePizzaOptionMenu(IPizzaDao dao, OptionUser optionUser) {
		super(dao);
		libelle = "2. Ajouter une nouvelle pizza";
		this.optionUser = optionUser;
	}

	public boolean execute() throws SQLException {
		Pizza pizza = this.optionUser.creerPizza();

		dao.saveNewPizza(pizza);

		return true;
	}

}
