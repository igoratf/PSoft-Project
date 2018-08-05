import Vue from 'vue'
import Router from 'vue-router'
import Login from './components/Login.vue'
import Dashboard from './components/Dashboard.vue'
import StudentRegistration from './components/StudentRegistration.vue'
import CourseRegistration from './components/CourseRegistration.vue'
import AuthService from './services/AuthService';
import axios from './auth-axios/axios';

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
    },
    {
      path: '/dashboard',
      name: 'dashboard',
      component: Dashboard,
      meta: { requiresAuth: true, requiresRole: true },
      beforeEnter: (to, from, next) => {
        let currentUser = AuthService.getCurrentUser();
        if (!currentUser || !currentUser.role) {
          next("login")
        } else {
          next()
        }
      }
    },
    {
      path: '/student-registration',
      name: 'student-registration',
      component: StudentRegistration,
      // meta: { requiresAuth: true },
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
        if (!currentUser) {
          next("login")
        }
        else if (currentUser) {
          next("dashboard")
        } else {
          next()
        }
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
axios.defaults.headers.common['Authorization'] = 'Bearer ' + localStorage.getItem('token')
next()

})


export default router