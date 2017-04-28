package fr.pizzeria.model;


import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "num_commande")
	private String numCommande;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_commande")
	private Date dateCommande;

	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="id_livreur")
	private Livreur livreur;

	@Column(name = "statut")
	private String statut;
	
	@ManyToMany
	@JoinTable(name="commande_pizza",
		joinColumns=
			@JoinColumn(name="id_commande", referencedColumnName="id"),
		inverseJoinColumns=
			@JoinColumn(name="id_pizza", referencedColumnName="id")
	)
	private Set<Pizza> pizzas;
	
	
	public Commande() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNumCommande() {
		return numCommande;
	}


	public void setNumCommande(String numCommande) {
		this.numCommande = numCommande;
	}


	public Date getDateCommande() {
		return dateCommande;
	}


	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Livreur getLivreur() {
		return livreur;
	}


	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public Set<Pizza> getPizzas() {
		return pizzas;
	}


	public void setPizzas(Set<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	
	
	
}
