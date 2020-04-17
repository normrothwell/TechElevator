let items = [];
let loaded = false;

function loadItems(){
    console.log ('loading items');
    
    fetch ('assets/data/shopping-list.json')
    .then((response) => {return response.json();})
    .then((data)=> {items = data; displayItems(); loaded = true;})
    .catch((err) => {console.log(err);});
}

function displayItems() {
    if ('content' in document.createElement('template')){
        const container = document.querySelector('.shopping-list');
        items.forEach((grocery) => {
            const form = document.getElementById('shopping-list-item-template').content.cloneNode(true);
            form.querySelector('li').insertAdjacentHTML('afterbegin', grocery.name);

            if (grocery.completed){
                const circle = form.querySelector('.fa-check-circle');
                circle.className += ' completed';
                form.querySelector('li').setAttribute('class', 'completed');
            }
            container.appendChild(form);
        })
    }

}




const button = document.querySelector('.loadingButton');

button.addEventListener('click', ()=>{
    if (!loaded){
        loadItems(); 
    }
});