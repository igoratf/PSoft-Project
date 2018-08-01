  /* <template lang="html">

    <section class="dashboard">
      <MenuPreMat />

      <div class="container animated zoomIn faster">
        <h1> Lista de disciplinas cadastradas</h1>
  <form @submit.prevent="submitEnrollment">
    <table class="table table-hover">
    <thead>
      <tr>
        <th scope="col"></th>
        <th scope="col">Período</th>
        <th scope="col">Código</th>
        <th scope="col">Disciplina</th>
        <th scope="col">Num. créditos</th>
        <th scope="col">Carga horária</th>
        <th scope="col">Grade</th>
        <th scope="col"></th>
      </tr>
    </thead>
    <tbody is="transition-group" leave-active-class="animated zoomOut faster">
      <tr v-for="(list, index) in courseList" :key="index">
        <input class="course-checkbox" type="checkbox" :value="list" v-model="checked" v-if="user.role">
        <td scope="row" v-if="list == selected"><input class="form-input-number" type="number"  v-model="selected.semester"></td>
        <td v-else scope="row">{{list.semester}}</td>
        <td scope="row" v-if="list == selected"><input class="form-input-text" type="text" v-model="selected.code"></td>
        <td v-else>{{list.code}}</td>
        <td scope="row" v-if="list == selected"><input class="form-input-text" type="text" v-model="selected.name"></td>
        <td v-else>{{list.name}}</td>
        <td scope="row" v-if="list == selected"><input class="form-input-number" type="number" v-model="selected.credits"></td>
        <td v-if="list != selected">{{list.credits}}</td>
        <td scope="row" v-if="list == selected"><input class="form-input-text" type="number" v-model="selected.workload"></td>
        <td v-else>{{list.workload}}</td>
        <td scope="row" v-if="list == selected"><select id="coursePlan" class="form-input-text" v-model="selected.coursePlan">
                <option disabled selected value="">Selecione a grade</option>
                <option>Nova</option>
                <option>Antiga</option>
                <option>Ambas</option>
              </select></td>
        <td v-else>{{list.coursePlan}}</td>
        <td v-if="user.role == 'Coordinator'">
        <button class="btn-opts"@click="editDiscipline(index)"><i class="far fa-edit" ></i></button>
        <button class="btn- opts btn-remove" @click="deleteCourse(index)"><i class="fas fa-times"></i></button>
        </td>
      </tr>    
    </tbody>
  </table>
  {{selected}}
  <hr>
  <button type="submit" class="btn btn-primary">Concluir</button>
  </form>
  </div>

   <!-- <div class="container alert alert-success alert-dismissible fade" :class="{show: showSuccess}" role="alert">
      {{successMessage}}
      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>

    <div class="container alert alert-danger alert-dismissible fade" :class="{show: showError}" role="alert">
      {{errorMessage}}
      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div> -->

  {{checked}}

  <Alert :successMessage="successMessage" :errorMessage="errorMessage" :showSuccess="showSuccess" :showError="showError" />


  <div class="container footer animated zoomIn faster" v-if="user.role == 'Coordinator'">
    <h1>Exportar matrículas </h1>
    <button type="button" class="btn btn-outline-success">Exportar matrículas</button>
  </div>
    </section>

  </template>

  <script>
  import firebase from 'firebase/app';
  import axios from '../auth-axios/axios.js';
  import MenuPreMat from '@/components/MenuPreMat.vue';
  import AuthService from '../services/AuthService.js';
  import CourseService from '../services/CourseService.js';
  import Alert from './Alert.vue';

  export default {
    name: "dashboard",
    components: {
      MenuPreMat,
      Alert
    },
    props: [],
    mounted() {},
    data() {
      return {
        user: "",
        courseList: [
          {
            semester: 1,
            code: "18290380123",
            name: "Programação I",
            credits: 4,
            workload: 60,
            coursePlan: "Ambas"
          },
          {
            semester: 1,
            code: "12903819203",
            name: "LPT",
            credits: 4,
            workload: 60,
            coursePlan: "Antiga"
          }
        ],
        checked: [],
        selected: null,
        successMessage: "oi",
        errorMessage: "oi",
        showSuccess: false,
        showError: false
      };
    },
    methods: {
      submitEnrollment() {
        let enrollment = this.checked.map(function(discipline) {
          return discipline.code;
        })
        return axios.put('/course/enroll', {
          enrollment
        })
        .then((result) => {
          this.setAlert(this.showSuccess);
        })
        .catch((error) => {
          this.setErrorAlert(error.message);
        })
      },
      deleteCourse(index) {
        let discipline = this.courseList[index];
        return axios.delete('/')
        .then(setSuccessAlert())
        .catch(this.setErrorAlert())
        this.courseList.splice(index, 1);
      },
      editDiscipline(index) {
        let discipline = this.courseList[index];
        if (this.selected) {
          this.selected = null;
          return CourseService.registerDiscipline(discipline)
          .then((result) => {
          })
          .catch((error) => {
            alert(error.message)
          })
        } else {
          this.selected = this.courseList[index];
        }
      },
      setSucessAlert() {
        this.showSuccess = true;
        setTimeout(this.closeSuccessAlert, 2000);
      },
      setErrorAlert(message) {
        this.errorMessage = message;
        this.showError = true;
        setTimeout(this.closeErrorAlert, 2000);
      },
      closeSuccessAlert() {
        this.showSuccess = false;
      },
      closeErrorAlert() {
        this.showError = false;
      }
    },
    computed: {},
    updated() {
      this.user = AuthService.getCurrentUser();
      return axios.get('/disciplines')
      .then((result) => {
        // this.courseList = result
        console.log(result)
      })
    },
    created() {
      console.log(this.user)
      this.user = AuthService.getCurrentUser();
      this.getUser();
      console.log(this.user.role)
      // CourseService.getDisciplines()
      // .then((result) => {
      //   this.courseList = result;
      // })
      // .catch((error) => {
      //   alert(error.message)
      // })
    },
    beforeRouteEnter(to, from, next) {
      next(vm => {
        if (AuthService.checkCurrentLogin()) {
          vm.$router.replace(vm.$route.query.redirect || "/dashboard");
        } else {
          vm.$router.replace("/login");
        }
      });
    }
    
  };
  </script>

  <style scoped>
  .container {
    margin-top: 5%;
  }

  .course-checkbox {
    margin-top: 18px;
  }

  h1 {
    margin-bottom: 2%;
  }

  .btn-remove {
    margin-left: 6px;
  }

  .form-input-text {
    width: 100px;
  }

  .form-input-number {
    width: 50px;
  }

  table {
    margin-right: 10%;
  }


  .footer {
    margin-bottom: 8%;
  }
  </style>
  */