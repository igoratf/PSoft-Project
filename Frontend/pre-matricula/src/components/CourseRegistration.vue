<template>
  <section class="course-registration animated fadeInDown delay-1s">
    <MenuPreMat />

    <div class="container form-container">
      <form>
        <div class="form-header">
          <h1>Cadastro de Disciplinas</h1>
        </div>
        <hr>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="name">Nome</label>
            <input type="text" class="form-control" id="name" placeholder="Nome da disciplina" v-model="name">
          </div>
          <div class="form-group col-md-6">
            <label for="code">Código da disciplina</label>
            <input type="number" class="form-control" id="code" placeholder="Código da disciplina" v-model="code">
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="credit">Créditos</label>
            <input type="number" class="form-control" id="credit" min=0 max=10 placeholder="Créditos da disciplina" v-model="credit">
          </div>
          <div class="form-group col-md-6">
            <label for="workload">Carga horária</label>
            <input type="number" class="form-control" id="workload" placeholder="Carga horária da disciplina" v-model="workload">
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-4">
          </div>
          <div class="form-group col-md-4">
            <label for="inputState">Grade curricular</label>
            <select id="inputState" class="form-control" v-model="coursePlan">
              <option selected>Nova</option>
              <option>Antiga</option>
              <option>Ambas</option>
            </select>
          </div>
          <div class="form-group col-md-4">
          </div>
        </div>
        <button type="submit" class="btn btn-primary">Sign in</button>
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
      credit: null,
      workload: null,
      coursePlan: null
    };
  },

  methods: {},

  computed: {}
};
</script>

<style scoped>
.form-container {
  width: 100%;
  border: 2px solid black;
  padding: 12px;
  margin-top: 5%;
  margin-bottom: 15%;
}
</style>
