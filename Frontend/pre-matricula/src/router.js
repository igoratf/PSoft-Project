import Vue from 'vue'
import Router from 'vue-router'
import Login from './components/Login.vue'
import Dashboard from './components/Dashboard.vue'
import StudentRegistration from './components/StudentRegistration.vue'
import CourseRegistration from './components/CourseRegistration.vue'
import About from './views/About.vue'
import AuthService from './services/AuthService';

Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '*',
      redirect: '/login'
    },
    {
      path: '/',
      redirect: '/dashboard'
    },
    {
      path: '/login',
      name: 'login',
      component: Login,
    },
    {
      path: '/dashboard',
      name: 'dashboard',
      component: Dashboard,
      meta: { requiresAuth: true }
    },
    {
      path: '/student-registration',
      name: 'student-registration',
      component: StudentRegistration,
      meta: { requiresAuth: true, registered: false }
    },
    {
      path: '/course-registration',
      name: 'course-registration',
      component: CourseRegistration,
      meta: { requiresAuth: true, role: 'admin' }
    },
    {
      path: '/about',
      name: 'about',
      component: About
    },
  ]
})

router.beforeEach((to, from, next) => {
  /*let currentUser = firebase.auth().currentUser;
  let requiresAuth = to.matched.some(record => record.meta.requiresAuth);

  if (requiresAuth && !currentUser) next('login')
  else if (!requiresAuth && currentUser) next('about')
  else next()*/
  let requiresAuth = to.meta.requiresAuth
  let requiresAdmin = to.meta.role
  let currentUserRole = localStorage.getItem('user')
  console.log(currentUserRole)

  if (!localStorage.token && requiresAuth) {
    next('login')
  } else if (requiresAdmin && currentUserRole != 'admin') {
      next('dashboard')
    }
    else {
      next()
    }

})


export default router