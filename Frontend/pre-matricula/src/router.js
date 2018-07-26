import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Login from './components/Login.vue'
import Dashboard from './components/Dashboard.vue'
import MenuPreMat from './components/MenuPreMat.vue'
import StudentRegistration from './components/StudentRegistration.vue'
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
      redirect:'/dashboard'
    },
    {
      path:'/login',
      name: 'login',
      component: Login,
    },
    {
      path: '/dashboard',
      name: 'dashboard',
      component: Dashboard
    },
    {
      path:'/student-registration',
      name:'student-registration',
      component: StudentRegistration,
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