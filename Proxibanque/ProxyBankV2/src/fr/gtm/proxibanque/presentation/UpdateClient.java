package fr.gtm.proxibanque.presentation;

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

import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.Conseiller;
import fr.gtm.proxibanque.service.IConseillerService;

/**
 * Servlet implementation class UpdateClient <br/><br/>
 * Récupère les informations du formulaire (infoClient.jsp) et l'envoie dans la couche DAO. 
 * Met à jour les informations du client dans la page accueil.jsp. <br/>
 * <br/>
 * Injection des dépendances entre la servlet et la couche Service via injection de l'interface IConseillerService.
 * 
 */
@WebServlet("/UpdateClient")
public class UpdateClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClient() { super();}
    
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
				
				int idclient =  (int) maSession.getAttribute("idclient");
		
				String champ_nom = request.getParameter("champ_nom");
				String champ_prenom = request.getParameter("champ_prenom");
				String champ_adresse = request.getParameter("champ_adresse");
				String champ_codePostal = request.getParameter("champ_codePostal");
				String champ_ville = request.getParameter("champ_ville");
				String champ_telephone = request.getParameter("champ_telephone");
				String champ_email = request.getParameter("champ_email");
				
				// Etape 2: mise en attribut des parametre de la requete (sert au reaffichage des champs formulaire
				request.setAttribute("champ_nom", champ_nom);
				request.setAttribute("champ_prenom", champ_prenom);
				request.setAttribute("champ_adresse",champ_adresse);
				request.setAttribute("champ_codePostal", champ_codePostal);
				request.setAttribute("champ_ville", champ_ville);
				request.setAttribute("champ_telephone", champ_telephone);
				request.setAttribute("champ_email", champ_email);
				
				
				
				// Etape 3 : Instanciation et recuperation du conseiller de la session 
				
				Conseiller conseiller = (Conseiller) maSession.getAttribute("conseiller");
				
				//  Etape 4: soumettre les parametre de la requete a la couche service
				
				Client client = new Client(idclient, champ_nom, champ_prenom, champ_adresse, champ_codePostal, champ_ville, champ_telephone, champ_email);
				
				serv.updateClientService(client);
				
				// Mise a jour de la liste client et mise en session des attributes 
				ArrayList<Client> listeClient = serv.getClientService(conseiller.getIdConseiller());

				if (listeClient.isEmpty() != true){
					for(int i=0; i<listeClient.size(); i++){
					
						
						maSession.setAttribute("idclient"+""+i, listeClient.get(i).getIdClient());
						maSession.setAttribute("nomclient"+""+i, listeClient.get(i).getNom());
						maSession.setAttribute("prenomclient"+""+i, listeClient.get(i).getPrenom());
					}
				}
				maSession.setAttribute("sizeListeClient", listeClient.size());
				
				// Etape 5 : Redirection vers accueil
				RequestDispatcher dispatcher = request.getRequestDispatcher("accueil.jsp");
				dispatcher.forward(request, response);
				

				
				
				
				
				
		
	}

}
