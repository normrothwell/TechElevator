<template>
  <div id="app">
    <OneWayComp/>
    <TwoWayComp/>
  </div>
</template>

<script>
import OneWayComp from './components/OneWayComp.vue'
import TwoWayComp from './components/TwoWayComp.vue'

export default {
  name: 'App',
  components: {
    OneWayComp,
    TwoWayComp
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
