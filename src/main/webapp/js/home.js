let movies = ['movie_1', 'movie_2', 'movie_3', 'movie_4', 'movie_5', 'movie_6', 'movie_7', 'movie_8', 'movie_9', 'movie_10', 'movie_11', 'movie_12', 'movie_13'];
let trending = ['movie_14', 'movie_15', 'movie_16', 'movie_17', 'movie_18', 'movie_20', 'movie_21', 'movie_22', 'movie_23', 'movie_24'];
let watched = ['movie_25', 'movie_26', 'movie_27', 'movie_28', 'movie_29', 'movie_30', 'movie_31', 'movie_32', 'movie_33'];
let netflixOriginals = ['movie_101', 'movie_102', 'movie_103', 'movie_104', 'movie_105', 'movie_106', 'movie_107'];

let continueWatch = document.querySelector('#continue');
let trendingSection = document.querySelector('#trendingSection');
let becauseWatched = document.querySelector('#becauseWatched');
let original = document.querySelector('#original');

function imgCarrouselJPEG(imageArray, htmlElement) {
    for (let i = 0; i < imageArray.length; i++) {
        htmlElement.innerHTML += `
            <div class="item">
                <img class="box-movie" src="../img/movies/${imageArray[i]}.jpg"/>
            </div>`;
    }
}

function carrouseOriginalNetflix(imageArray, htmlElement) {
    for (let i = 0; i < imageArray.length; i++) {
        htmlElement.innerHTML += `
            <div class="item">
                <img class="box-movie-original" src="../img/movies/${imageArray[i]}.jpg"/>
            </div>`;
    }
}

imgCarrouselJPEG(movies, continueWatch);
imgCarrouselJPEG(trending, trendingSection);
imgCarrouselJPEG(watched, becauseWatched);
carrouseOriginalNetflix(netflixOriginals, original);

$('.owl-carousel').owlCarousel({
    loop: true,
    margin: 10,
    nav: true,
    responsive: {
        0: {
            items: 1
        },
        600: {
            items: 3
        },
        1000: {
            items: 5
        }
    }
});
