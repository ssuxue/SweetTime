import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/fancyCoffee',
  },
  {
    path: '/fancyCoffee',
    name: 'FancyCoffee',
    component: () => import('../views/FancyCoffee.vue'),
  },
  {
    path: '/blackCoffee',
    name: 'BlackCoffee',
    component: () => import('../views/BlackCoffee.vue'),
  },
  {
    path: '/espresso',
    name: 'Espresso',
    component: () => import('../views/Espresso.vue'),
  },
  {
    path: '/enjoyMilkTea',
    name: 'EnjoyMilkTea',
    component: () => import('../views/EnjoyMilkTea.vue'),
  },
  {
    path: '/sweetJuice',
    name: 'SweetJuice',
    component: () => import('../views/SweetJuice.vue'),
  },
  {
    path: '/sindy',
    name: 'Sindy',
    component: () => import('../views/Sindy.vue'),
  },
  {
    path: '/sindy',
    name: 'Sindy',
    component: () => import('../views/Sindy.vue'),
  },
  {
    path: '/doublePeelMilk',
    name: 'DoublePeelMilk',
    component: () => import('../views/DoublePeelMilk.vue'),
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue'),
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
})

export default router
