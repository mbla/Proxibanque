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

		<title>Liste Clients</title>
		
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

  <h2>Liste de Clients</h2>

        <form class="form-inline" action="creation.jsp" >
        <h3 align="right"><button class="btn btn-primary btn-sl" type="submit">Creer un client</button></h3>
		</form>
		
    <div class="table-responsive">   <%-- si ecran petit barre de défilement en bas pour voir tout le tableau --%>
    <div>
   <table class="table table-hover">   <%-- effet "hover" les largeurs des colonnes s'adaptent, la dernière prime sur la première--%>
   
    <thead>
      <tr>
	    <th><center>Identifiant</center></th>
        <th><center>Nom</center></th>
        <th><center>Prenom</center></th>
		<th><center>  </center></th>
      </tr>
    </thead>
    <tbody>
     
    <c:if test="${sizeListeClient >= 1}">  
		<form action="servGetClient" method="post">
      <tr>
	    <td><input type="text" name="champ_idclient" value="<c:out value="${idclient0}"/>" size="1" readonly></td>    
	    <td><c:out value="${nomclient0}"/></td>
        <td><c:out value="${prenomclient0}"/></td>
        <td><center><button class="btn btn-link" type="submit">Afficher</button></center></td>
      </tr>
      </form>
    </c:if> 
    
   <c:if test="${sizeListeClient >= 2}"> 
   <form action="servGetClient" method="post">
      <tr>
	    <td><input type="text" name="champ_idclient" value="<c:out value="${idclient1}"/>" size="1" readonly></td>    
	    <td><c:out value="${nomclient1}"/></td>
        <td><c:out value="${prenomclient1}"/></td>
        <td><center><button class="btn btn-link" type="submit">Afficher</button></center></td>
      </tr>
      </form>
    </c:if>
    
    <c:if test="${sizeListeClient >= 3}">
    <form action="servGetClient" method="post">
      <tr>
	    <td><input type="text" name="champ_idclient" value="<c:out value="${idclient2}"/>" size="1" readonly></td>    
	    <td><c:out value="${nomclient2}"/></td>
        <td><c:out value="${prenomclient2}"/></td>
        <td><center><button class="btn btn-link" type="submit">Afficher</button></center></td>
      </tr>
      </form>
    </c:if> 
     
     <c:if test="${sizeListeClient >= 4}"> 
     <form action="servGetClient" method="post">
      <tr>
	    <td><input type="text" name="champ_idclient" value="<c:out value="${idclient3}"/>" size="1" readonly></td>    
	    <td><c:out value="${nomclient3}"/></td>
        <td><c:out value="${prenomclient3}"/></td>
        <td><center><button class="btn btn-link" type="submit">Afficher</button></center></td>
      </tr>
      </form>
    </c:if> 
    
    <c:if test="${sizeListeClient >= 5}"> 
    <form action="servGetClient" method="post">
      <tr>
	    <td><input type="text" name="champ_idclient" value="<c:out value="${idclient4}"/>" size="1" readonly></td>    
	    <td><c:out value="${nomclient4}"/></td>
        <td><c:out value="${prenomclient4}"/></td>
        <td><center><button class="btn btn-link" type="submit">Afficher</button></center></td>
      </tr>
      </form>
    </c:if> 
     
     <c:if test="${sizeListeClient >= 6}"> 
     <form action="servGetClient" method="post">
      <tr>
	    <td><input type="text" name="champ_idclient" value="<c:out value="${idclient5}"/>" size="1" readonly></td>    
	    <td><c:out value="${nomclient5}"/></td>
        <td><c:out value="${prenomclient5}"/></td>
        <td><center><button class="btn btn-link" type="submit">Afficher</button></center></td>
      </tr>
      </form>
    </c:if> 
    
    <c:if test="${sizeListeClient >= 7}">
    <form action="servGetClient" method="post"> 
      <tr>
	    <td><input type="text" name="champ_idclient" value="<c:out value="${idclient6}"/>" size="1" readonly></td>    
	    <td><c:out value="${nomclient6}"/></td>
        <td><c:out value="${prenomclient6}"/></td>
        <td><center><button class="btn btn-link" type="submit">Afficher</button></center></td>
      </tr>
    </c:if> 
    
    <c:if test="${sizeListeClient >=8}"> 
    <form action="servGetClient" method="post"> 
      <tr>
	    <td><input type="text" name="champ_idclient" value="<c:out value="${idclient7}"/>" size="1" readonly></td>    
	    <td><c:out value="${nomclient7}"/></td>
        <td><c:out value="${prenomclient7}"/></td>
        <td><center><button class="btn btn-link" type="submit">Afficher</button></center></td>
      </tr>
      </form>
    </c:if> 
    
      <c:if test="${sizeListeClient >=9}">
      <form action="servGetClient" method="post">  
      <tr>
	    <td><input type="text" name="champ_idclient" value="<c:out value="${idclient8}"/>" size="1" readonly></td>    
	    <td><c:out value="${nomclient8}"/></td>
        <td><c:out value="${prenomclient8}"/></td>
        <td><center><button class="btn btn-link" type="submit">Afficher</button></center></td>
      </tr>
      </form>
    </c:if> 
    
     <c:if test="${sizeListeClient >=10}">
     <form action="servGetClient" method="post"> 
      <tr>
	    <td><input type="text" name="champ_idclient" value="<c:out value="${idclient9}"/>" size="1" readonly></td>    
	    <td><c:out value="${nomclient9}"/></td>
        <td><c:out value="${prenomclient9}"/></td>
        <td><center><button class="btn btn-link" type="submit">Afficher</button></center></td>
      </tr>
      </form>
    </c:if> 
   
      
    </tbody>
	</table>

  
  
    </div>    
  	</div> <!-- Fin de la table  -->

</div> <!-- Fin du container -->


    <%-- IE10 viewport hack for Surface/desktop Windows 8 bug --%>
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>


</body>
</html>