<template>

  <section class="student-registration">
    <MenuPreMat :user="user" v-if="user.role =='Coordinator' || user.registration"/>

    <div class="container animated zoomIn faster">
      <div class="row">
        <div class="col"></div>
        <div class="col">
          <div class="form-container">
            <h1 v-if="!user.role"> Cadastro </h1>
            <h1 v-else>Editar dados</h1>
            <hr>
            <div class="row">
              <div class="col" v-if="!user.role">
                Para continuar, por favor insira sua matrícula e sua grade abaixo
              </div>
              <div class="col" v-else>
                Atualize seus dados abaixo
              </div>
            </div>
            <hr>
            <form id="student-form" @submit.prevent="submit">
              <div class="form-group">
                <label for="exampleInputEmail1">Matrícula</label>
                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Insira sua matrícula" v-model="registration" minlength=9 maxlength=9 required>
                <small class="form-text text-muted">Campo obrigatório</small>
              </div>
              <div class="form-group">
                <label for="exampleFormControlSelect2">Grade Curricular</label>
                <select class="form-control" id="exampleFormControlSelect2" v-model="coursePlan" required>
                  <option disabled selected value="">Selecione a grade</option>
                  <option>Nova</option>
                  <option>Antiga</option>
                </select>
                <small class="form-text text-muted">Campo obrigatório</small>
              </div>
              <hr>
              <button type="submit" class="btn btn-outline-primary">Cadastrar</button>
            </form>
          </div>
          <button class="btn btn-outline-dark back" @click="returnNavigation"><i class="fas fa-backward"></i> Sair</button>
        </div>
        <div class="col">
        </div>
      </div>

    </div>
  </section>

</template>

<script>
import MenuPreMat from "@/components/MenuPreMat.vue";
import AuthService from "../services/AuthService.js";
import axios from '../auth-axios/axios';

export default {
  name: "student-registration",
  components: {
    MenuPreMat
  },
  mounted() {
    axios.idToken = localStorage.getItem('token')
  },
  data() {
    return {
      user: "",
      registration: "",
      coursePlan: ""
    };
  },
  methods: {
    submit() {
      let formData = {
        registration: this.registration,
        coursePlan: this.coursePlan
      }
      return axios.put('/students', formData)
      .then((result) => {
        alert(result.data)
        this.clearFormData();
      })
      .then(() => {
        return axios.get('/users').then((result) => {
          localStorage.setItem("user", JSON.stringify(result.data))
          this.$router.replace('courses')
        })
      })
      .catch((error) => {
        alert(error.message)
      })
    },
    checkCurrentLogin() {
      if (AuthService.checkCurrentLogin()) {
        this.$router.replace(this.$route.query.redirect || '/student-registration')
      } else {
        this.$router.replace('/login')
      }
    },
    clearFormData() {
      this.registration = null;
      this.coursePlan = "";
    },
    returnNavigation() {
      this.$router.replace("login")
    }
  },
  computed: {},
  created () {
    this.checkCurrentLogin();
  },
  updated () {
    this.checkCurrentLogin();
  }
};
</script>

<style scoped>

.form-container {
  width: 100%;
  border: 2px solid black;
  border-radius: 10px;
  padding: 12px;
  margin-top: 20%;
  margin-bottom: 15%;
}

.forgot-pass {
  float: left;
}

.check-remember {
  float: right;
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

.sign-google {
  font-family: "Arial Narrow Bold", sans-serif;
  margin-left: 8px;
}


.back {
  font-size: 16px;
  margin-bottom: 10%;
}
</style>
