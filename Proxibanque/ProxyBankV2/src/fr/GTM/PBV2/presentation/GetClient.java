package fr.GTM.PBV2.presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.GTM.PBV2.domaine.Client;
import fr.GTM.PBV2.domaine.Compte;
import fr.GTM.PBV2.service.IConseillerService;

/**
 * Servlet implementation class GetClient. <br/><br/>
 * Recupère l'idclient mis en session et l'envoie dans le DAO. <br/>
 * Affiche et met en session les informations sur le client retournées par le DAO sur la page infoClient.jsp. <br/>
 * <br/>
 * Injection des dépendances entre la servlet et la couche Service via injection de l'interface IConseillerService.
 * 
 */
@WebServlet("/GetClient")
public class GetClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetClient() { super(); }
    
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
		
		HttpSession maSession = request.getSession();

		String champ_idclient= request.getParameter("champ_idclient");
	
		int idclient = Integer.parseInt(champ_idclient);
		
		//  Etape 2: soumettre les parametre de la requete a la couche service

		Client client = serv.getClientByIdService(idclient);
		ArrayList<Compte> listecompte = serv.getCompteService(client.getIdClient());
		
		
		maSession.removeAttribute("numCompte0");
		maSession.removeAttribute("dateOuverture0");
		maSession.removeAttribute("solde0");
		
		maSession.removeAttribute("numCompte1");
		maSession.removeAttribute("dateOuverture1");
		maSession.removeAttribute("solde1");
		
		
		// mise en session des attributs compte 
		if (listecompte.isEmpty() != true){
			for(int i=0; i<listecompte.size(); i++){
			
				
				maSession.setAttribute("numCompte"+""+i, listecompte.get(i).getNumCompte());
				maSession.setAttribute("dateOuverture"+""+i, listecompte.get(i).getDateOuverture());
				maSession.setAttribute("solde"+""+i, listecompte.get(i).getSolde());
			}
		}
		
		
		// mise en session des attributs du client
		maSession.setAttribute("idclient", client.getIdClient());
		maSession.setAttribute("nomclient", client.getNom());
		maSession.setAttribute("prenomclient", client.getPrenom());
		maSession.setAttribute("adresseclient", client.getAdresse());
		maSession.setAttribute("codepostalclient", client.getCodePostal());
		maSession.setAttribute("villeclient", client.getVille());
		maSession.setAttribute("telephoneclient", client.getTelephone());
		maSession.setAttribute("emailclient", client.getEmail());
		
		
		
		// Renvoyer sur la vue accueil
		RequestDispatcher dispatcher = request.getRequestDispatcher("infoClient.jsp");
		dispatcher.forward(request, response);
		
				
	}

}
