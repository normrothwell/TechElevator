const name = 'Cigar Parties for Dummies';
let description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
let reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerHTML = name;
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerHTML = description;
}

/**
 * I will display all of the reviews in the reviews array
 */
function displayReviews() {
  if ('content' in document.createElement('template')) {
    reviews.forEach((review) => {
      displayReview(review);
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

/**
 *
 * @param {Object} review The review to display
 */
function displayReview(review) {
  const main = document.getElementById('main');
  const tmpl = document.getElementById('review-template').content.cloneNode(true);
  tmpl.querySelector('h4').innerHTML = review.reviewer;
  tmpl.querySelector('h3').innerHTML = review.title;
  tmpl.querySelector('p').innerHTML = review.review;
  // there will always be 1 star because it is a part of the template
  for (let i = 1; i < review.rating; ++i) {
    const img = tmpl.querySelector('img').cloneNode();
    tmpl.querySelector('.rating').appendChild(img);
  }
  main.appendChild(tmpl);
}

// LECTURE STARTS HERE ---------------------------------------------------------------

document.addEventListener('DOMContentLoaded', 
  () => {
    setPageTitle();
    setPageDescription();
    displayReviews();
    const toggleButton = document.getElementById('btnToggleForm');
    toggleButton.addEventListener('click', showHideForm);

    const btnSaveReview = document.getElementById('btnSaveReview');
    btnSaveReview.addEventListener('click', (event) =>{event.preventDefault(); saveReview();});
    
  }
)



/**
 * Take an event on the description and swap out the description for a text box.
 *
 * @param {Event} event the event object
 */


/**
 * Take an event on the text box and set the description to the contents
 * of the text box and then hide the text box and show the description.
 *
 * @param {Event} event the event object
 * @param {Boolean} save should we save the description text
 */


/**
 * I will show / hide the add review form
 */
function showHideForm() {
  
  const btn = document.querySelectorAll('btnToggleForm');
  const form = document.querySelector('form');

  if (form.classList.contains('d-none')) {

      // < ... class = 'd-none someOtherClass' >
      form.classList.remove('d-none');
      //  < ... class = 'someOtherClass' >
      btn.innerText = 'Hide Form';
  }
  else {

    form.classList.add('d-none');
    btn.innerText = 'Add Review';
  }
}

/**
 * I will reset all of the values in the form.
 */


/**
 * I will save the review that was added using the add review from
 */
function saveReview(){
  const name = document.getElementById('name');
  const title = document.getElementById('title');
  const review = document.getElementById('review');
  const rating = document.getElementById('rating');

  const newReview = {
    reviewer: name.value,
    title: title.value,
    review: review.value,
    rating: rating.value
  };

  reviews.push(newReview);
  displayReview(newReview);
}
