package fr.GTM.PBV2.service;

import java.util.ArrayList;

import fr.GTM.PBV2.domaine.Client;
import fr.GTM.PBV2.domaine.Compte;
import fr.GTM.PBV2.domaine.Conseiller;

/**
 * Interface dont les m�thodes sont impl�ment�es par la classe ConseillerService. <br/>
 * Descriptif des m�thodes : voir classe ConseillerService.
 * 
 */

public interface IConseillerService {

	public void insertClientService(Client client , int idconseiller);

	public Conseiller loginService(String champ_login, String champ_mdp);

	public ArrayList<Client> getClientService(int idconseiller);
	
	public Client getClientByIdService(int idclient);
  
	public void updateClientService(Client client);

	public ArrayList<Compte> getCompteService(int idclient);
		
	public void insertCompteService(Compte compte);
	
	public Compte getCompteByNumService(int numCompte);
	
	public void updateCompteService(Compte compte);

	
}
