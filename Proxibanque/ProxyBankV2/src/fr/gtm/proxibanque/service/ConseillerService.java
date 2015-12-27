package fr.gtm.proxibanque.service;

import java.util.ArrayList;

import javax.inject.Inject;

import fr.gtm.proxibanque.dao.IConseillerDao;
import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.Compte;
import fr.gtm.proxibanque.domaine.Conseiller;

/**
 * Classe ConseillerService, implémentant les méthodes de l'interface IConseillerService. <br/>
 * 
 * Les méthodes définies dans cette classe consistent à exécuter des méthodes qui sont elles définies 
 * au niveau de la couche DAO, et associées à des opérations de modification de tables de la base de données 
 * (insertion, sélection, modification, délétion). <br/>
 * <br/>
 * Injection des dépendances entre la couche DAO et la couche Service via injection de l'interface IConseillerDao, 
 * dont les méthodes sont implémentées par la classe ConseillerDao. <br/>
 * 
 * 
 */
public class ConseillerService implements IConseillerService{

	@Inject
	IConseillerDao dao;
	
	@Override
	public void insertClientService(Client client, int idconseiller) {
		dao.insertClient(client, idconseiller);
	}

	@Override
	public Conseiller loginService(String champ_login, String champ_mdp) {
		return dao.login(champ_login, champ_mdp);
	}

	@Override
	public ArrayList<Client> getClientService(int idconseiller) {
		return dao.getClient(idconseiller);
	}

	@Override
	public Client getClientByIdService(int idclient) {
		return dao.getClientById(idclient);
	}

	@Override
	public void updateClientService(Client client) {
		dao.updateClient(client);
		
	}

	@Override
	public ArrayList<Compte> getCompteService(int idclient) {
		return dao.getCompte(idclient);
	}

	@Override
	public void insertCompteService(Compte compte) {
		dao.insertCompte(compte);
		
	}

	@Override
	public Compte getCompteByNumService(int numCompte) {
		return dao.getCompteByNum(numCompte);
	}

	@Override
	public void updateCompteService(Compte compte) {
		dao.updateCompte(compte);
		
	}

}
