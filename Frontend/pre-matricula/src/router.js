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
      redirect: '/login'
    },
    {
      path: '/login',
      name: 'login',
      component: Login,
      beforeEnter: (to, from, next) => {
        let currentUser = AuthService.getCurrentUser();
        if (currentUser) {
          next("dashboard")
        } else {
          next()
        }
      }
    },
    {
      path: '/dashboard',
      name: 'dashboard',
      component: Dashboard,
      meta: { requiresAuth: true, requiresRole: true }
    },
    {
      path: '/student-registration',
      name: 'student-registration',
      component: StudentRegistration,
      meta: { requiresAuth: true },
      beforeEnter: (to, from, next) => {
        let currentUser = AuthService.getCurrentUser();
        if (currentUser && currentUser.role == 'Coordinator') {
          next("dashboard")
        } else {
          next()
        }
      }
    },
    {
      path: '/course-registration',
      name: 'course-registration',
      component: CourseRegistration,
      meta: { requiresAuth: true, requiresRole: true },
      beforeEnter: (to, from, next) => {
        let currentUser = AuthService.getCurrentUser();
        if (currentUser && currentUser.role == 'Student') {
          next("dashboard")
        } else {
          next()
        }
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  let requiresAuth = to.meta.requiresAuth
  let requiresRole = to.meta.requiresRole
  let currentUser = AuthService.getCurrentUser();
  let currentUserRole = "";


  console.log(currentUserRole)

  if (currentUser) {
    currentUserRole = currentUser.role;
  }

  if (to.path != '/login' && (!localStorage.token || (!currentUser && requiresAuth))) {
    next('login')
  } else if (requiresRole && !currentUserRole) {
    next('student-registration')
  } 
  else {
    next()
  }

})


export default router