/**
 * 
 */




function validerFormConnexion() {
    
	
	var x = document.forms["formConnexion"]["champ_login"].value ; // Recuperation de la valeur du champ Login	

	var patt = new RegExp(/[^A-z]/);	// Construction d une RegExp
	var res = patt.test(x);				// Test du champ Login
    
    
    if(!res) {
    	return true;					// validation du submit
    }
    else{
    	alert("Le champ login ne peut contenir \n que des lettres majuscules et minuscules");			// message d erreur
    	return false
    }
    
}