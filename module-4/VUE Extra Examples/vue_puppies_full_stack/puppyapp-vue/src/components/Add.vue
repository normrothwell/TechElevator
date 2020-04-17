<template>
  <div id='main'>
     <div id='input-section'> 
        <form>
            Name: <input id='dog-name' v-model='puppy.name' /> <br><br>
            Weight:  <input id='dog-weight' v-model='puppy.weight' /> <br><br>
            Gender:  <select id='dog-gender' v-model='puppy.gender'>   
                <option value='Male' selected>Male</option>    
                <option value='Female'>Female</option>              
            </select> <br> <br>
            Paper Trained? <select id='dog-paper-trained' v-model='puppy.paperTrained'>
                <option value='true' selected>True</option>    
                <option value='false'>False</option>     
            </select><br><br>    
            <button id='dog-add-btn' v-on:click='saveReview'>Add Doggo!</button>
        </form>
      </div>
  </div>
</template>

<script>
export default {

    data() {
        return { 
            puppy: {
                name: '',  
                weight: '',
                gender: '',
                paperTrained: ''   
            }
        };
    },
    methods: {
        saveReview() {
            fetch('http://localhost:8080/01-Puppies-API-Final/api/newPuppy',
                {
                method: 'POST',
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(this.puppy)
            })
            .then (
                () => {window.alert('puppy added!');}
            )
            .catch(
                (err) => {console.error(err + ' problem adding doggo!'); }
            )
        }

    }
}
</script>

<style>
    #input-section {
        background-color: cornflowerblue;
        margin: 20px;
        padding: 20px;
        width: 20%;
    }
</style>