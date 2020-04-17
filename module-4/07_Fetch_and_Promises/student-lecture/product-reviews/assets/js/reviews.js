let reviews = [];

function loadReviews(){
    console.log('Loading Reviews');

    fetch('data.json')
    .then((response)=> {return response.json();})
    .then((data)=> {reviews = data; displayReviews();})
    .catch ((err) => {console.log(err);});

}

function displayReviews(){
    console.log("displaying reviews");
    if ('content' in document.createElement('template')){
        const container = document.querySelector('.reviews');
        reviews.forEach((review) => {
            const templ = document.getElementById('review-template').content.cloneNode(true);
            templ.querySelector('.username').innerText = review.username;
            templ.querySelector('img').setAttribute('src', review.avatar);
            templ.querySelector('h2').innerText = review.title;
            templ.querySelector('.published-date').innerText = review.publishedOn;
            templ.querySelector('.user-review').innerText = review.review;
            container.appendChild(templ);
        }
        )


    }else{
        console.log('does not support templates');
    }
}

const button = document.querySelector('button');
button.addEventListener('click', ()=>{
    loadReviews(); 
    button.disabled = true;
});