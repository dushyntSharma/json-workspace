function getCountry() {
    var country = $("input").val();
    $.ajax({
        method: "GET",
        url: "https://restcountries.eu/rest/v2/name/" + country + "?fullText=true",


    }).done(function (res) {
        console.log(typeof (res));
        var str = "<h1>" + res[0].name + "'s Data here...";
        str += "<table class='table'>";
        for (var item in res[0]) {
            if (Array.isArray(res[0][item])) {
                str += "<tr><td><strong>" + item + "<strong></td>";
                var val = "";
                for (var i = 0; i < res[0][item].length; i++) {
                    if(typeof(res[0][item][i]).isObject){
                        val +=readObject(res[0][item][i]);
                    }else{
                        val += res[0][item][i];
                    }
                    val+="<br>"

                }
                str += "<td>" + val + "</td><td>" + typeof (res[0][item]) + "</td></tr>";
            } else if (item.toString() === "flag") {
                str += "<tr><td><strong>" + item + "<strong></td><td><img src='" + res[0][item] + "' width=600 height=300 /></td><td>" + typeof (res[0][item]) + "</td></tr>";
            } else {
                str += "<tr><td><strong>" + item + "<strong></td><td>" + res[0][item] + "</td><td>" + typeof (res[0][item]) + "</td></tr>";
            }

        }
        str += "</table>";
        $("#countryData").html(str);
    });

}
function readObject(obj){
        var str="";
        for(var n in obj){
            str+=obj[n];
        }
        return str;
    }