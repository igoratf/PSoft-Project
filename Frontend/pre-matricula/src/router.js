import Vue from 'vue'
import Router from 'vue-router'
import Login from './components/Login.vue'
import Dashboard from './components/Dashboard.vue'
import StudentRegistration from './components/StudentRegistration.vue'
import CourseRegistration from './components/CourseRegistration.vue'
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
      meta: { requiresAuth: true, requiresAdmin: true }
    }
  ]
})

router.beforeEach((to, from, next) => {
  /*let currentUser = firebase.auth().currentUser;
  let requiresAuth = to.matched.some(record => record.meta.requiresAuth);
  */

  let requiresAuth = to.meta.requiresAuth
  let requiresAdmin = to.meta.role
  let currentUser = AuthService.getCurrentUser();
  let currentUserRole = "";


  console.log(currentUserRole)

  if (currentUser) {
    currentUserRole = currentUser.role;
  }

  if (to.path != '/login' && (!localStorage.token || (!currentUser && requiresAuth)) && ) {
    next('login')
  } else if (requiresAdmin && currentUserRole != 'Coordinator') {
    next('dashboard')
  }
  else {
    next()
  }

})


export default router