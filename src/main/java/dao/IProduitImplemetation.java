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


	@Override
	public Produit save(Produit p) { 
	    Connection conn = SingletonConnection.getConnection(); 
	    try { 
	        PreparedStatement ps = conn.prepareStatement(
	            "INSERT INTO PRODUITS(NOM_PRODUIT, PRIX) VALUES(?, ?)"
	        ); 
	        ps.setString(1, p.getNom()); 
	        ps.setDouble(2, p.getPrix()); 
	        ps.executeUpdate();

	        PreparedStatement ps2 = conn.prepareStatement(
	            "SELECT MAX(ID_PRODUIT) as MAX_ID FROM PRODUITS"
	        ); 
	        ResultSet rs = ps2.executeQuery(); 
	        if (rs.next()) { 
	            p.setId(rs.getLong("MAX_ID")); 
	        }

	        ps.close(); 
	        ps2.close(); 
	    } catch (SQLException e) { 
	        e.printStackTrace(); 
	    } 
	    return p;
	}


	@Override
	public Produit getProduit(Long id) {
		Connection conn = SingletonConnection.getConnection(); 
		Produit p = new Produit(); 
		try { 
		    PreparedStatement ps = conn.prepareStatement(
		        "SELECT * FROM PRODUITS WHERE ID_PRODUIT = ?"
		    ); 
		    ps.setLong(1, id); 
		    ResultSet rs = ps.executeQuery();

		    if (rs.next()) { 
		        p.setId(rs.getLong("ID_PRODUIT")); 
		        p.setNom(rs.getString("NOM_PRODUIT")); 
		        p.setPrix(rs.getDouble("PRIX")); 
		    }
		} catch (SQLException e) { 
		    e.printStackTrace(); 
		} 
		return p;

	}


	@Override
	public Produit updateProduit(Produit p) {
		Connection conn = SingletonConnection.getConnection(); 
		try { 
		    PreparedStatement ps = conn.prepareStatement(
		        "UPDATE PRODUITS SET NOM_PRODUIT = ?, PRIX = ? WHERE ID_PRODUIT = ?"
		    ); 
		    ps.setString(1, p.getNom()); 
		    ps.setDouble(2, p.getPrix()); 
		    ps.setLong(3, p.getId()); 
		    ps.executeUpdate(); 
		    
		    ps.close(); 
		} catch (SQLException e) { 
		    e.printStackTrace(); 
		} 
		return p;

	}


	@Override
	public void deleteProduit(Long id) {
		Connection conn=SingletonConnection.getConnection(); 
		try { 
		PreparedStatement ps= conn.prepareStatement("DELETE FROM PRODUITS WHERE ID_PRODUIT = ?"); 
		ps.setLong(1, id); 
		ps.executeUpdate(); 
		ps.close(); 
		} catch (SQLException e) { 
		 
		e.printStackTrace(); 
		} 
		
	}
	

}
