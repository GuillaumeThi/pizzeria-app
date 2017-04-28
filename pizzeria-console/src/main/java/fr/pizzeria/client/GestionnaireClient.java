package fr.pizzeria.client;

import java.util.Scanner;
import java.util.logging.Level;

import fr.pizzeria.admin.AdminMenu;
import fr.pizzeria.dao.*;
import fr.pizzeria.ihm.OptionUser;

import java.sql.SQLException;
import java.util.*;

public class GestionnaireClient
{
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
	{
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String uneClasse = bundle.getString("dao.impl");
		
		
		Class<?> daoFactoryClass = Class.forName(uneClasse);
		
		DaoFactory daoFactory = (DaoFactory)daoFactoryClass.newInstance();
		
		Scanner scanner = new Scanner(System.in);
		OptionUser optionUser = new OptionUser(scanner);
		

		AdminMenu adminMenu = new AdminMenu(daoFactory.getPizzaDao(), optionUser);
		
		
		adminMenu.execute();
		
		
			
	}
}
