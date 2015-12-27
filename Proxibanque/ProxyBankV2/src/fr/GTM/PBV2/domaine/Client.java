package fr.GTM.PBV2.domaine;



/**
 * Classe métier Client avec les propiétés suivantes : idClient, nom, prenom, adresse, codePostal, ville, telephone, 
 * email, conseiller et compteClient. <br/><br/>
 * Les instances de cette classe représentent les clients des conseillers Proxibanque et les informations qui leurs sont associées.
 * 
 */
public class Client {
	
	
	// Proprietes de Client
	private int idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;
	private String email;
	private Conseiller conseiller;
	private CompteCourant compteClient;
	
	
	// Constructeurs de Client 
	
	/**
	 * Constructeur Client avec les paramètres : idClient, nom, prenom, adresse, codePostal, ville, telephone et email
	 */
	public Client(int idClient, String nom, String prenom, String adresse, String codePostal, String ville,
			String telephone, String email) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.email = email;
	}

	/**
	 * Constructeur Client sans arguments 
	 */
	public Client() {
		super();
	}

	// Getters et Setters

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public CompteCourant getCompteClient() {
		return compteClient;
	}

	public void setCompteClient(CompteCourant compteClient) {
		this.compteClient = compteClient;
	}

	
	// To String
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", codePostal=" + codePostal + ", ville=" + ville + ", telephone=" + telephone + ", email=" + email
				+ ", conseiller=" + conseiller + ", compteClient=" + compteClient
				+ "]";
	}
	
	
	
	
	
	
	

}
