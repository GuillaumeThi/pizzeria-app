package fr.pizzeria.admin;

import java.sql.SQLException;
import java.util.ArrayList;

import com.github.lalyos.jfiglet.FigletFont;

import fr.pizzeria.dao.*;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.OptionUser;

public class AdminMenu extends Menu<IPizzaDao> {

	public static final int LISTE = 0;
	public static final int AJOUT = 1;
	public static final int MODIF = 2;
	public static final int SUPPR = 3;
	public static final int IMPORT = 4;

	public AdminMenu(IPizzaDao dao, OptionUser optionUser) {
		super(dao, optionUser);

		this.optionUser = optionUser;

		this.options = new ArrayList<OptionMenu<IPizzaDao>>();

		this.addOptionMenu(new ListerPizzasOptionMenu(dao));
		this.addOptionMenu(new NouvellePizzaOptionMenu(dao, optionUser));
		this.addOptionMenu(new ModifierPizzaOptionMenu(dao, optionUser));
		this.addOptionMenu(new SupprimerPizzaOptionMenu(dao, optionUser));
		this.addOptionMenu(new ImporterPizzasOptionMenu(dao));
	}

	public void execute() throws SQLException {
		int choix = 0;

		String asciiArt = "";
		asciiArt = FigletFont.convertOneLine("Pizzeria App");
		System.out.println(asciiArt);

		do {
			afficher();

			choix = optionUser.choixMenu();
			switch (choix) {
			case 1:
				options.get(LISTE).execute();
				break;

			case 2:
				options.get(AJOUT).execute();
				break;

			case 3:
				options.get(MODIF).execute();
				break;

			case 4:
				options.get(SUPPR).execute();
				break;

			case 5:
				options.get(IMPORT).execute();
				break;

			case 99:
				System.out.println("\n*** Aurevoir :( ***\n");
				break;

			default:
				System.out.println("\nVeuillez choisir une valeur valide !\n");
			}
		} while (choix != 99);
	}

}
