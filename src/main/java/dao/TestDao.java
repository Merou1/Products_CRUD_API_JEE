package dao;

import java.util.List; 

import business.entities.Produit; 
 
public class TestDao { 
 
public static void main(String[] args) { 
IProduitImplemetation pdao= new IProduitImplemetation(); 
Produit prod= pdao.save(new Produit("iphone 8 plus",2800)); 
System.out.println("objet prod: "+prod); 
 
List<Produit> prods =pdao.getProduits("HP"); 
for (Produit p : prods) 
System.out.println(p); 
 
} 
 
} 
