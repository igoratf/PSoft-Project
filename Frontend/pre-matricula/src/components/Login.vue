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
          <div class="form-container">
            <div class="row">
              <div class="col">
                <img src="../assets/logoufcg.jpg" width=130px>
              </div>
            </div>

            <hr>
            <h1> Login </h1>
            <div class="row">
              <div class="col">
                Realize login abaixo com sua conta @ccc.ufcg.edu.br
              </div>
            </div>
            <hr>

            <button class="btn btn-google" @click="signInWithGoogle">
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
          console.log(result.user._lat)
          localStorage.setItem("token", result.user._lat);
        })
        .then(() => {
          axios
            .get("/users")
            .then(result => {
              let user = result.request.response;
              localStorage.setItem("user", user);
              if (user.registration) {
                this.$router.replace("student-registration")
              } else {
                this.$router.replace("login");
              }
              console.log('user aqui ', user)
              console.log(result);
              console.log(result.request.response);
            })
            .catch(error => {
              console.log(error)
              alert(error.message);
            });
        })
        .catch(error => {
          alert(error.message);
        });
    },
    adminLogin() {
      return AuthService.adminSignIn(this.email, this.password)
        .then()
        .catch();
    }
  },
  created() {
    console.log("oi", localStorage.user);
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.form-container {
  width: 100%;
  border: 2px solid black;
  padding: 12px;
  margin-top: 15%;
  margin-bottom: 15%;
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
