<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "fr.GTM.PBV2.domaine.Conseiller"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Création Nouveau Client</title>
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

  <h2>Création compte Courant</h2>

					<form class="form-inline" name="formInsertCompte" action="servInsertCompteCourant"  method="post">
					    <div class="form-group">
      Solde <p><label class="sr-only" for="solde"></label>
      <input  class="form-control" id="solde" name="champ_solde"> euros
    </div> <br>
    <div class="form-group">
      Date <p><label class="sr-only" for="date"></label>
      <input  class="form-control" id="date" name="champ_date"> jj/mm/aaaa
    </div><br>
	 <div class="form-group">
      Decouvert Autorise <p><label class="sr-only" for="decouvert"></label>
      <input  class="form-control" id="taux" name="champ_decouvert"> euros
    </div> <br>

	
        <center><button class="btn btn-lg btn-primary btn-block" type="submit" data-toggle="modal" data-target="#myModal">Valider</button></center>


					</form>
				</div>



<script src="creationScript.js"></script>
</body>
</html>