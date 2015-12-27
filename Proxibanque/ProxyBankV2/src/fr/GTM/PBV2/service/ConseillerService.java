package fr.GTM.PBV2.service;

import java.util.ArrayList;

import javax.inject.Inject;

import fr.GTM.PBV2.domaine.Client;
import fr.GTM.PBV2.domaine.Compte;
import fr.GTM.PBV2.domaine.Conseiller;
import fr.GTM.PBV2.dao.IConseillerDao;

/**
 * Classe ConseillerService, impl�mentant les m�thodes de l'interface IConseillerService. <br/>
 * 
 * Les m�thodes d�finies dans cette classe consistent � ex�cuter des m�thodes qui sont elles d�finies 
 * au niveau de la couche DAO, et associ�es � des op�rations de modification de tables de la base de donn�es 
 * (insertion, s�lection, modification, d�l�tion). <br/>
 * <br/>
 * Injection des d�pendances entre la couche DAO et la couche Service via injection de l'interface IConseillerDao, 
 * dont les m�thodes sont impl�ment�es par la classe ConseillerDao. <br/>
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
