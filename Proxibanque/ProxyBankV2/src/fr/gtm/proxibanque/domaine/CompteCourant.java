package fr.gtm.proxibanque.domaine;


	/**
	 * Classe métier CompteCourant héritant de la classe Compte, donc de ses propriétés : numCompte, solde, dateOuverture, idclient.
	 * Cette classe possède une propriété en plus, decouvert.
	 * <br/>
	 * Les instances de cette classe représentent les informations sur les comptes d'un client donné, requises pour leur gestion
	 * par le conseiller Proxibanque.
	 * 
	 */
public class CompteCourant extends Compte {

	//propriétés de compte courant
	
	private float decouvert;


	// constructeur de compte courant
	
	/**
	 * Constructeur CompteCourant avec les paramètres : numCompte, solde, dateOuverture, idclient et decouvert
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