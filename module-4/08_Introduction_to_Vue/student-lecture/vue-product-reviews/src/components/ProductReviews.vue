<template>
    <div id = 'main'>
        <h2> Product Reviews for { { name } }</h2>
        <p>{ { description } }</p>
    
    </div>

</template>

<script>
export default {
    
    name: 'ProductReviews',
    data(){
        return {
            name: 'Cigar Parties for Dummies',
            description: 'Banned in 50 countries.'
        }
    }
}
</script>

<style scoped>
    div.main {
        margin: 1rem 0;
    }
</style>