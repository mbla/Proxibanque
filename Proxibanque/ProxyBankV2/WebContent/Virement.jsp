<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "fr.GTM.PBV2.domaine.Conseiller"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <title>Virement</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>

    <title>Virement</title>
	


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
            <li><a href="index.jsp" >Se déconnecter</a></li>

          </ul>
        </li>
       
  </ul>

<br>
 <h2>Virement</h2>
   <form class="form-inline" role="form"  action="servVirementCompte" method="post">
    <div class="form-group"> 
      Numero compte a débiter <p><label class="sr-only" for="numCompte1"></label>
      <input  class="form-control" id="nom" name="champ_numCompte1">
    </div>  <p>
	   <div class="form-group"> 
      Numero compte a crediter <p><label class="sr-only" for="numCompte2"></label>
      <input  class="form-control" id="nom" name="champ_numCompte2">
    </div>  <p>
	<div class="form-group"> 
      Montant <p><label class="sr-only" for="montant"></label>
      <input  class="form-control" id="nom" name="champ_montant">
    </div> 

	<h2><c:out value="${erreurVirement}"/></h2>

   <center><button type="submit" class="btn btn-lg btn-primary btn-block" >valider</button></center>
   
   

     </form>   
    </div>
  </div>
  

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</div> 
</body>
</html>
