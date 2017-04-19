package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class OptionUser
{
	
	private Scanner questionUser;
	
	public OptionUser(Scanner q)
	{
		this.questionUser = q;
	}
	
	public String choixPizza()
	{
		String choix;
		choix = this.questionUser.next();
		while (choix.length() != 3)
		{
			System.out.println("\nLe code doit comporter 3 lettres !\n");
			System.out.println("\nVeuillez saisir le code\n");
			choix = this.questionUser.next();
		}
		return choix.toUpperCase();
	}
	
	public int choixMenu()
	{
		int choix;
		choix = this.questionUser.nextInt();
		while (!(choix == 1 || choix == 2 || choix == 3 || choix == 4 || choix == 99))
		{
			System.out.println("\nCette option n'existe pas !\n");
			System.out.println("\nVeuillez saisir le code\n");
			choix = this.questionUser.nextInt();
		}
		return choix;
	}
	
	
	public Pizza creerPizza(int id)
	{
		System.out.println("\nVeuillez saisir le code\n");
		String code = this.questionUser.next();
		while (code.length() != 3)
		{
			System.out.println("\nLe code doit comporter 3 lettres !\n");
			System.out.println("\nVeuillez saisir le code\n");
			code = this.questionUser.next();
		}
		code = code.toUpperCase();
				
		System.out.println("\nVeuillez saisir le nom (sans espace)\n");
		String nom = this.questionUser.next();
				
		System.out.println("\nVeuillez saisir le prix\n");
		double prix = this.questionUser.nextDouble();
				
		Pizza pizza = new Pizza(id, code, nom, prix);
				
		return pizza;
	}
	
//	public void confirmer(String c)
//	{
//		System.out.println("Supprimer " + c + ". �tes-vous s�r ? (o/n)");
//		String ouiNon = this.questionUser.next();
//		if(ouiNon.equals("n"))
//		{
//			break;
//		}
//	}
	
	public Scanner getQuestionUser()
	{
		return this.questionUser;
	}
}
