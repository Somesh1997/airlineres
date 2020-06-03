/**
 * 
 */

function searchFlight(){
	var flightFrom = document.getElementById('flightfrom').value;
	var flightTo = document.getElementById('flightto').value;
	var departure = document.getElementById('departure').value;
	
	if(flightFrom == "from"){
		alert("Please choose source");
		return false;
	}
	
	if(flightTo == "to"){
		alert("Please choose destination");
		return false;
	}
	
	if(flightFrom == flightTo){
		alert("source and destination can't be the same");
		return false;
	}
	
	if(departure == "" || departure == null){
		alert("date not entered");
		return false;
	}
}
