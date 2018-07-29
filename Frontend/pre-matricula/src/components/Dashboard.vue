/* <template lang="html">

  <section class="dashboard">
    <MenuPreMat />

    <div class="container animated zoomIn faster">
      <h1> Lista de disciplinas cadastradas</h1>
      <form @submit.prevent="submit">
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
    </tr>
  </thead>
  <tbody>
    <tr v-for="list in listTest" :key="list.code">
      <input class="course-checkbox" type="checkbox" :value="list" v-model="checked">
      <th scope="row">{{list.period}}</th>
      <td>{{list.code}}</td>
      <td>{{list.name}}</td>
      <td>{{list.credit}}</td>
      <td>{{list.workload}}</td>
      <td>{{list.coursePlan}}</td>
    </tr>
  </tbody>
</table>
<hr>
<button type="submit" class="btn btn-primary">Concluir</button>
</form>
</div>

{{checked}}
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
          period: 1,
          code: "18290380123",
          name: "Programação I",
          credit: 4,
          workload: 60,
          coursePlan: "Ambas"
        }
      ],
      checked: []
    };
  },
  methods: {
    submit() {

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

.course-checkbox {
  margin-top: 18px;
}

h1 {
  margin-bottom: 2%;
}
</style>
 */