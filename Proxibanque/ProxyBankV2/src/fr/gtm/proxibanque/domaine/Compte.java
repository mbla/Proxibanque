package fr.gtm.proxibanque.domaine;

/**
 * Classe abstraite Compte avec les propriétés : numCompte, solde, dateOuverture et idclient. <br/>
 * Cette classe est la généralisation de la classe CompteCourant.
 *
 */
public abstract class Compte {

	// Proprietes de Compte
	
	private int numCompte;
	private float solde;
	private String dateOuverture;
	private int idclient;
	
	
	// Constructeur de compte

	/**
	 * Constructeur Compte avec les paramètres : numCompte, solde, dateOuverture et idclient
	 */
	public Compte(int numCompte, float solde, String dateOuverture, int idclient) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.idclient = idclient;
	}

	/**
	 * Constructeur Compte sans arguments
	 */
	public Compte() {
	}
	
	// getters et setters
		
	public int getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public String getDateOuverture() {
		return dateOuverture;
	}
	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	

	
}



