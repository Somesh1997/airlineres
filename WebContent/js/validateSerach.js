/**
 * @author Ankit Shrivastav
 * @Date 21/11/2019
 * @ReleaseChange
 */

function validateSearchFlight() {

	// declaring variables for the 7 fields from signup.jsp
	var flightFrom = document.getElementById('flightfrom').value;
	var flightTo = document.getElementById('flightto').value;
	var departure = document.getElementById('departure').value;

	// validation for source and destination
	if(flightFrom.localeCompare(("Bangalore-BLR").trim()) != 0 ||
	   flightFrom.localeCompare(("Delhi-DEL").trim()) != 0 ||
	   flightFrom.localeCompare(("Mumbai-BOM").trim()) != 0 ||
	   flightFrom.localeCompare(("Kolkata-CCU").trim()) != 0) 
	{
		alert("Please select a source");
	}
	
	// validation start for Date of Birth
	var lettersDOB = /^\d{4}[./-]\d{2}[./-]\d{2}$/; // regex for DOB validation
	if (dob == null || dob == "" || !lettersDOB.test(dob)) {
		alert("Invalid DOB");
		return false;
	}

	
	// validation start for password and confirm password
	var lettersPassword = /^[A-Za-z]\w{8,16}$/;		//regex for password validation alphanumeric and underscore allowed
	if (password != cpassword || password == null || password == "" || cpassword == null || cpassword == "") {
		alert("Invalid Password or confirm password");
		return false;
	}
	if(!lettersPassword.test(password) || !lettersPassword.test(cpassword)){
		alert("Password must be between 8-16 character long with alphanumeric & underscore valid & first character must be a letter");
		return false;
	}
	
	
	
}
