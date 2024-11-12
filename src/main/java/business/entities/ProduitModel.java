package business.entities;

import java.util.List;

public class ProduitModel {
	
	private String motCle;
	private List<Produit> products ;
	
	public String getMotCle() { 
		return motCle; 
		} 
		public void setMotCle(String motCle) { 
		this.motCle = motCle; 
		} 

	public List<Produit> getProducts() {
		return products;
	}

	public void setProducts(List<Produit> products) {
		this.products = products;
	}

}
