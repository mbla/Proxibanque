package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe pour gestion des connexions/déconnexions à la base de données. <br/>
 * Deux méthodes sont définies : la méthode "seConnecter" pour ouvrir la connexion à la base de données,
 * et la méthode "seDeconnecter" pour fermer cette connexion. 
 * 
 */
public class Bdd {
	
	//pilote:type de Driver==>aller ds propriete de connection ds Service
	   /**
	 * Paramètres connection : pilote, url, login et mot de passe
	 */
	   private static String pilote = "oracle.jdbc.OracleDriver";
	   //le nom du Driver==>reprendre nom ds propriete de connection ds Service
	    private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	    //login et password du Database User
	    private static String utilisateur = "douglas";
	    private static String password = "douglas";

	    /**
	     * Se connecter à la base de données. 
	     * Chargement du pilote, puis demande de connexion à la base de données via l'url renseigné, pour un utilisateur.
	     * 
	     * @param
	     * @return cnx : la connexion à la base de données
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
	     * Se déconnecter à la base de données
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
