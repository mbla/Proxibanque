/**
 * 
 */




function validerFormUpdate() {
    
	
	var x = document.forms["formUpdate"]["champ_codePostal"].value ; // Recuperation de la valeur du champ Login	
	

	var patt = new RegExp(/[^0-9]/);	// Construction d une RegExp
	var res = patt.test(x);				// Test du champ Login
    var condition1;
    
    if(!res) {
    condition1 = true;		// validation du submit
    }
    else{
    	alert("Le champ code postale ne peut contenir \n que des chiffres");			// message d erreur
    
		condition1 = false;
    }
    
	
	var y = document.forms["formUpdate"]["champ_telephone"].value ; // Recuperation de la valeur du champ Login	
	

	var patt = new RegExp(/[^0-9]/);	// Construction d une RegExp
	var res = patt.test(y);				// Test du champ Login
    var condition2;
    
    if(!res) {
    condition2 = true;		// validation du submit
    }
    else{
    	alert("Le champ téléphone ne peut contenir \n que des chiffres");			// message d erreur
    
		condition2 = false;
    }
	if (condition1 && condition2){
		var conf = confirm("Etes vous sur de vouloir modifier les information de ce client!");
		if (conf){
			return true;
		}
		else {
			return false
		}
	}
	else {
	return false;
	}
}

