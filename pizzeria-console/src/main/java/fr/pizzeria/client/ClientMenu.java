package fr.pizzeria.client;

import java.sql.SQLException;
import java.util.ArrayList;

import com.github.lalyos.jfiglet.FigletFont;

import fr.pizzeria.dao.*;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.OptionUser;

public class ClientMenu extends Menu<IClientDao> {

	public static final int INSCRIPTION = 0;
	public static final int CONNEXION = 1;

	public ClientMenu(IClientDao dao, OptionUser optionUser) {
		super(dao, optionUser);

		this.optionUser = optionUser;

		this.options = new ArrayList<OptionMenu<IClientDao>>();

		addOptionMenu(new InscriptionOptionMenu(dao));
		addOptionMenu(new ConnexionOptionMenu(dao));
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
				options.get(INSCRIPTION).execute();
				break;

			case 2:
				options.get(CONNEXION).execute();
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
