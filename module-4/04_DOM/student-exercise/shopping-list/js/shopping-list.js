// add pageTitle
const pageTitle = 'My Shopping List';
// add groceries
const groceries = ['Cereal', 'Pizza', 'Chicken Nuggets', 'Ramen', 'Rice', 'Eggs', 'Bacon', 'Juice', 'Chicken', 'Pepper'];
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById('title');
  title.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  let groceryList = document.getElementById('groceries');

  // for (x=0; x<groceries.length; x++){
  //   const item = document.createElement('li');
  //   item.innerText = groceries[x];
  //   groceryList.appendChild(item);
  // }

  groceries.forEach(
    (grocery) => {
      const item = document.createElement('li');
      item.innerText = grocery;
      groceryList.appendChild(item);
    }
  )
}
/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  let groceryList = document.querySelectorAll('li');
  groceryList.forEach(
    (grocery) => {
      grocery.setAttribute('class', 'completed');
    }
  )
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
