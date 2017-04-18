package fr.pizzeria.model;

public class Pizza {

	public int id;
	public String code;
	public String nom;
	public double prix;
	
	public Pizza(int id, String c, String n, double p)
	{
		this.id = id;
		this.code = c;
		this.nom = n;
		this.prix = p;
	}
	
	public Pizza(String c, String n, double p)
	{
		this.code = c;
		this.nom = n;
		this.prix = p;
	}
	
	public String toString()
	{
		String pizzaToString = this.code + "(" + this.id + ") -> " + this.nom + " (" + this.prix + "€)";
		return pizzaToString;
	}
	
}
