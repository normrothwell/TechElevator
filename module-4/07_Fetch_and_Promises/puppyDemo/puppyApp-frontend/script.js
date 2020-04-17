let puppies = [];
document.addEventListener('DOMContentLoaded', prepPage);

function prepPage() {

   const loadBtn = document.getElementById('load-btn');
   loadBtn.addEventListener('click', loadThePuppies);
}

function loadThePuppies() {
    console.log('load the small puppers');
    fetch ('http://localhost:8080/01-Puppies-API-Final/api/allPuppies')
    .then((response) => {return response.json();})
    .then((data) => {puppies = data; populatePage();})
    .catch((err) => {console.log(err)})
}

function populatePage() {

    const parent = document.getElementById('main');

    puppies.forEach(
        (puppy) => {
            const child = document.createElement('p');
            console.log(puppy);
            child.innerText = `Name: ${puppy.name} | Weight: ${puppy.weight} |  Gender: ${puppy.gender}`;
            parent.appendChild(child);
        }
    );
}