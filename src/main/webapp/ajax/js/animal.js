var btn = document.getElementById("btn");
var animalContainer = document.getElementById("animal-info");
var pageCounter = 1;


btn.addEventListener("click", function () {
    var ourRequest = new XMLHttpRequest();
    ourRequest.open("GET", "https://learnwebcode.github.io/json-example/animals-" + pageCounter + ".json");
    //ourRequest.open("GET", "https://restcountries.eu/rest/v2/capital/delhi");
    ourRequest.onload = function () {

        if (ourRequest.status >= 200 && ourRequest.status < 400) {
            var ourData = JSON.parse(ourRequest.responseText);
            console.log(ourData);
            renderHtml(ourData);
        } else {
            console.log("We connected to the server but it returned error");
        }

    };
    ourRequest.onerror = function () {
        console.log("Connection Error");
    }
    ourRequest.send();
    pageCounter++;
    if (pageCounter > 3) {
        btn.classList.add("hide-me");
    }
});

function renderHtml(data) {

    var htmlString = "";
    for (let index = 0; index < data.length; index++) {
        htmlString += "<p>" + data[index].name + "is a" + data[index].species + "thats likes ";

        for (let j = 0; j < data[index].foods.likes.length; j++) {
            if (j == 0) {
                htmlString += data[index].foods.likes[j];
            } else {
                htmlString += " and " + data[index].foods.likes[j];
            }

        }
        htmlString += " and dislikes are "
        for (let j = 0; j < data[index].foods.dislikes.length; j++) {
            if (j == 0) {
                htmlString += data[index].foods.dislikes[j];
            } else {
                htmlString += " and " + data[index].foods.dislikes[j];
            }

        }
        htmlString += ".<p>";
    }
    animalContainer.insertAdjacentHTML('beforeend', htmlString);
}