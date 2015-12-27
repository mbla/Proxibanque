package fr.gtm.proxibanque.presentation;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.proxibanque.domaine.Compte;
import fr.gtm.proxibanque.service.IConseillerService;

/**
 * Servlet implementation class Virement <br/><br/>
 * Recupère les informations du formulaire (Virement.jsp) et l'envoie dans la couche DAO.
 * Récupére les informations transmises par la couche DAO : <br/>
 * - soit renvoie un message d'erreur si le numCompte ne correspond à aucun compte ou si le solde est insuffisant, <br/>
 * - soit modifie le solde des deux comptes envoyés par le DAO si les 2 numComptes correspondent à des comptes de la base de données, 
 * renvoie les informations des nouveaux comptes au DAO,
 * et envoie sur la page accueil.jsp. <br/>
 * <br/>
 * Injection des dépendances entre la servlet et la couche Service via injection de l'interface IConseillerService.
 * 
 */
@WebServlet("/Virement")
public class VirementCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VirementCompte() { super(); }
   
    @Inject
    IConseillerService serv;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Etape 1: recuperation des parametres de la requete
		
		String champ_numCompte1 = request.getParameter("champ_numCompte1");
		int numCompte1 = Integer.parseInt(champ_numCompte1);
		
		String champ_numCompte2 = request.getParameter("champ_numCompte2");
		int numCompte2 = Integer.parseInt(champ_numCompte2);
		
		String champ_montant = request.getParameter("champ_montant");
		int montant = Integer.parseInt(champ_montant);

		
		//  Etape 2
				
		Compte compte1 = serv.getCompteByNumService(numCompte1);
		Compte compte2 = serv.getCompteByNumService(numCompte2);
		
		if (compte1.getNumCompte() !=0 && compte2.getNumCompte() != 0){ 
			

			if(compte1.getSolde()>montant){
				compte1.setSolde(compte1.getSolde() - montant);
				compte2.setSolde(compte2.getSolde() + montant);
			}

			serv.updateCompteService(compte1);
			serv.updateCompteService(compte2);
		
		

			RequestDispatcher dispatcher = request.getRequestDispatcher("accueil.jsp");
			dispatcher.forward(request, response);
		 }
		
		else {
			
			String erreur = "Numero de compte invalide \n ou Solde Insuffisant";
			request.setAttribute("erreurVirement", erreur);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Virement.jsp");
			dispatcher.forward(request, response);
			
		}
		
	 
		
		
		
	}
		

}