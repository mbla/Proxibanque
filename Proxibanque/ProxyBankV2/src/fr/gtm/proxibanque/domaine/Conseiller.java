package fr.gtm.proxibanque.domaine;

/**
 * Classe métier Conseiller avec les propriétés : idConseiller, nom, prenom, login et mdp.
 * <br/> 
 * Les instances de cette classe représentent les informations collectées pour chaque conseiller Proxibanque dans le cadre de son travail. 
 * 
 */
public class Conseiller {
	
	// Proprietes de Conseiller	
		private int idConseiller ;
		private String nom;
		private String prenom;
		private String login ;
		private String mdp;
		
		
		/**
		 * Constructeur Conseiller avec les paramètres : idConseiller, login, mdp, nom et prenom
		 */
		// Constructeur de conseiller		
		public Conseiller(int idConseiller, String login, String mdp, String nom, String prenom) {
			super();
			this.idConseiller = idConseiller;
			this.login = login;
			this.mdp = mdp;
			this.nom = nom;
			this.prenom = prenom;
		}

		/**
		 * Constructeur Conseiller sans arguments
		 */
		public Conseiller() {
			super();
		}

		
		// Getters et Setters 
		public int getIdConseiller() {
			return idConseiller;
		}

		public void setIdConseiller(int idConseiller) {
			this.idConseiller = idConseiller;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getMdp() {
			return mdp;
		}

		public void setMdp(String mdp) {
			this.mdp = mdp;
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

		@Override
		public String toString() {
			return "Conseiller [idConseiller=" + idConseiller + ", login=" + login + ", mdp=" + mdp + "]";
		}
		

}
