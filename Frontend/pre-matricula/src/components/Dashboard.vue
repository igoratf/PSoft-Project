<template lang="html">

  <section class="dashboard">
    <MenuPreMat />

    <div class="container animated zoomIn faster">
      <h1> Lista de disciplinas cadastradas</h1>
    <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Período</th>
      <th scope="col">Código</th>
      <th scope="col">Disciplina</th>
      <th scope="col">Num. créditos</th>
      <th scope="col">Carga horária</th>
      <th scope="col">Grade</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="list in listTest">
      <th scope="row">{{list.item}}</th>
      <td>{{list.name}}</td>
      <td>{{list.prop}}</td>
      <td>{{list.yes}}</td>
    </tr>
  </tbody>
</table>
</div>
  </section>

</template>

<script>
import MenuPreMat from "@/components/MenuPreMat.vue";
import AuthService from "../services/AuthService.js";

export default {
  name: "dashboard",
  components: {
    MenuPreMat
  },
  props: [],
  mounted() {},
  data() {
    return {
      listTest: [
        {
          'item':'oi',
          'name':'dois',
          'prop':'tres',
          'yes': 'no'
        }]
    }
  },
  methods: {
    checkCurrentLogin() {
      if (AuthService.checkCurrentLogin()) {
        this.$router.replace(this.$route.query.redirect || "/dashboard");
      } else {
        this.$router.replace("/login");
      }
    }
  },
  computed: {},
  updated() {},
  created() {},
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

h1 {
  margin-bottom: 2%;
}
</style>
