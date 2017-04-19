package fr.pizzeria.ihm;

import fr.pizzeria.dao.*;

public class Menu
{
	
	public static final int LISTE = 0;
	public static final int AJOUT = 1;
	public static final int MODIF = 2;
	public static final int SUPPR = 3;
	
	private OptionMenu[] optionMenus;
	private OptionUser optionUser;
	
	
	public Menu(IPizzaDao dao, OptionUser o)
	{
		optionMenus = new OptionMenu[5];
		optionMenus[0] = new ListerPizzasOptionMenu(dao);
		optionMenus[1] = new NouvellePizzaOptionMenu(dao, o);
		optionMenus[2] = new ModifierPizzaOptionMenu(dao, o);
		optionMenus[3] = new SupprimerPizzaOptionMenu(dao, o);
		
		this.optionUser = o;
	}
	
	
	void afficher()
	{
		System.out.println("***** Pizzeria Administration *****\n");
		for(int i=0; i<this.optionMenus.length; i++)
		{
			if(this.optionMenus[i] != null)
			{
				System.out.println(this.optionMenus[i].getLibelle());
			}
		}
		System.out.println();
	}
	
	void execute()
	{
		int choix;
		
		do
		{
			this.afficher();
			
			choix = optionUser.choixMenu();
			switch (choix)
			{
				case 1:
					optionMenus[LISTE].execute();
					break;
				
				case 2:
					optionMenus[AJOUT].execute();
					break;
				
				case 3:
					optionMenus[MODIF].execute();
					break;
				
				case 4:
					optionMenus[SUPPR].execute();
					break;
				
				case 99:
					System.out.println("\n*** Aurevoir :( ***\n");
					break;
				
				default:
					System.out.println("\nVeuillez choisir une valeur valide !\n");
			}
		}
		while (choix != 99);
	}

}
