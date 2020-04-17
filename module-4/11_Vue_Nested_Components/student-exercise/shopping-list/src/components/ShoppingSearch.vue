<template>
    <div class="search">
        <input type="text" id="search" name="search" placeholder="Search Shopping List..."/>
    </div>
</template>

<script>
export default {
    name: 'search-bar',
    data() {
        return {
            searchText: ''
        };
    },
    methods: {

    }
}
</script>

<style>
#search {
    width:100%;
    font-size:24px;
    font-family: 'Roboto Condensed', sans-serif;
    padding:10px;
}
</style>