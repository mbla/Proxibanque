package fr.GTM.PBV2.domaine;


	/**
	 * Classe m�tier CompteCourant h�ritant de la classe Compte, donc de ses propri�t�s : numCompte, solde, dateOuverture, idclient.
	 * Cette classe poss�de une propri�t� en plus, decouvert.
	 * <br/>
	 * Les instances de cette classe repr�sentent les informations sur les comptes d'un client donn�, requises pour leur gestion
	 * par le conseiller Proxibanque.
	 * 
	 */
public class CompteCourant extends Compte {

	//propri�t�s de compte courant
	
	private float decouvert;


	// constructeur de compte courant
	
	/**
	 * Constructeur CompteCourant avec les param�tres : numCompte, solde, dateOuverture, idclient et decouvert
	 */
	public CompteCourant(int numCompte, float solde, String dateOuverture, int idclient, float decouvert) {
		super(numCompte, solde, dateOuverture, idclient);
		this.decouvert = decouvert;
	}

	/**
	 * Constructeur CompteCourant sans arguments
	 */
	public CompteCourant() {

	}


	// getters et setters
	public float getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(float decouvert) {
		this.decouvert = decouvert;
	}


	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + "]";
	}
	
	
	
	
	
}