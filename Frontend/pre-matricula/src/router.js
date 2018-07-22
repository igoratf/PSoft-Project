import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Login from './components/Login.vue'
import Cadastro from './components/Cadastro.vue'
import About from './views/About.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect:'/login',
      name: 'home',
      component: Home
    },
    {
      path:'/login',
      name: 'login',
      component: Login
    },
    {
      path:'/cadastro',
      name:'cadastro',
      component: Cadastro
    },
    {
      path: '/about',
      name: 'about',
      component: About
    },
  ]
})
