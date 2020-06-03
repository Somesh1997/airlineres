/**
 * @author Ankit Shrivastav
 * @Date 21/11/2019
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

	// validation start for firstName and lastName
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
	var lettersUsername = /^[a-zA-Z0-9]{4,20}$/;		//regex for username
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
//	var lettersDOB = /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/; // regex for DOB validation
//	if (dob == null || dob == "" || !lettersDOB.test(dob)) {
//		alert("Invalid DOB");
//		return false;
//	}

	
	// validation start for password and confirm password
	var lettersPassword = /^[A-Za-z]\w{8,16}$/;		//regex for password validation alphanumeric and underscore allowed
	if (password != cpassword || password == null || password == "" || cpassword == null || cpassword == "") {
		alert("Invalid Password or confirm password");
		return false;
	}
	if(!lettersPassword.test(password) || !lettersPassword.test(cpassword)){
		alert("Password must be between 8-16 character long with alphanumeric & underscore valid & first character must be a alphabet");
		return false;
	}

}

function validateCheckPassword(){
	var oldPass = document.getElementById('password').value;
	var newPass = document.getElementById('npassword').value;
	var cNewPass = document.getElementById('cpassword').value;
	
	if(oldPass == null || oldPass == "" || newPass == null || newPass == "" || cNewPass == null || cNewPass == "")
	{
		alert("Please enter some text field inside the password box");
		return false;
	}
	
	if((oldPass.length <= 8 && oldPass.length >= 17) || (newPass.length <= 8 && newPass.length >= 17) || (cNewPass.length <= 8 && cNewPass.length >= 17))
	{
		alert("Please enter minimum of 8 and maximum of 16 characters");
		return false;
	}
	
	var passRegex = /^[A-Za-z]\w{8,16}$/;
	if(!passRegex.test(oldPass) || !passRegex.test(newPass) || !passRegex.test(cNewPass))
	{
		alert("Password can have only alphanumeric & underscore & first character must be a alphabet");
		return false;
	}
}

function searchFlight(){
	var from = document.getElementById('flightfrom').value;
	var to = document.getElementById('flightto').value;
	
	if(from == to){
		alert("Source and destination can't be same");
		return false;
	}
}