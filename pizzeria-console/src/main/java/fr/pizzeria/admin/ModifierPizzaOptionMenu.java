package fr.pizzeria.admin;

import java.sql.SQLException;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.OptionUser;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu<IPizzaDao> {
	private OptionUser optionUser;
	private ListerPizzasOptionMenu lister;

	public ModifierPizzaOptionMenu(IPizzaDao dao, OptionUser o) {
		super(dao);
		this.lister = new ListerPizzasOptionMenu(dao);
		this.libelle = "3. Mettre à jour une pizza";
		this.optionUser = o;
	}

	public boolean execute() throws SQLException {
		boolean ok = false;

		lister.execute();
		System.out.println("Veuillez choisir la pizza à modifier");
		System.out.println("(99 pour abandonner)");

		String oldCode = this.optionUser.choixPizza();

		Pizza pizza = this.optionUser.creerPizza();
		dao.updatePizza(oldCode, pizza);

		return ok;
	}

}
