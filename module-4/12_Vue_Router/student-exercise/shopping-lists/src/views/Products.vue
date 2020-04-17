<template>
  <div class="products">
    <h1>Shop By Department</h1>
    <p>Below is a list of our departments. Please click on a department to view available products by department.</p>
    <div class="departments">
      <a href="/products/produce" class="department produce">
        <img src="/img/produce_banner.png">
      </a>
      <a href="/products/dairy" class="department dairy">
        <img src="/img/dairy_banner.png">
      </a>
      <a href="/products/meat" class="department meat">
        <img src="/img/meat_banner.png">
      </a>
      <a href="/products/bakery" class="department bakery">
        <img src="/img/bakery_banner.png">
      </a>
    </div>
  </div>
</template>

<script>
export default {
  name: "products",
  data() {
    return {
      departments: [
        { path: '/produce', banner: 'produce_banner.png', class: 'department produce' },
        { path: '/dairy', banner: 'dairy_banner.png', class: 'department dairy' },
        { path: '/meat', banner: 'meat_banner.png', class: 'department meat' },
        { path: '/bakery', banner: 'bakery_banner.png', class: 'department bakery' }
      ]
    }
  }
}
</script>

<style>
.departments {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
</style>
