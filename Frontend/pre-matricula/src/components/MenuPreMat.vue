<template>
  <div class="menu-pre-mat">
    <b-navbar toggleable="md" type="dark" variant="dark">

      <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

      <router-link to="/"><b-navbar-brand>Pré Matrícula</b-navbar-brand></router-link>

      <b-collapse is-nav id="nav_collapse">

        <b-navbar-nav>
          <router-link to="/student-registration"><b-nav-item href="student-registration">Home</b-nav-item></router-link>
          <router-link to="/dashboard"><b-nav-item href="dashboard">Dashboard</b-nav-item></router-link>
        </b-navbar-nav>
      </b-collapse>
    

    <div class="header-infos">
      <div v-if="authUser">
        <span class="header-info">
          <i class="fas fa-user"></i>
          <span class="logged-info">{{authUser.displayName}}</span>
        </span>
        <span class="header-info logout" @click="signOut">
          <i class="fas fa-times"></i>
          <span class="logged-info">Sair</span>
        </span>
      </div>
    </div>
    </b-navbar>
  </div>

</template>

<script>
import firebase from "firebase/app";
import "firebase/auth";
import AuthService from "../services/AuthService.js";

export default {
  name: "menu-pre-mat",
  data() {
    return {
      authUser: null
    };
  },
  methods: {
    signOut() {
      return AuthService.signOut().then(result => {
        // localStorage.clear();
        this.$router.replace("login");
      });
    }
  },
  computed: {},
  created() {
    firebase.auth().onAuthStateChanged(user => {
      this.authUser = user;
    });
  }
};
</script>

<style scoped>
.router-link-exact-active {
  background: #2E2E2E;
}

.router-link {
  color:#2E2E2E
}

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
