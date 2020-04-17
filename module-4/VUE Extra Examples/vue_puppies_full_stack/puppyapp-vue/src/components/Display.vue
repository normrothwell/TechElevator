<template>
<div id='main'>

    <div class='puppyInfo' v-for='dog in allTheDogs' :key='dog.id'>

        Puppy Name: {{dog.name}} <br>
        Puppy Weight: {{dog.weight}} <br>
        Paper Trained? {{dog.paperTrained}}<br>
        <!--Remember that dynamic route we defined? It's being called here: -->
        <router-link :to="{name: 'display-detail', params: {id: dog.id}}"> Change Puppy's Data! </router-link><br><br>
    
    </div>

</div>
  
</template>

<script>
export default {
    data() { 
        
        return { allTheDogs : []}
    },

  created() {
    fetch('http://localhost:8080/01-Puppies-API-Final/api/allPuppies')
    .then (
      (response) => {return response.json();}
    )
    .then ( 
        (dogData) => {this.allTheDogs = dogData;}
    )
    .catch(
        (err) => {console.error(err + ' uh oh missing doggos!'); }
    )
  }
}

</script>
<style>

  .puppyInfo {
    margin: 20px;
    width: 20%;
    background-color: cornflowerblue;
  }

</style>`