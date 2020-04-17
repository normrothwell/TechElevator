import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Checkout from './views/Checkout.vue'
import Product from './views/Product.vue'
import Products from './views/Products.vue'
import ShoppingCart from './views/ShoppingCart.vue'
import WeeklySpecials from './views/WeeklySpecials.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/checkout',
      name: 'checkout',
      component: Checkout
    },
    {
      path: '/products/:id',
      name: 'product',
      component: Product
    },
    {
      path: '/products',
      name: 'products',
      component: Products
    },
    {
      path: '/cart',
      name: 'cart',
      component: ShoppingCart
    },
    {
      path: '/on-sale',
      name: 'weekly-specials',
      component: WeeklySpecials
    },
  ]
})
