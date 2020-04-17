<template>
  <div class="hello">

    <!--3. Simply print the prop value-->
    Message from Parent Component: {{msgFromParent}}
    <br>
    <!--4. Pressing this button calls the sendMsgToParent method -->
    <button v-on:click='sendMsgToParent'>Reply To Parent</button>

  </div>
</template>

<script>
export default {
  name: 'Child',

  // 2. In this example, the parent passes a message to
  // the child by defining a message while bringing in 
  // the Child component. See step 1.
  props: {
    msgFromParent: String
  },
  methods :{

    //5. this method emits an event back to the parent called childEvent.
    sendMsgToParent() {
      this.$emit('childEvent', 'what?');
    }
  }
}
</script>