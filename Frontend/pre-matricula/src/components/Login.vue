<template>
  <div class="login-container animated fadeIn slow">
    <div class="container">
      <div class="row">
        <div class="col label">
          <h1>Bem vindo(a) ao Sistema de Pré Matrícula da UFCG</h1>
        </div>
      </div>
      <div class="row">
        <div class="col"></div>
        <div class="col">
          <div class="form-container" style="box-shadow: -12px 12px 8px 0  rgba(0, 0, 0, 0.5);">
            <div class="row">
              <div class="col">
                <img src="../assets/logoufcg.jpg" width=130px>
              </div>
            </div>
            <hr>
            <h1> Login </h1>
            <hr>
            <div class="row">
              <div class="col">
                Realize login abaixo com sua conta @ccc.ufcg.edu.br
              </div>
            </div>
            <hr>

            <button class="btn btn-google" @click="signInWithGoogle" style="margin-bottom: 25px">
              <i class="fab fa-google"></i>
              <span class="sign-google">
                <strong>Sign in with Google</strong>
              </span>
            </button>
          
          </div>
        </div>
        <div class="col"></div>
      </div>
    </div>
  </div>
</template>

<script>
import firebase from "firebase/app";
import "firebase/auth";
import AuthService from "../services/AuthService.js";
import axios from "../auth-axios/axios";

export default {
  name: "login",
  data() {
    return {
      user: null,
      email: null,
      password: null
    };
  },
  methods: {
    signInWithGoogle() {
      return AuthService.signInWithGoogle()
        .then(result => {
          return result.user.getIdToken();
        })
        .then(token => {
          localStorage.setItem("token", token);
          axios.defaults.headers.common['Authorization'] = 'Bearer ' + localStorage.getItem('token')
          return AuthService.getUser();
        })
        .then(result => {
          let user = JSON.parse(result.request.response);
          localStorage.setItem("user", JSON.stringify(user));
          if (!user.role) {
            this.$router.replace("student");
          } else {
            this.$router.replace("course");
          }
        })
        .catch(error => {
          this.$router.replace("student");
          console.log(error);
        });
    }
  },
  created() {
    localStorage.clear();
  }
};
</script>

<style scoped>
.form-container {
  width: 100%;
  border: 2px solid black;
  border-radius: 10px;
  padding: 12px;
  margin-top: 15%;
  margin-bottom: 15%;
  box-shadow: 5px 5px 10px 5px;
}

.label {
  min-width: 300px;
  margin-top: 5%;
  margin-left: 50%;
  transform: translateX(-50%);
  text-align: center;
  max-width: 50%;
}

.btn-google {
  color: white;
  background: #b71c1c;
}

.btn-google:hover {
  background-color: darkred;
}

.sign-google {
  font-family: "Arial Narrow Bold", sans-serif;
  margin-left: 8px;
}
</style>
