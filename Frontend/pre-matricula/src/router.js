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
      beforeEnter: (to, from, next) => {
        let currentUser = AuthService.getCurrentUser();
        if (currentUser) {
          next("course")
        } else {
          next()
        }
      }
    },
    {
      path: '/course',
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
      path: '/student',
      name: 'student-registration',
      component: StudentRegistration,
      // meta: { requiresAuth: true },
      beforeEnter: (to, from, next) => {
        let currentUser = AuthService.getCurrentUser();
        if (currentUser && currentUser.role == 'Coordinator') {
          next("course")
        } else {
          next()
        }
      }
    },
    {
      path: '/course/register',
      name: 'course-registration',
      component: CourseRegistration,
      meta: { requiresAuth: true, requiresRole: true },
      beforeEnter: (to, from, next) => {
        let currentUser = AuthService.getCurrentUser();
        if (!currentUser) {
          next("login")
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