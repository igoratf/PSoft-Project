<template>
  <div class="menu-pre-mat">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Pre Matrícula</a>
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

  <span class="logout" @click="signOut"><i class="fas fa-times"></i>  Sair</span>

</nav>

</div>

</template>

<script>
import firebase from 'firebase/app';
import 'firebase/auth';

import AuthService from '../services/AuthService.js';
  export default  {
    name: 'menu-pre-mat',
    mounted() {

    },
    data() {
      return {
        authUser: null
      }
    },
    methods: {
      signOut() {
        AuthService.signOut();
        console.log('deslogado');
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
  }

  .logout:hover {
    cursor: pointer;
  }
</style>
