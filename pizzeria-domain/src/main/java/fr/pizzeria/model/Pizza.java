package fr.pizzeria.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "code")
	private String code;

	@Column(name = "libelle")
	private String nom;

	@Column(name = "prix")
	private double prix;
	
	@ManyToMany
	@JoinTable(name="commande_pizza",
		joinColumns=
			@JoinColumn(name="id_pizza", referencedColumnName="id"),
		inverseJoinColumns=
			@JoinColumn(name="id_commande", referencedColumnName="id")
	)
	private Set<Commande> commandes;

	public Pizza() {

	}

	public Pizza(int id, String c, String n, double p) {
		this.id = id;
		this.code = c;
		this.nom = n;
		this.prix = p;
	}

	public Pizza(String c, String n, double p) {
		this.code = c;
		this.nom = n;
		this.prix = p;
	}

	public String toString() {
		String pizzaToString = this.code + "(" + this.id + ") -> " + this.nom + " (" + this.prix + " €)";
		return pizzaToString;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
	
	

}
