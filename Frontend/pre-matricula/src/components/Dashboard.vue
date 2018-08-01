  /* <template lang="html">

    <section class="dashboard">
      <MenuPreMat :user="user"/>

      <Alert :successMessage="successMessage" :errorMessage="errorMessage" :showSuccess="showSuccess" :showError="showError" />

      <div class="container animated zoomIn faster">
        <h1> Lista de disciplinas cadastradas</h1>
  <form @submit.prevent="submitEnrollment">
    <table class="table table-hover">
    <thead>
      <tr>
        <th scope="col" v-if="user.role == 'Student'"></th>
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
        <input class="course-checkbox" type="checkbox" :value="list" v-model="checked" v-if="user.role == 'Student'">
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
        <span class="btn-opts"@click="editDiscipline(index)"><i class="fas fa-edit"></i></span>
        <span class="btn-opts btn-remove" @click="deleteCourse(index)"><i class="fas fa-trash-alt"></i></span>
        </td>
      </tr>    
    </tbody>
  </table>

  <hr>
  <button type="submit" class="btn btn-primary" v-if="user.role == 'Student'">Realizar pré matrícula</button>
  </form>
  </div>
  
  <div class="footer animated zoomIn faster" v-if="user.role == 'Coordinator'">
    <h1>Exportar matrículas </h1>
    <button type="button" class="btn btn-outline-success" @click="getEnrollments">Exportar matrículas</button>
  </div>
  <a id="csvFile"></a>
    </section>

  </template>

  <script>
import firebase from "firebase/app";
import axios from "../auth-axios/axios.js";
import Papa from "papaparse";
import MenuPreMat from "@/components/MenuPreMat.vue";
import AuthService from "../services/AuthService.js";
import CourseService from "../services/CourseService.js";
import Alert from "./Alert.vue";

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
      courseList: [],
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
      });
      return CourseService.submitEnrollment(enrollment)
        .then(result => {
          console.log(result);
          this.setSuccessAlert("Sucesso");
        })
        .catch(error => {
          console.log(error);
          this.setErrorAlert(error.message)
        });
    },
    deleteCourse(index) {
      let discipline = this.courseList[index];
      let code = parseInt(discipline.code);
      return axios
        .delete("/disciplines/" + code)
        .then(result => {
          console.log(result);
          this.getDisciplines();
        })
        .catch(error => {
          this.setErrorAlert(error.message);
        });
    },
    editDiscipline(index) {
      let discipline = this.courseList[index];
      console.log(discipline);
      if (this.selected) {
        this.selected = null;
        return CourseService.registerDiscipline(discipline)
          .then(result => {
            this.setSuccessAlert(result.data);
            console.log(result);
          })
          .catch(error => {
            this.setErrorAlert(error.message)
          });
      } else {
        this.selected = this.courseList[index];
      }
    },
    getDisciplines() {
      return CourseService.getDisciplines()
        .then(result => {
          let list = result.data;
          this.courseList = list.sort(function(a, b) {
            return a.semester - b.semester;
          });
        })
        .catch(error => {
          this.setErrorAlert(error.message);
        });
    },
    getEnrollments() {
      return CourseService.getEnrollments()
        .then(result => {
          console.log(result);
          console.log("json", result.data);
          var enrollmentsCsv = Papa.unparse(result.data);
          console.log(enrollmentsCsv);
          // Papa.download(Papa.unparse(result.data), "data.csv");

          // var encoda = encodeURI(Papa.unparse(result.data);
          // var baixa = document.createElement("a");
          // baixa.setAttribute("href", encoda);
          // baixa.setAttribute("id", "downloadcsv");
          // baixa.setAttribute("download", "arquivo.csv");
          // document.body.appendChild(baixa);
          // baixa.click();
          // document.body.removeChild(baixa)
        })
        .catch(error => {
          console.log(error);
        });
    },
    setSuccessAlert() {
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
    },
    exportEnrollments() {
      return axios.get("/");
    }
  },
  computed: {},
  updated() {},
  created() {
    this.user = AuthService.getCurrentUser();
    this.getDisciplines();
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

.btn-opts:hover {
  cursor: pointer;
}

.btn-remove {
  margin-left: 8px;
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