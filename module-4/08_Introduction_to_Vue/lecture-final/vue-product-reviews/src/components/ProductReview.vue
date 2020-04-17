<template>
    <div class="main">
        <h2>Product Reviews for {{ name }}</h2>
        <p class="description">{{ description }}</p>
        <p>Volume in Imperial Units: {{ volumeImperial }}</p>
        <p>Volume in Metric Units:{{ metricUnits }}</p>       
    </div>
</template>

<style scoped>
div.main {
  margin: 1rem 0;
}
</style>

<script>
export default {
  name: 'product-review',
  data() {
    return {
      name: 'Cigar Parties for Dummies',
      description: 'Host and plan the perfect cigar party for all of your squirrelly friends.',
      volumeImperial: '100' 
    }
  },
  computed: {
    metricUnits() {
       let metricMeasure = this.volumeImperial / 0.061024;
       return metricMeasure;
    }
  }
}
</script>