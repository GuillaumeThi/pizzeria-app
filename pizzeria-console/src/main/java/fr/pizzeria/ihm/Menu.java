package fr.pizzeria.ihm;

import java.sql.SQLException;
import java.util.List;

public abstract class Menu<T> {

	protected List<OptionMenu<T>> options;
	protected OptionUser optionUser;
	
	public abstract void execute() throws SQLException;

	public Menu(T dao, OptionUser optionUser) {

	}

	public void afficher() {

		for (OptionMenu<T> option : options) {
			System.out.println(option.getLibelle());
		}

		System.out.println("(99 pour quitter l'application)");
		System.out.println();
	}

	public void addOptionMenu(OptionMenu<T> optionMenu) {
		
		this.options.add(optionMenu);
	}

}
