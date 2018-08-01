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
          <li class="nav-item" v-if="user.role == 'Coordinator'">
            <router-link class="nav-link" to="course-registration" active-class="active">Cadastrar disciplinas</router-link>
          </li>
        </ul>
      </div>

      <div class="header-infos">
        <div v-if="user">
          <!-- <span class="header-info" @click="editUser"><i class="fas fa-user"></i><span class="logged-info">{{user.name}}</span></span> -->
          <div class="dropdown user-drop">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              {{user.name}}
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
              <router-link class="dropdown-item" to="student-registration">Alterar dados</router-link>
              <a class="dropdown-item logout" @click="signOut">Sair</a>
              <a class="dropdown-item" href="#">Something else here</a>
            </div>
          </div>
          <div>
          <span class="header-info logout" @click="signOut">
            <i class="fas fa-times"></i>
            <span class="logged-info">Sair</span>
          </span>
          </div>
        </div>
      </div>
    </nav>
  </div>

</template>

<script>
import firebase from "firebase/app";
import "firebase/auth";
import AuthService from "../services/AuthService.js";

export default {
  name: "menu-pre-mat",
  props: ["user"],
  data() {
    return {};
  },
  methods: {
    signOut() {
      AuthService.signOut();
    },
    editUser() {
      this.$router.replace("student-registration");
    }
  },
  computed: {},
  created() {
    localStorage.getItem("token");
  }
};
</script>

<style scoped>

.menu-pre-mat {
  margin-bottom: 15px;
}

.router-link-exact-active {
  background: #2e2e2e;
  color: white;
}

.logout {
  font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
  color: white;
  font-size: 16px;
}

.logout:hover {
  background: #2e2e2e;
  cursor: pointer;
  color: white;
}

.header-infos {
  color: white;
}

.header-info {
  display: inline-block;
  margin-left: 16px;
}

.logged-info {
  margin-left: 8px;
}


.dropdown-item:hover {
  color: white!important;
  background: #2e2e2e;
}
</style>
