<template>

    <div id='main'>
    This is the puppy you selected. <br>

    Name: {{puppy.name}} <br>
    Gender: {{puppy.gender}}<br>

    Weight:
    <input type='text' v-model='puppy.weight'/> <br>
    Paper Trained?:  
    <select id='dog-paper-trained' v-model='puppy.paperTrained'>
        <option value='true' selected>True</option>    
        <option value='false'>False</option>     
    </select> <br><br>

    <button id='update-btn' v-on:click='updatePuppy'>Update Data?</button>
    </div>

</template>


<script>
export default {
    data() {
        return {
            puppy : {}
        }
    },
    methods: 
    {
        getPuppyData(id) {

            fetch(`http://localhost:8080/01-Puppies-API-Final/api/puppy/${id}`)
            .then (
                (response) => {return response.json();}
            )
            .then ( 
                (dogData) => {this.puppy = dogData;}
            )
            .catch(
                (err) => {console.error(err + ' uh oh missing doggos!'); }
            )
        },

        updatePuppy() {
             fetch('http://localhost:8080/01-Puppies-API-Final/api/editPuppy',
                {
                method: 'PUT',
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(this.puppy)
            })
            .then(
                () => {window.alert('puppy data updated!');}
            )
            .catch(
                (err) => {console.error(err + ' problem editing doggo!'); }
            )
        }

    },
    created() {
        this.getPuppyData(this.$route.params.id);
    },
}
</script>