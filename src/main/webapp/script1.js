/**
 * 
 */


var button = document.getElementById("values-btn");
button.addEventListener("click", function() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
	if (this.readyState == 4 && this.status == 200) {
	    console.log(this.responseText);
	    var data = JSON.parse(this.responseText);
	    renderHtml(data);
	}
    };
    xhr.open('GET', 'GetValues2', true);
    xhr.send();
});
function renderHtml(data) {
    
    let displayRow= ``;
    for (var i = 0; i < data.length; ++i) {
	
	displayRow += `<tr>
	<td>${data[i].id}</td>
	<td>${data[i].name}</td>
	<td>${data[i].age}</td>
	<td>${data[i].skills}</td>
	</tr>`;

    }
    display.innerHTML = displayRow;

}
