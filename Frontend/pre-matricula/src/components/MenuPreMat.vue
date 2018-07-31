<template>
  <div class="menu-pre-mat">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <router-link to="/" class="navbar-brand">Pre Matrícula</router-link>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="#navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item">
        <router-link to="student-registration" class="nav-link" active-class="active">Home</router-link>
      </li>
      <li class="nav-item">
        <router-link class="nav-link" to="dashboard" active-class="active">Dashboard</router-link>
      </li>
      <li class="nav-item" v-if="user.role == 'admin'">
        <router-link class="nav-link" to="course-registration" active-class="active">Cadastrar disciplinas</router-link>
      </li>
    </ul>
  </div>

  <div class="header-infos">
    <div v-if="user">
      <span class="header-info"><i class="fas fa-user"></i><span class="logged-info">{{user.name}}</span></span>
      <span class="header-info logout" @click="signOut"><i class="fas fa-times"></i><span class="logged-info">Sair</span></span>
    </div>
  </div>  
</nav>
</div>

</template>

<script>
import firebase from 'firebase/app';
import 'firebase/auth';
import AuthService from '../services/AuthService.js';

  export default {
    name: 'menu-pre-mat',
    data() {
      return {
        user: {
          role: 'admin',
          // user: this.authUser
        }
      }
    },
    methods: {
      signOut() {
        return AuthService.signOut()
        .then((result) => {
          localStorage.clear()
          this.$router.replace('login')
        })
      }
    },
    computed: {
    },
    created() {
      this.user = JSON.parse(localStorage.user)
      console.log('oi')
      console.log(this.user.name)
      // console.log(localStorage.getItem('user').name)
      localStorage.getItem('token')
    }
}
</script>

<style scoped>
  .menu-pre-mat {
    margin-bottom: 15px;
  }

  .router-link-exact-active {
  background: #2E2E2E;
}

  .logout {
    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
    color: white;
    font-size: 16px;
    line-height: 1.5;
    margin-left: 16px;
  }

  .logout:hover {
    cursor: pointer;
  }

  .header-infos {
    color: white;
  }

  .header-info {
    margin-left: 16px;
  }

  .logged-info {
    margin-left: 8px;
  }

</style>
