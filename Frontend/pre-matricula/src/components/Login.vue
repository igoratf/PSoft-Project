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

            <form @submit.prevent="adminLogin">
              <div class="form-group">
                <label for="exampleInputEmail1">Email address</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" v-model="email">
              </div>

              <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" v-model="password">
              </div>

              <div class="row">
                <div class="col">
                  <small>
                    <a href="#">Change password</a>
                  </small>
                </div>
              </div>
              <br>

              <div class="form-group">
                <button type="submit" class="btn btn-primary">Login</button>
              </div>
              <hr>
            </form>

            <div class="row">
              <div class="col">
                Se você for um aluno, realize login abaixo com sua conta CCC
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
import axios from "axios";
const instance = axios.create({
  baseURL: "179.178.138.157"
});

export default {
  name: "login",
  data() {
    return {
      authUser: null,
      email: null,
      password: null
    };
  },
  methods: {
    // Aqui tenho que ver se o backend já tem esse usuário e possivelmente enviar para outro canto em vez do cadastro, no then e catch
    signInWithGoogle() {
      return AuthService.signInWithGoogle().then(result => {
        console.log(result.user);
        console.log("oi");
        console.log(result.user.getIdToken);
        console.log(result.credential.idToken);
        this.$router.replace('student-registration')
        // console.log(result.credential.idToken)
        // console.log(result.user.email)
        // let userEmail = result.user.email
        // console.log('oi')
        // axios.post('http://179.178.138.157:8080/matricula', {
        //   aluno: {
        //     numMatricula: 912391239,
        //     email: userEmail,
        //     codigosDisciplinas: null
        //   }
        // })
        //   .then(() => {
        //     this.$router.replace('student-registration')
        //   })
        // localStorage.setItem('user', user)
        // this.$router.replace('student-registration')
      });
    },
    adminLogin() {
      return AuthService.adminSignIn(this.email, this.password)
      .then()
      .catch()
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
