/**
 * @author Ankit Shrivastav
 * @Date 21/11/2019
 * @ReleaseChange
 */

function validateSignUp() {

	// declaring variables for the 7 fields from signup.jsp
	var firstName = document.getElementById('firstName').value;
	var lastName = document.getElementById('lastName').value;
	var username = document.getElementById('username').value;
	var mobile = document.getElementById('mobile').value;
	var email = document.getElementById('email').value;
	var dob = document.getElementById('dob').value;
	var password = document.getElementById('password').value;
	var cpassword = document.getElementById('cpassword').value;

	 //validation start for firstName and lastName
	var lettersName = /^[A-Za-z]+$/; // regex for firstName and lastName validation
	if (firstName == null || firstName == "" || !lettersName.test(firstName)) {
		alert("Invalid First Name");
		return false;
	}
	if (lastName == null || lastName == "" || !lettersName.test(lastName)) {
		alert("Invalid Last Name");
		return false;
	}

	
	//validation start for username
	var lettersUsername = /^[A-Za-z0-9]{4,20}$/;		//regex for username
	if(username == null || username == "" || !lettersUsername.test(username)){
		alert("Username invalid, Use only alphanumeric username between 4 to 20 characters");
		return false;
	}
	
	
	// validation start for mobile number
	var lettersMobile = /^[0-9]{10,10}$/; // regex for mobile number
	if (mobile == null || mobile == "" || !lettersMobile.test(mobile)) {
		alert("Invalid Mobile Number");
		return false;
	}
	
	
	// validation start for email
	var lettersEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/; // regex for email validation
	if (email == null || email == "" || !lettersEmail.test(email)) {
		alert("Invalid Email");
		return false;
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


