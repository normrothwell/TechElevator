<template>
  <div id="app">
    <!-- 1. I am passing data from parent to child
    Child has a prop called msgFromParent which is sent
    to the Child by adding the property and giving it a 
    value:
     -->

    <!-- 6. The Child emits an event called childEvent, in
    response to this emission the parent calls a method called
    listenToChild
     -->
    <Child msgFromParent='Hey you' v-on:childEvent='listenToChild'/>


  </div>
</template>

<script>
import Child from './components/Child.vue'

export default {
  name: 'App',
  components: {
    Child
  },
  methods: {

    // 7. listenToChild is called in response to the child's emission.
    // If I want to access the value attached to the emmission, I
    // can simply add a parameter to the method like so:

    listenToChild(waaaaa) {
      window.alert(waaaaa);
    }
  }
}
</script>
