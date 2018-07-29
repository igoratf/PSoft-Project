/* <template>
  <section class="course-registration">
    <MenuPreMat />

    <div class="container alert alert-success alert-dismissible fade" :class="{show: showSuccess}" role="alert">
      Disciplina cadastrada!
      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>

    <div class="container alert alert-danger alert-dismissible fade" :class="{show: showError}" role="alert">
      Erro ao cadastrar disciplina!
      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>

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
            <label for="period">Período</label>
            <input type="number" class="form-control" id="period" min=1 max=10 placeholder="Período da disciplina" v-model="period" required>
          </div>
          <div class="form-group col-md-6">
            <label for="workload">Carga horária</label>
            <input type="number" class="form-control" id="workload" placeholder="Carga horária da disciplina" v-model="workload" required>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="credits">Créditos</label>
            <input type="number" class="form-control" id="credits" placeholder="Quantidade de créditos da disciplina" min=0 max=10 v-model="credit" required>
          </div>
          <div class="form-group col-md-6">
             <label for="coursePlan">Grade curricular</label>
            <select id="coursePlan" class="form-control" v-model="coursePlan" required>
              <option disabled seleted value="">Selecione a grade</option>
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
import MenuPreMat from "@/components/MenuPreMat.vue";

export default {
  name: "course-registration",
  components: {
    MenuPreMat
  },
  props: [],

  mounted() {},

  data() {
    return {
      name: null,
      code: null,
      credits: null,
      workload: null,
      coursePlan: "",
      showSuccess: false,
      showError: false
    };
  },

  methods: {
    submit() {
      let discipline = {
        name: this.name,
        code: this.code,
        credits: this.credits,
        workload: this.workload,
        coursePlan: this.coursePlan
      };
      // Submete aqui
      this.clearFormData();
      this.showSuccess = true
      setTimeout(this.closeSuccessAlert, 2000);
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
      this.workload = null,
      this.coursePlan = "",
      this.showSuccess = false,
      this.showError = false
    }
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