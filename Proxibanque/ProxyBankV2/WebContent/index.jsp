<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<title>Authentification Conseiller</title>

<%-- Bootstrap core CSS --%>
 <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

<%-- IE10 viewport hack for Surface/desktop Windows 8 bug --%>
<link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<%-- Custom styles for this template --%>
<link href="index.css" rel="stylesheet">

<%-- Just for debugging purposes. Don't actually copy these 2 lines! --%>
<%--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]--%>
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

<%-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries --%>
<%--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]--%>

</head>
<body>

	<center><div class="container">

      <form class="form-signin" name="formConnexion" action="servLogin" onsubmit="return validerFormConnexion()" method="post">
        <h2 class="form-signin-heading">Authentification</h2>
		
		<br><br>
        
		<label for="inputLogin" class="sr-only">Login</label>
        <input type="text" id="inputLogin" class="form-control" placeholder="Login" name="champ_login" value=<c:out value="${champ_login}"/> >
		
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Mot de passe" name="champ_mdp" required>
        <br>
		
		<div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Se souvenir de moi
          </label>
		<br><br>
        </div><br>
		
        <center><button class="btn btn-lg btn-primary btn-block" type="submit" value="Se Connecter"><center>Valider</center></button></center>
        <br><br>
        <h2 id = "test"> <c:out value="${erreur}"/> </h2>	
      </form>

    </div></center> <%-- /container --%>


    <%-- IE10 viewport hack for Surface/desktop Windows 8 bug --%>
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    <script src="monScript.js"></script>
	
</body>
</html>