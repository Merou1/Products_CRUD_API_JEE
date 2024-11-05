package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.entities.Produit;

public class IProduitImplemetation implements IProduit{
	
	ArrayList<Produit> Products = new ArrayList<Produit>();
	Connection conn = SingletonConnection.getConnection();


	@Override
	public List<Produit> getProduits(String mc) {
		try {
			PreparedStatement ps= conn.prepareStatement("select * from PRODUITS where NOM_PRODUIT LIKE ?"); 
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Produit p = new Produit();
				p.setId(rs.getInt("ID_PRODUIT"));
				p.setNom(rs.getString("NOM_PRODUIT"));
				p.setPrix(rs.getDouble("PRIX"));
				Products.add(p);
			}
			
			
		}
		catch(SQLException e) {
			 e.printStackTrace();;
		}
		return Products;

		
	}
	

}
