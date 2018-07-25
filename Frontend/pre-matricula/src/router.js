import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Login from './components/Login.vue'
import CadastroAlunos from './components/CadastroAlunos.vue'
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
      path:'/cadastro-alunos',
      name:'cadastro-alunos',
      component: CadastroAlunos
    },
    {
      path: '/about',
      name: 'about',
      component: About
    },
  ]
})
