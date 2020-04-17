<template>
  <div class="main">
      <form v-on:submit.prevent="peekAtData">
        <input type="text"  v-model='fieldOfText'><button>Do The Thing</button>
    </form>
    <p>Now I'm using v-model, we have two way binding.
    </p>

    <p>Whatever I type in the field now updates the JSON data model as well.
        The value of fieldOfText is now {{fieldOfText}}.
    </p>

  </div>
</template>

<script>
export default {
  name: 'TwoWayComp',
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