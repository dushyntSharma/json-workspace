function loadJSON() {
	var data_file = "http://www.tutorialspoint.com/json/data.json";
	var http_request = new XMLHttpRequest();

	http_request.onreadystatechange = function() {

		if (http_request.readyState == 4) {
			// Javascript function JSON.parse to parse JSON data
			var jsonObj = JSON.parse(http_request.responseText);

			// jsonObj variable now contains the data structure and can
			// be accessed as jsonObj.name and jsonObj.country.
			document.getElementById("Name").innerHTML = jsonObj.name;
			document.getElementById("Country").innerHTML = jsonObj.country;
		}
	}

	http_request.open("GET", data_file, true);
	http_request.send();
}