package dao;

import java.util.List;

import business.entities.Produit;

public interface IProduit {
	
	public List<Produit> getProduits(String mc);

}
