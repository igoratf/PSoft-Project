import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Login from './components/Login.vue'
import CadastroAlunos from './components/CadastroAlunos.vue'
import About from './views/About.vue'

import firebase from 'firebase'

Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '*',
      redirect: '/login'
    },
    {
      path: '/',
      redirect:'/about'
    },
    {
      path:'/login',
      name: 'login',
      component: Login,
    },
    {
      path:'/cadastro-alunos',
      name:'cadastro-alunos',
      component: CadastroAlunos,
      meta: {requiresAuth: true}
    },
    {
      path: '/about',
      name: 'about',
      component: About,
      meta: {requiresAuth: true}
    },
  ]
})


router.beforeEach((to, from, next) => {
  let currentUser = firebase.auth().currentUser;
  let requiresAuth = to.matched.some(record => record.meta.requiresAuth);

  if (requiresAuth && !currentUser) next('login')
  else if (!requiresAuth && currentUser) next('cadastro-aluno')
  else next()
})


export default router