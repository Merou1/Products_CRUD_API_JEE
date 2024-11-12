package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IProduitImplemetation;

import business.entities.Produit;
import business.entities.ProduitModel;

/**
 * Servlet implementation class Controller
 */
@WebServlet (name="cs",urlPatterns= {"/Controleur","*.do"}) 
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IProduitImplemetation impl = new IProduitImplemetation();

		String path=request.getServletPath(); 
		if (path.equals("/index.do")) 
		{ 
		 
		request.getRequestDispatcher("Produits.View.jsp").forward(request,response); 
		} 
		else if (path.equals("/chercher.do")) 
		{ 
			String mc = request.getParameter("motCle");
			ProduitModel pmod = new ProduitModel();
			
			pmod.setMotCle(mc);
			List <Produit> products = impl.getProduits(mc);
			pmod.setProducts(products);
			
			request.setAttribute("model",pmod);
			request.getRequestDispatcher("Produits.View.jsp").forward(request, response); 
		} 
		else if (path.equals("/saisie.do") ) 
		{ 
		 
		request.getRequestDispatcher("saisieProduit.jsp").forward(request,response); 
		} 
		else if (path.equals("/save.do") && request.getMethod().equals("POST")) 
		{ 
		String nom=request.getParameter("nom"); 
		double prix = Double.parseDouble(request.getParameter("prix")); 
		Produit p = impl.save(new Produit(nom,prix)); 
		request.setAttribute("produit", p); 
		 
		request.getRequestDispatcher("confirmation.jsp").forward(request,response); 
		} 
		else if (path.equals("/supprimer.do")) 
		{ 
		Long id= Long.parseLong(request.getParameter("id")); 
		impl.deleteProduit(id); 
		response.sendRedirect("chercher.do?motCle=");
		}
		else if (path.equals("/editer.do") ) 
		{ 
		Long id= Long.parseLong(request.getParameter("id")); 
		Produit p = impl.getProduit(id); 
		request.setAttribute("produit", p); 
		 
		request.getRequestDispatcher("editerProduit.jsp").forward(request,response); 
		}
		else if (path.equals("/update.do") ) 
		{ 
		Long id = Long.parseLong(request.getParameter("id")); 
		String nom=request.getParameter("nom"); 
		double prix = 
		Double.parseDouble(request.getParameter("prix")); 
		Produit p = new Produit(); 
		p.setId(id); 
		p.setNom(nom); 
		p.setPrix(prix); 
		impl.updateProduit(p); 
		request.setAttribute("produit", p); 
		 
		request.getRequestDispatcher("confirmation.jsp").forward(request,response); 
		} 
		
		
		else 
		{ 
			response.sendError(Response.SC_NOT_FOUND); 
		} 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);

	}

}
