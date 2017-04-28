package fr.pizzeria.admin;

import java.sql.SQLException;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.OptionUser;

public class SupprimerPizzaOptionMenu extends OptionMenu<IPizzaDao> {
	private OptionUser optionUser;
	private ListerPizzasOptionMenu lister;

	public SupprimerPizzaOptionMenu(IPizzaDao dao, OptionUser o) {
		super(dao);
		this.optionUser = o;
		this.libelle = "4. Supprimer une pizza";
		this.lister = new ListerPizzasOptionMenu(dao);
	}

	public boolean execute() throws SQLException {
		boolean ok = false;

		lister.execute();
		System.out.println("Veuillez choisir la pizza à supprimer");
		System.out.println("(99 pour abandonner)");

		String code = this.optionUser.choixPizza();
		dao.deletePizza(code);

		return ok;
	}

}
