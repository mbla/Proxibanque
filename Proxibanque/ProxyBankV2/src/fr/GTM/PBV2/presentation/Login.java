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
import fr.GTM.PBV2.domaine.Conseiller;
import fr.GTM.PBV2.service.IConseillerService;

/**
 * Servlet implementation class Login <br/><br/>
 * Permet de récupérer les informations du formulaire (index.jsp) du conseiller (login et mdp) et les envoyer à la couche DAO. 
 * Récupère les informations transmises par la couche DAO : <br/>
 * - soit renvoie un message d'erreur si le login et le mdp ne correspondent à aucun conseiller, <br/>
 * - soit met en session le conseiller envoyé par le DAO si le login et le mdp correspondent à un conseiller de la base de données, 
 * et envoie sur la page accueil.jsp. <br/>
 * <br/> 
 * Injection des dépendances entre la servlet et la couche Service via injection de l'interface IConseillerService.
 * 
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() { super(); }
    
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
		
				String champ_login = request.getParameter("champ_login");
				String champ_mdp = request.getParameter("champ_mdp");
				
				request.setAttribute("champ_login", champ_login);
				request.setAttribute("champ_mdp", champ_mdp);
				request.setAttribute("erreur", " ");
				
				//  Etape 2: soumettre les parametre de la requete a la couche service
				
				Conseiller conseiller = serv.loginService(champ_login,champ_mdp);
								
				
				// Tester le retour de la requete
				
				if (conseiller.getLogin() == null){
					
					String erreur = "Utilisateur inconnu";
					request.setAttribute("erreur", erreur);
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
					
				}
				
				else if (conseiller.getLogin().equals(champ_login) && conseiller.getMdp().equals(champ_mdp) ) {
				
					
					HttpSession maSession = request.getSession();
					maSession.setAttribute("conseiller",conseiller); 
					
					ArrayList<Client> listeClient = serv.getClientService(conseiller.getIdConseiller());
					
					// mise en session des attributs clients 
					if (listeClient.isEmpty() != true){
						for(int i=0; i<listeClient.size(); i++){
						
							
							maSession.setAttribute("idclient"+""+i, listeClient.get(i).getIdClient());
							maSession.setAttribute("nomclient"+""+i, listeClient.get(i).getNom());
							maSession.setAttribute("prenomclient"+""+i, listeClient.get(i).getPrenom());
						}
					}
											
						
					// mise en session du conseiller

					maSession.setAttribute("nom",conseiller.getNom());
					maSession.setAttribute("prenom", conseiller.getPrenom());
					
					// mise en session de la taille de la liste
					maSession.setAttribute("sizeListeClient", listeClient.size());
					

					RequestDispatcher dispatcher = request.getRequestDispatcher("accueil.jsp");
					dispatcher.forward(request, response);
	
				}
				
				else  {
					
					String erreur = "mot de passe invalide";
					request.setAttribute("erreur", erreur);
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
					
				}
				
				
		
	}

}
