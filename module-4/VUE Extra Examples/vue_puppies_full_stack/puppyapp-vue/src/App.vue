<template>
  <div id="app">

  <!--
  - We have here 3 router links to be displayed at the top of every page.
  - To see where these links go when the user clicks on them, look at the
  name attribute, then go to router.js, where you will find the definition
  for these routes.
  -->
        <router-link :to="{ name: 'home' }" tag="a" exact>[   Home   ]</router-link>
        <router-link :to="{ name: 'display' }" tag="a">[   List All Puppies   ]</router-link>
        <router-link :to="{ name: 'add' }" tag="a">[   Add Puppies   ]</router-link>
        <router-view/>
  </div>
</template>

<script>

export default {
  name: 'App'
}
</script>

