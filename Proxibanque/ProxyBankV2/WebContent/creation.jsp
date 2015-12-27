<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "fr.GTM.PBV2.domaine.Conseiller"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Cr�ation Nouveau Client</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <!-- Bootstrap core CSS -->
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="creation.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>




<div class="container">
  <ul class="nav nav-pills" role="tablist">
    <li class="active"><a href="accueil.jsp">Home</a></li>
	<li><a href="Virement.jsp">Virement</a></li>
	  <ul class="nav nav-pills navbar-right" >
        <li class="dropdown" >
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span><c:out value="${nom}"/>  <c:out value="${prenom}"/> 
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="index.jsp" >Se deconnecter</a></li>

          </ul>
        </li>
       
  </ul>

	<br>

	
<br>
	
	
  <h2>Cr�ation client</h2>

					<form class="form-inline" name="formCPT" action="servInsertClient" onsubmit="return validerFormCPT()" method="post">
					    <div class="form-group"> 
      Nom <p><label class="sr-only" for="nom"></label>
      <input  class="form-control" id="nom" name="champ_nom">
    </div> <br>
    <div class="form-group">
      Prenom <p><label class="sr-only" for="prenom"></label>
      <input  class="form-control" id="prenom" name="champ_prenom">
    </div><br>
	 <div class="form-group"> 
      Adresse <p><label class="sr-only" for="adresse"></label>
      <input  class="form-control" id="adresse" name="champ_adresse">
    </div> <br>
	
	<div class="form-group"> 
      Code Postal <p><label class="sr-only" for="codePostal"></label>
      <input type="text" class="form-control" id="codePostal" name="champ_codePostal" required>
    </div> <br>
	
     <div class="form-group"> 
      Ville <p><label class="sr-only" for="ville" ></label>
      <input  class="form-control" id="ville" name="champ_ville">
    </div> <br>
	<div class="form-group"> 
      T�l�phone <p><label class="sr-only" for="telephone"></label>
      <input  class="form-control" id="telephone" name="champ_telephone" maxlength="10">
    </div> <br>
	<div class="form-group"> 
      E-mail <p><label class="sr-only" for="email"></label>
      <input type="email" id="inputEmail" class="form-control"  name="champ_email">
    </div> <br>
        <center><button class="btn btn-lg btn-primary btn-block" type="submit" data-toggle="modal" data-target="#myModal">Valider</button></center>

				
					</form> 
				</div>
		

	
<script src="creationScript.js"></script>
</body>
</html>