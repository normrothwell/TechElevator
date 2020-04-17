<template>
  <div id="app">
    <product-review></product-review>
    <img alt="Vue logo" src="./assets/logo.png">
  </div>
</template>

<script>
import ProductReview from './components/ProductReview.vue';

export default {
  name: 'app',
  components: {
    ProductReview
  }
}
</script>
