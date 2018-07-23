<template>
  <div class="login-container">
    <div class="container">
      <div class="row">
        <div class="col label">
          <h1>Bem vindo ao Sistema de Pré Matrícula da UFCG</h1>
        </div>
      </div>
      <div class="row">
        <div class="col"></div>
        <div class="col">
          <div class="form-container">

            <h1> Login </h1>
            <hr>
            <form>
              <div class="row">
                <div class="col">
                  Realize login abaixo com a conta CCC
                </div>
              </div>

              <hr>

              <button class="btn btn-google" @click="signInWithGoogle">
              <i class="fab fa-google"></i><span class="sign-google"><strong>Sign in with Google</strong></span></button>

            </form>
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

export default {
  name: "Login",
  data() {
    return {
      authUser: null
    };
  },
  methods: {
    signInWithGoogle() {
      AuthService.signInWithGoogle();
    }
  },
  created() {
    firebase.auth().onAuthStateChanged(user => {
      this.authUser = user;
    });
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
}

.forgot-pass {
  float: left;
}

.check-remember {
  float: right;
}

.label {
  margin-top: 10%;
  margin-left: 50%;
  transform: translateX(-50%);
  text-align: center;
  max-width: 50%;
}

.btn-google {
  color: white;
  background: #b71c1c;
}

.sign-google {
  font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  margin-left: 8px;
}
</style>
