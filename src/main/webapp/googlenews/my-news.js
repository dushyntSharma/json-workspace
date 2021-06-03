$(document).ready(function() {
    $.ajax({
        url: "https://newsapi.org/v2/top-headlines?country=us&apiKey=e03753c9126b408d870a44318813ac3d"
    }).then(function(data) {
        
        for (i = 0; i < data.articles.length; i++) {
          $('#news').append("<ul><li>"+data.articles[i].title+"</li></ul>");
        }
        
    });
});