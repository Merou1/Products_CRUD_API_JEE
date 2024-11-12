package business.entities;

import java.io.Serializable;

public class Produit implements Serializable {
	
	private long id;
	private String nom;
	private double prix;
	
	public Produit() {
		super();
	}
	
	
	public Produit(String nom, double prix) {
		super();
		this.nom = nom;
		this.prix = prix;
	}


	public Produit(int id, String nom, double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long l) {
		this.id = l;
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
	public String toString() { 
		return "Produit [idProduit=" + id + ", nomProduit=" + 
		nom + ", prix=" + prix + "]"; 
		} 
	

}
