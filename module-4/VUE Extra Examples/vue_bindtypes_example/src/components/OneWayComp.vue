<template>
  <div class="main">
      <form v-on:submit.prevent="peekAtData">
        <input type="text"  v-bind:input='fieldOfText'><button>Do The Thing</button>
    </form>
    <p>I was able to use v-bind to set a property of the input element,
      namely the value to the JSON data model's fieldOfText.
    </p>

    <p>But note that regardless of what I type, I can't change the value
      of the JSON data model, it is still {{fieldOfText}}
    </p>

  </div>
</template>

<script>
export default {
  name: 'OneWayComp',
  data() {
    return {
      fieldOfText : 'Hello',
    };
  }, 
  methods: {
    peekAtData() {
      console.log(this.fieldOfText);
    }
  }
}
</script>