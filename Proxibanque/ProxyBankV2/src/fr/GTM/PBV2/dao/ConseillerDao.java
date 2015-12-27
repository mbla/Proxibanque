package fr.GTM.PBV2.dao;

import static util.Bdd.seConnecter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.GTM.PBV2.domaine.Client;
import fr.GTM.PBV2.domaine.Compte;
import fr.GTM.PBV2.domaine.CompteCourant;
import fr.GTM.PBV2.domaine.Conseiller;
import util.Bdd;

/**
 * Classe ConseillerDao impl�mentant les m�thodes de l'inferface IConseillerDao.<br/>
 * Les m�thodes de cette classe permettent les actions sur la base de donn�es (insertion, modification, suppression de la base, ainsi que lecture des informations de la base).<br/>
 * <br/>
 * Elles sont du m�me format : une connexion � la base de donn�es est demand�e (ex�cution de la m�thode "seConnecter" de la classe util.Bdd),
 * un statement est cr�� pour envoyer la requ�te SQL vers la base de donn�es, l'action est r�alis�e.
 * Si la m�thode retourne de l'information, cette information est ajout�e � un resultset dont les donn�es sont lues et associ�es � l'instance retourn�e.
 * La connexion � la base de donn�es est ensuite ferm�e (m�thode util.Bdd.seDeconnecter()). 
 *<br/><br/>
 * Cette classe pr�sente les actions qui peuvent �tre r�alis�es par le conseiller en client�le Proxibanque dans l'exercice de ses fonctions.
 */

public class ConseillerDao implements IConseillerDao{
	
	 /**
	 * Permet d'inserer un client dans la base de donn�es. 
	 * @param client
	 * @param idconseiller : un client �tant g�r� par un conseiller, ils sont tout deux reli�s en base.
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
	 * Permet de v�rifier que le login et le mot de passe entr�s dans le formulaire correspondent � un utilisateur dans la base de donn�es.
	 * La m�thode recherche dans la table correspondante de la base de donn�es et renvoie le conseiller correspondant au login et mot de passe renseign�s.
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
	 * Permet de r�cup�rer la liste des clients (pas plus de 10 clients par conseiller) du conseiller de la session
	 * @param idconseiller
	 * @return listeClient : liste des clients du conseiller avec tous les param�tres clients
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
	 * Permet d'afficher un client � partir de son idclient
	 * @param idclient
	 * @return client : un client avec tous ses param�tres
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
	 * Permet de modifier le nom, le prenom, l'adresse, le codePostal, la ville, le t�l�phone et l'email 
	 * d'un client � partir de son id client 
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
		 * Permet de r�cup�rer la liste des comptes (pas plus de 2 comptes par client) d'un client 
		 * @param idclient
		 * @return listeCompte : liste de comptes avec tous les param�tres numCompte, solde et dateouverture pour le client s�lectionn�
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
	 * Permet d'inserer un compte dans la base de donn�es
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
	 * Permet d'afficher les param�tres d'un compte � partir d'un numCompte
	 * @param numCompte
	 * @return cc : le compte correspondant au numcompte renseign�
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
	 *Permet de modifier le solde d'un compte � partir du numCompte
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
