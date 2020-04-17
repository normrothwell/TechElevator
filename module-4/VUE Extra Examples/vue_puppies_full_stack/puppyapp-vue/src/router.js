import Vue from 'vue'
import Router from 'vue-router'
import Home from './components/Home.vue'
import Display from './components/Display.vue'
import Add from './components/Add.vue'
import Detail from './components/Detail.vue'

/** 
 * The routes defined below are all associated with one of the 
 * components defined above. If a user visits a URL defined by
 * the routes below, it will cause the component to render and
 * come into view on the browser. 
 * 
 * For example, check out the route for /display. This means that
 * going to the url localhost:8081/display will tell the VUE app
 * to show the "Display" component.
 * 
 * Routes can be dynamic, check out the route for /display:id.
 * This means that going to the url localhost:8081/display/1 will
 * load the "Detail" component, while passing it a path variable of 1.
*/

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
        path: '/display',
        name: 'display',
        component: Display
    },
    {
      path: '/display/:id',
      name: 'display-detail',
      component: Detail
    },
    {
        path: '/add',
        name: 'add',
        component: Add
    }
  ]
})