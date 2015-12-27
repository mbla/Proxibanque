package fr.GTM.PBV2.dao;

import java.util.ArrayList;

import fr.GTM.PBV2.domaine.Client;
import fr.GTM.PBV2.domaine.Compte;
import fr.GTM.PBV2.domaine.Conseiller;

/**
 * Interface dont les méthodes sont implémentées parla classe ConseillerDao. <br/>
 * Ces méthodes permettent la communication avec la base de données (insertion, sélection, modification, délétion d'objets en base).
 * Elles seront détaillées dans la classe ConseillerDao.
 * 
 */

public interface IConseillerDao {
	
	
	public void insertClient(Client client , int idconseiller);

	public Conseiller login(String champ_login, String champ_mdp);

	public ArrayList<Client> getClient(int idconseiller);
	
	public Client getClientById(int idclient);
  
	public void updateClient(Client client);

	public ArrayList<Compte> getCompte(int idclient);
		
	public void insertCompte(Compte compte);
	
	public Compte getCompteByNum(int numCompte);
	
	public void updateCompte(Compte compte);

}
