package fr.pizzeria.admin;

import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoFichier;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;

public class ImporterPizzasOptionMenu extends OptionMenu<IPizzaDao> {

	private static final String DATA_DIR = "data";

	public ImporterPizzasOptionMenu(IPizzaDao dao) {
		super(dao);
		this.libelle = "5. (Base de données) Importer les données";
	}

	@Override
	public boolean execute() throws SQLException {

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String conf = bundle.getString("dao.impl");

		if (conf.equals("fr.pizzeria.dao.DaoJdbcFactory") || conf.equals("fr.pizzeria.dao.DaoJpaFactory")) {

			PizzaDaoFichier daoFichier = new PizzaDaoFichier(DATA_DIR);
			List<Pizza> pizzasFichier = daoFichier.findAllPizzas();
			List<Pizza> pizzasDB = dao.findAllPizzas();
			

			for (Pizza p : pizzasFichier) {
				boolean ok = true;
				for (Pizza pp : pizzasDB) {
					if (p.getCode().equals(pp.getCode())) {
						ok = false;
					}
				}
				if (ok) {
					dao.saveNewPizza(p);
				}
			}

		} else {
			System.out.println("Veuillez configurer l’application avec une implémentation base de données.\n");
		}

		return true;
	}

}
