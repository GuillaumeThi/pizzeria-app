package fr.pizzeria.console;

import fr.pizzeria.model.Pizza;
import java.util.Scanner;

public class PizzeriaAdminConsoleApp {
	
	public static Pizza[] pizzas = new Pizza[50];

	public void afficherMenu()
	{
		System.out.println("***** Pizzeria Administration *****\n\n1. Lister les pizzas\n2. Ajouter une nouvelle pizza\n3. Mettre à jour une pizza\n4. Supprimer une pizza\n99. Sortir");
	}
			
	public String choixPizza(Scanner q, Pizza[] pizzas)
	{
		String choix;
		choix = q.next();
		while (choix.length() != 3)
		{
			System.out.println("\nLe code doit comporter 3 lettres !\n");
			System.out.println("\nVeuillez saisir le code\n");
			choix = q.next();
		}
		return choix.toUpperCase();
	}
	
	public int choixMenu(Scanner q)
	{
		int choix;
		choix = q.nextInt();
		while (!(choix == 1 || choix == 2 || choix == 3 || choix == 4 || choix == 99))
		{
			System.out.println("\nChoisissez une option valide\n");
			this.afficherMenu();
			choix = q.nextInt();
		}
		return choix;
	}

	public void afficherPizzas(Pizza[] pizzas)
	{
		System.out.println("\n*** Liste des pizzas ***\n");
		for(int i=0; i<pizzas.length; i++)
		{
			if(pizzas[i] == null)
			{
				break;
			}
			System.out.println(pizzas[i].code + "(" + pizzas[i].id + ") -> " + pizzas[i].nom + " (" + pizzas[i].prix + "€)");
		}
		System.out.println();
	}
			
	public Pizza controle(Scanner q, int id)
	{
		System.out.println("\nVeuillez saisir le code\n");
		String code = q.next();
		while (code.length() != 3)
		{
			System.out.println("\nLe code doit comporter 3 lettres !\n");
			System.out.println("\nVeuillez saisir le code\n");
			code = q.next();
		}
		code = code.toUpperCase();
				
		System.out.println("\nVeuillez saisir le nom (sans espace)\n");
		String nom = q.next();
				
		System.out.println("\nVeuillez saisir le prix\n");
		double prix = q.nextDouble();
				
		Pizza pizza = new Pizza(id, code, nom, prix);
				
		return pizza;
	}
			
	public void ajouterPizza(Pizza[] pizzas, Pizza pizza)
	{
		for(int i=0; i<pizzas.length; i++)
		{
			if(pizzas[i] == null)
			{
				pizzas[i] = pizza;
				break;
			}
		}
	}
			
	public void modifierPizza(Pizza[] pizzas, String code, String nom, Double prix, String oldCode)
	{
		for(int i=0; i<pizzas.length; i++)
		{
			if(pizzas[i] != null && pizzas[i].code.equals(oldCode))
			{
				pizzas[i].code = code;
				pizzas[i].nom = nom;
				pizzas[i].prix = prix;
			}
		}
	}
			
	public void supprimerPizza(Pizza[] pizzas, String code)
	{
		Pizza[] newPizzas = new Pizza[49];
		int count = 0;
		for(int i=0; i<newPizzas.length; i++)
		{
			newPizzas[i] = pizzas[i];
			if(pizzas[i].code.toUpperCase().equals(code))
			{
				count = i;
				break;
			}
		}
		for(int i=count; i<newPizzas.length; i++)
		{
				newPizzas[i] = pizzas[i+1];
		}
		PizzeriaAdminConsoleApp.pizzas = newPizzas;
	}
			
	public static void main(String[] args) {
		
		int id = 0;
				
		PizzeriaAdminConsoleApp.pizzas[0] = new Pizza(0, "PEP", "Pépéroni", 12.5);
		id++;
		PizzeriaAdminConsoleApp.pizzas[1] = new Pizza(1, "MAR", "Margherita", 14);
		id++;
		PizzeriaAdminConsoleApp.pizzas[2] = new Pizza(2, "REI", "La Reine", 11.5);
		id++;
		PizzeriaAdminConsoleApp.pizzas[3] = new Pizza(3, "FRO", "La 4 fromages", 12);
		id++;
		PizzeriaAdminConsoleApp.pizzas[4] = new Pizza(4, "CAN", "La cannibale", 12.5);
		id++;
		PizzeriaAdminConsoleApp.pizzas[5] = new Pizza(5, "SAV", "La savoyarde", 13);
		id++;
		PizzeriaAdminConsoleApp.pizzas[6] = new Pizza(6, "ORI", "L’orientale", 13.5);
		id++;
		PizzeriaAdminConsoleApp.pizzas[7] = new Pizza(7, "IND", "L’indienne", 14);
		id++;
				
				int choix;
				
				Scanner questionUser = new Scanner(System.in);
				PizzeriaAdminConsoleApp gestionnaire = new PizzeriaAdminConsoleApp();
				
				do
				{
					gestionnaire.afficherMenu();
					choix = gestionnaire.choixMenu(questionUser);
					
					switch (choix)
					{
						case 1:
							gestionnaire.afficherPizzas(pizzas);
							break;
						
						case 2:
							Pizza pizza = gestionnaire.controle(questionUser, id);
							gestionnaire.ajouterPizza(pizzas, pizza);
							id++;
							break;
						
						case 3:
							gestionnaire.afficherPizzas(pizzas);
							System.out.println("Veuillez choisir la pizza à modifier");
							System.out.println("(99 pour abandonner)");
							
							String pizzaCode = gestionnaire.choixPizza(questionUser, pizzas);
							pizza = gestionnaire.controle(questionUser, id);
							gestionnaire.modifierPizza(pizzas, pizza.code, pizza.nom, pizza.prix, pizzaCode);
							id++;
							break;
						
						case 4:
							System.out.println("\n*** Suppression d'une pizza ***\n");
							gestionnaire.afficherPizzas(pizzas);
							System.out.println("Veuillez choisir la pizza à supprimer");
							System.out.println("(99 pour abandonner)");
							
							pizzaCode = gestionnaire.choixPizza(questionUser, pizzas);
							gestionnaire.supprimerPizza(pizzas, pizzaCode);
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
