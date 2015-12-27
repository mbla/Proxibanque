package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe pour gestion des connexions/d�connexions � la base de donn�es. <br/>
 * Deux m�thodes sont d�finies : la m�thode "seConnecter" pour ouvrir la connexion � la base de donn�es,
 * et la m�thode "seDeconnecter" pour fermer cette connexion. 
 * 
 */
public class Bdd {
	
	//pilote:type de Driver==>aller ds propriete de connection ds Service
	   /**
	 * Param�tres connection : pilote, url, login et mot de passe
	 */
	   private static String pilote = "oracle.jdbc.OracleDriver";
	   //le nom du Driver==>reprendre nom ds propriete de connection ds Service
	    private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	    //login et password du Database User
	    private static String utilisateur = "douglas";
	    private static String password = "douglas";

	    /**
	     * Se connecter � la base de donn�es. 
	     * Chargement du pilote, puis demande de connexion � la base de donn�es via l'url renseign�, pour un utilisateur.
	     * 
	     * @param
	     * @return cnx : la connexion � la base de donn�es
	     * 
	     */
	    public static Connection seConnecter() {
	        Connection cnx = null;
	        try {
	            Class.forName(pilote);
	            cnx = DriverManager.getConnection(url, utilisateur, password);

	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return cnx;
	    }

	    /**
	     * Se d�connecter � la base de donn�es
	     * @param cnx
	     * 
	     */
	    public static void seDeconnecter(Connection cnx) {

	        try {
	            cnx.close();
	        } catch (SQLException ex) {
	            Logger.getLogger(Bdd.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

}
