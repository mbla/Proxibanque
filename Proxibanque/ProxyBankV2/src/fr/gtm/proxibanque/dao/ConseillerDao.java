package fr.gtm.proxibanque.dao;

import static util.Bdd.seConnecter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.Compte;
import fr.gtm.proxibanque.domaine.CompteCourant;
import fr.gtm.proxibanque.domaine.Conseiller;
import util.Bdd;

/**
 * Classe ConseillerDao implémentant les méthodes de l'inferface IConseillerDao.<br/>
 * Les méthodes de cette classe permettent les actions sur la base de données (insertion, modification, suppression de la base, ainsi que lecture des informations de la base).<br/>
 * <br/>
 * Elles sont du même format : une connexion à la base de données est demandée (exécution de la méthode "seConnecter" de la classe util.Bdd),
 * un statement est créé pour envoyer la requête SQL vers la base de données, l'action est réalisée.
 * Si la méthode retourne de l'information, cette information est ajoutée à un resultset dont les données sont lues et associées à l'instance retournée.
 * La connexion à la base de données est ensuite fermée (méthode util.Bdd.seDeconnecter()). 
 *<br/><br/>
 * Cette classe présente les actions qui peuvent être réalisées par le conseiller en clientèle Proxibanque dans l'exercice de ses fonctions.
 */

public class ConseillerDao implements IConseillerDao{
	
	 /**
	 * Permet d'inserer un client dans la base de données. 
	 * @param client
	 * @param idconseiller : un client étant géré par un conseiller, ils sont tout deux reliés en base.
	 * 
	 * 
	 */
	public void insertClient(Client client , int idconseiller){

		        try{
		            //Connection
		            Connection con = seConnecter();
		            //Creation du statement
		             Statement stmt = con.createStatement();
		       
		            String sql = "insert into client values (seq_idclient.nextval , '"+client.getNom()+"','"+client.getPrenom()+
		                "','"+client.getAdresse()+"','"+client.getCodePostal()+"','"+client.getVille()+"','"+client.getTelephone()+"','"+client.getEmail()+"',"+idconseiller+")";

		            stmt.executeUpdate(sql);
		            
		            Bdd.seDeconnecter(con);
		        }catch (SQLException ex) {
		            Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
		        }
		    }
	
	 
	 /**
	 * Permet de vérifier que le login et le mot de passe entrés dans le formulaire correspondent à un utilisateur dans la base de données.
	 * La méthode recherche dans la table correspondante de la base de données et renvoie le conseiller correspondant au login et mot de passe renseignés.
	 * @param champ_login
	 * @param champ_mdp
	 * @return conseiller 
	 * 
	 */
	public Conseiller login(String champ_login, String champ_mdp){
		    	
		    	Conseiller conseiller = new Conseiller();
		    	try{
		            //Connection
		            Connection con = seConnecter();
		            //Creation du statement
		             Statement stmt = con.createStatement();
		       
		            String sql = "select * from conseiller where login ='"+champ_login+"'" ;
		        
		            ResultSet rs = stmt.executeQuery (sql);
		            
		            int idconseiller = 0;
		            String nom = null;
		            String prenom =null;
		            String login = null;
		            String mdp = null ;
		            
		            while(rs.next()){
		                idconseiller = rs.getInt("idconseiller");
		                nom = rs.getString("nom");
		                prenom = rs.getString("prenom");		                
		                login = rs.getString("login");
		                mdp = rs.getString("mdp");
		            }
		            
		            conseiller.setIdConseiller(idconseiller);
		            conseiller.setNom(nom);
		            conseiller.setPrenom(prenom);
		            conseiller.setLogin(login);
		            conseiller.setMdp(mdp);
		            
		            Bdd.seDeconnecter(con);
		        }catch (SQLException ex) {
		            Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
		        }
				
				return conseiller;
		    }

	 
	 /**
	 * Permet de récupérer la liste des clients (pas plus de 10 clients par conseiller) du conseiller de la session
	 * @param idconseiller
	 * @return listeClient : liste des clients du conseiller avec tous les paramètres clients
	 */
	public ArrayList<Client> getClient(int idconseiller){
		 
		 ArrayList<Client> listeClient = new ArrayList<Client>();
		 
	    	try{
	            //Connection
	            Connection con = seConnecter();
	            //Creation du statement
	             Statement stmt = con.createStatement();
	       
	            String sql = "select idclient, nom, prenom, adresse, codepostal, ville, telephone, email from client where idconseiller ='"+idconseiller+"'" ;
	        
	            // Envoi du statement
	            ResultSet rs = stmt.executeQuery (sql);
	            
	            
	            while(rs.next()){
	            	
	               Client client = new Client();
	               client.setIdClient(rs.getInt("idclient"));
	               client.setNom(rs.getString("nom"));	                
	               client.setPrenom(rs.getString("prenom"));
	               client.setAdresse(rs.getString("adresse"));
	               client.setCodePostal(rs.getString("codepostal"));
	               client.setVille(rs.getString("ville"));
	               client.setTelephone(rs.getString("telephone"));
	               client.setEmail(rs.getString("email"));
	              
	              
	               listeClient.add(client);
	            }
	            
	            Bdd.seDeconnecter(con);
	            
	        }catch (SQLException ex) {
	            Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
	        }
			 return (ArrayList<Client>) listeClient;
			
			
	     
	 }

	
	 /**
	 * Permet d'afficher un client à partir de son idclient
	 * @param idclient
	 * @return client : un client avec tous ses paramètres
	 *
	 */
	public Client getClientById(int idclient){

		 Client client = new Client();
		 
	    	try{
	            //Connection
	            Connection con = seConnecter();
	            //Creation du statement
	             Statement stmt = con.createStatement();
	       
	            String sql = "select idclient, nom, prenom, adresse, codepostal, ville, telephone, email from client where idclient ='"+idclient+"'" ;
	        
	            // Envoi du statement
	            ResultSet rs = stmt.executeQuery (sql);
	            
	            
	            while(rs.next()){
	            	
	               client.setIdClient(rs.getInt("idclient"));
	               client.setNom(rs.getString("nom"));	                
	               client.setPrenom(rs.getString("prenom"));
	               client.setAdresse(rs.getString("adresse"));
	               client.setCodePostal(rs.getString("codepostal"));
	               client.setVille(rs.getString("ville"));
	               client.setTelephone(rs.getString("telephone"));
	               client.setEmail(rs.getString("email"));
	              
	              
	            }

	            Bdd.seDeconnecter(con);
	            
	        }catch (SQLException ex) {
	            Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
	        }
			 return client;
		 
	 }
	 
	 
	 /**
	 * Permet de modifier le nom, le prenom, l'adresse, le codePostal, la ville, le téléphone et l'email 
	 * d'un client à partir de son id client 
	 * @param client
	 */
	public void updateClient(Client client) {
		 try{
	            //Connection
	            Connection con = seConnecter();
	            //Creation du statement
	             Statement stmt = con.createStatement();
	       
	            String sql = "update client set nom = '"+client.getNom()+"', prenom = '"+client.getPrenom()+"', adresse ='"+client.getAdresse()+
	                "', codepostal = '"+client.getCodePostal()+"', ville = '"+client.getVille()+"', telephone = '"+client.getTelephone()+"', email = '"+client.getEmail()+"'"
	                    + " where idclient = "+ ""+client.getIdClient() ;

	            stmt.executeUpdate(sql);
	          
	            Bdd.seDeconnecter(con);
	        }catch (SQLException ex) {
	            Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
	        }
		 
	}

	/**
		 * Permet de récupérer la liste des comptes (pas plus de 2 comptes par client) d'un client 
		 * @param idclient
		 * @return listeCompte : liste de comptes avec tous les paramètres numCompte, solde et dateouverture pour le client sélectionné
		 */
	 public ArrayList<Compte> getCompte(int idclient){
		 
		 ArrayList<Compte> listeCompte = new ArrayList<Compte>();
		 
	    	try{
	            //Connection
	            Connection con = seConnecter();
	            //Creation du statement
	             Statement stmt = con.createStatement();
	       
	            String sql = "select numcompte, solde, dateouverture, taux, decouvert from compte where idclient ='"+idclient+"'" ;
	        
	            // Envoi du statement
	            ResultSet rs = stmt.executeQuery (sql);
	            	                      
	            
	            while(rs.next()){
	            	
	               Compte  cc = new CompteCourant();
	               cc.setNumCompte(rs.getInt("numcompte"));
	               cc.setSolde(rs.getFloat("solde"));
	               cc.setDateOuverture(rs.getString("dateouverture"));
	              
	              
	             
	               listeCompte.add(cc);
	            }
	            	                   
	            
	            Bdd.seDeconnecter(con);
	            
	        }catch (SQLException ex) {
	            Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
	        }
			 return (ArrayList<Compte>) listeCompte;
			
			
	     
	 }

	 /**
	 * Permet d'inserer un compte dans la base de données
	 * @param compte
	 */
	 public void insertCompte(Compte compte) {
				
				try{
		            //Connection
		            Connection con = seConnecter();
		            //Creation du statement
		             Statement stmt = con.createStatement();
		             
		             // Adaptation du format Float vers String pour la base de donnees
		             float solde = compte.getSolde();
		             String soldeString = String.valueOf(solde);
		             String soldeS =soldeString.replace('.', ',');
		            
		             
		            
		            String sql = "insert into compte ( numcompte, solde, dateouverture, idclient)"+
		                     		 " values (seq_idcompte.nextval, '"+soldeS+"','"+compte.getDateOuverture()+"',"+compte.getIdclient()+")";
		             
		            
		             stmt.executeUpdate(sql);
		            
		            Bdd.seDeconnecter(con);
		        }catch (SQLException ex) {
		            Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
		        }
		    }
			
	 
	 /**
	 * Permet d'afficher les paramètres d'un compte à partir d'un numCompte
	 * @param numCompte
	 * @return cc : le compte correspondant au numcompte renseigné
	 * 
	 */
	public Compte getCompteByNum(int numCompte){
				 
				 
				 Compte cc = new CompteCourant();
				 
			    	try{
			            //Connection
			            Connection con = seConnecter();
			            //Creation du statement
			             Statement stmt = con.createStatement();
			       
			            String sql = "select numcompte, solde, dateouverture, solde from compte where numcompte ='"+numCompte+"'" ;
			        
			            // Envoi du statement
			            ResultSet rs = stmt.executeQuery (sql);
			            
			            
			            while(rs.next()){
			            	
			               cc.setNumCompte(rs.getInt("numcompte"));
			               cc.setSolde(rs.getFloat("solde"));
			               cc.setDateOuverture(rs.getString("dateouverture"));

			            
			            }

			            Bdd.seDeconnecter(con);
			            
			        }catch (SQLException ex) {
			            Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
			        }
					 return cc;
				
				 
			 }
			
	/**
	 *Permet de modifier le solde d'un compte à partir du numCompte
	 *@param compte
	 *
	 */
	public void updateCompte(Compte compte) {

				 try{
			            //Connection
			            Connection con = seConnecter();
			            //Creation du statement
			             Statement stmt = con.createStatement();
			             
			             float solde = compte.getSolde();
			             String soldeString = String.valueOf(solde);
			             String soldeS =soldeString.replace('.', ',');
			             

			             
			            String sql = "update compte set solde = '"+soldeS+"'" + " where numcompte = "+ ""+compte.getNumCompte() ;
			            
			            
			            stmt.executeUpdate(sql);
			            
			            Bdd.seDeconnecter(con);
			        }catch (SQLException ex) {
			            Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
			        }
				 
			}

				
		
}
