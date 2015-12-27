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
import fr.GTM.PBV2.domaine.CompteCourant;
import fr.GTM.PBV2.service.IConseillerService;

/**
 * Servlet implementation class InsertCompte <br/><br/>
 * Permet de r�cup�rer les informations du formulaire (creationCompteCourant.jsp) du compte de les envoyer � la couche DAO,
 * mets en session les informations du client et la liste de compte renvoy�s par le DAO,
 * envoie � la page infoClient.jsp. <br/>
 * <br/>
 * Injection des d�pendances entre la servlet et la couche Service via injection de l'interface IConseillerService.
 * 
 */

@WebServlet("/InsertCompteCourant")
public class InsertCompteCourant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCompteCourant() { super(); }

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
				
				String champ_solde = request.getParameter("champ_solde");
				String champ_date = request.getParameter("champ_date");
				String champ_decouvert = request.getParameter("champ_decouvert");
				
				float solde = Float.valueOf(champ_solde);
				float decouvert = Float.valueOf(champ_decouvert);
				
				// Etape 2: Recuperation de l identidiant Client
				HttpSession maSession = request.getSession();
				int idclient =  (int) maSession.getAttribute("idclient");
								
				// Etape 3 : Instanciation d un comtpe Courant
				
				Compte compte = new CompteCourant(0, solde, champ_date, idclient, decouvert);
				

				//  Etape 4: soumettre les parametre de la requete a la couche service
				
				serv.insertCompteService(compte);
				
				// Mise a jour de la liste des comptes et des attributs
				
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
