package dao;

import java.util.List;

import business.entities.Produit;

public interface IProduit {
	public Produit save(Produit p);
	public List<Produit> getProduits(String mc);
	public Produit getProduit(Long id); 
	public Produit updateProduit(Produit p); 
	public void deleteProduit(Long id);

}
