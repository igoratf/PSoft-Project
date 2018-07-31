/* <template>
  <section class="course-registration">
    <!-- > Lembrar de passar user como prop para MenuPreMat -->
    <MenuPreMat />

    <Alert :successMessage="successMessage" :errorMessage="errorMessage" :showSuccess="showSuccess" :showError="showError"/>

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

    <div class="container form-container animated zoomIn faster">
      <form @submit.prevent="submit">
        <div class="form-header">
          <h1>Cadastro de Disciplinas</h1>
        </div>
        <hr>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="name">Nome</label>
            <input type="text" class="form-control" id="name" placeholder="Nome da disciplina" v-model="name" required>
          </div>
          <div class="form-group col-md-6">
            <label for="code">Código</label>
            <input type="number" class="form-control" id="code" placeholder="Código da disciplina" v-model="code" required>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="semester">Período</label>
            <input type="number" class="form-control" id="semester" min=1 max=10 placeholder="Período da disciplina" v-model="semester" required>
          </div>
          <div class="form-group col-md-6">
            <label for="workload">Carga horária</label>
            <input type="number" class="form-control" id="workload" placeholder="Carga horária da disciplina" v-model="workload" required>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="credits">Créditos</label>
            <input type="number" class="form-control" id="credits" placeholder="Quantidade de créditos da disciplina" min=0 max=10 v-model="credits" required>
          </div>
          <div class="form-group col-md-6">
             <label for="coursePlan">Grade curricular</label>
            <select id="coursePlan" class="form-control" v-model="coursePlan" required>
              <option disabled selected value="">Selecione a grade</option>
              <option>Nova</option>
              <option>Antiga</option>
              <option>Ambas</option>
            </select>
          </div>
        </div>
        <button type="submit" class="btn btn-primary">Cadastrar</button>
      </form>
    </div>

  </section>
</template>

<script>
import MenuPreMat from '@/components/MenuPreMat.vue';
import axios from '../auth-axios/axios';
import CourseService from '../services/CourseService.js';
import Alert from './Alert.vue';
import AuthService from '../services/AuthService';

export default {
  name: "course-registration",
  components: {
    MenuPreMat,
    Alert
  },
  props: [],

  mounted() {},

  data() {
    return {
      user: null,
      name: null,
      code: null,
      credits: null,
      workload: null,
      semester: null,
      coursePlan: "",
      successMessage: "",
      errorMessage: "",
      showSuccess: false,
      showError: false
    };
  },

  methods: {
    submit() {
      let discipline = {
        name: this.name,
        code: this.code,
        semester: this.semester,
        credits: this.credits,
        workload: this.workload,
        coursePlan: this.coursePlan
      };
      console.log(discipline)
      axios.put('/course/disciplines/put', {
        discipline
      }).then((result) => {
        console.log(result)
        setSuccessAlert(result.message)
      })
      .catch((error) => {
        console.log(error)
        setErrorAlert(error.message)
      })
      // this.clearFormData();
    },
    setSuccessAlert(message) {
        this.successMessage = message;
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
    clearFormData() {
      this.name = null,
      this.code = null,
      this.credits = null,
      this.semester = null,
      this.workload = null,
      this.coursePlan = "",
      this.showSuccess = false,
      this.showError = false,
      this.errorMessage = false,
      this.successMessage = false
    }
  },
  created () {
    this.user = AuthService.getCurrentUser();
  },

  computed: {}
};
</script>

<style scoped>
.form-container {
  width: 100%;
  border: 2px solid black;
  padding: 12px;
  margin-bottom: 15%;
}
</style>
 */