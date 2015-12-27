<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "fr.gtm.proxibanque.domaine.Conseiller"%>
<%@ page import ="fr.gtm.proxibanque.domaine.Client" %>
<%@ page import="java.util.List" %>
<!--  %@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<%-- Bootstrap core CSS --%>
<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

<%-- IE10 viewport hack for Surface/desktop Windows 8 bug --%>
<link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<%-- Custom styles for this template --%>
<link href="accueil.css" rel="stylesheet">

<%-- Just for debugging purposes. Don't actually copy these 2 lines! --%>
<%--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]--%>
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

		<title>Information client</title>
		
</head>
<body>




<div class="container">
                 
<div class="container">
  <ul class="nav nav-pills" role="tablist">
    <li class="active"><a href="accueil.jsp">Home</a></li>
	<li><a href="Virement.jsp">Virement</a></li>
	  <ul class="nav nav-pills navbar-right" >
        <li class="dropdown" >
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span> <c:out value="${nom}"/>  <c:out value="${prenom}"/> 
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="index.jsp" >Se deconnecter</a></li>

          </ul>
        </li>
       
  </ul>

   <br>
  <h2>Information client</h2>

        <form class="form-inline" action="creationCompteCourant.jsp" >
        <h3 align="right"><button class="btn btn-primary btn-sl" type="submit">Creer un compte </button></h3>
		</form>
		
		
		
	<form class="form-inline" name="formUpdate" action="servUpdateClient" onsubmit="return validerFormUpdate()" method="post">
				    <div class="form-group"> 
      Identifiant client <p> <b><c:out value="${idclient}"/></b>
    </div> <br>
	<div class="form-group"> 
      Nom <p><label class="sr-only" for="nom"></label>
      <input  class="form-control" id="nom" name="champ_nom" value=<c:out value="${nomclient}"/>>
    </div> <br>
    <div class="form-group">
      Prenom <p><label class="sr-only" for="prenom"></label>
      <input  class="form-control" id="prenom" name="champ_prenom" value=<c:out value="${prenomclient}"/>>
    </div><br>
	 <div class="form-group"> 
      Adresse <p><label class="sr-only" for="adresse"></label>
      <input  class="form-control" id="adresse" name="champ_adresse" value=<c:out value="${adresseclient}"/>>
    </div> <br>
	
	<div class="form-group"> 
      Code Postal <p><label class="sr-only" for="codePostal"></label>
      <input type="text" class="form-control" id="codePostal" name="champ_codePostal" value=<c:out value="${codepostalclient}"/> required>
    </div> <br>
	
     <div class="form-group"> 
      Ville <p><label class="sr-only" for="ville" ></label>
      <input  class="form-control" id="ville" name="champ_ville" value=<c:out value="${villeclient}"/>>
    </div> <br>
	<div class="form-group"> 
      Telephone <p><label class="sr-only" for="telephone"></label>
      <input  class="form-control" id="telephone" name="champ_telephone" value=<c:out value="${telephoneclient}"/> maxlength="10">
    </div> <br>
	<div class="form-group"> 
      E-mail <p><label class="sr-only" for="email"></label>
      <input type="email" id="inputEmail" class="form-control" name="champ_email" value=<c:out value="${emailclient}"/>>
    </div> <br>
        <center><button class="btn btn-lg btn-primary " type="submit" data-toggle="modal" data-target="#myModal">Modifier</button></center>

				
					</form> 
				</div>
		
		
		
    <div class="table-responsive">  
    <form>
   <table class="table table-hover">   
   
    <thead>
      <tr>
	    <th><center>Numero Compte</center></th>
        <th><center>Date ouverture</center></th>
        <th><center>Solde</center></th>		
      </tr>
    </thead>
    <tbody>
     
     <br> <br>
    

      <tr>
	    <td><c:out value="${numCompte0}"/></td>    
	    <td><c:out value="${dateOuverture0}"/></td>
        <td><c:out value="${solde0}"/></td>
       </tr>

   
      <tr>
	    <td><c:out value="${numCompte1}"/></td>    
	    <td><c:out value="${dateOuverture1}"/></td>
        <td><c:out value="${solde1}"/></td>
      </tr>

    
     

   
      
    </tbody>
	</table>

  
  
      </form>    
  	</div> <!-- Fin de la table  -->

</div> <!-- Fin du container -->


    <%-- IE10 viewport hack for Surface/desktop Windows 8 bug --%>
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
	<script src="infoClientScript.js"></script>

</body>
</html>