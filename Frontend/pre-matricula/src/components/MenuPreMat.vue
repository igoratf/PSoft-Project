<template>
  <div class="menu-pre-mat">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <router-link to="/" class="navbar-brand">Pre Matrícula</router-link>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <router-link to="home" class="nav-link" href="#">Home</router-link>
      </li>
      <li class="nav-item">
        <a class="nav-link" router-link to>Features</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Pricing</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
  </div>

  <div class="header-infos">
    <div v-if="authUser">
      <span class="header-info"><i class="fas fa-user"></i><span class="logged-info">{{authUser.displayName}}</span></span>
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

  export default  {
    name: 'menu-pre-mat',
    data() {
      return {
        authUser: null
      }
    },
    methods: {
      signOut() {
        firebase.auth().signOut()
        .then((result) => {
          this.$router.replace('login')
        })
      }
    },
    computed: {

    },
    created() {
      firebase.auth().onAuthStateChanged(user => {
      this.authUser = user;
    });
    }
}
</script>

<style scoped>
  .menu-pre-mat {
    margin-bottom: 15px;
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
