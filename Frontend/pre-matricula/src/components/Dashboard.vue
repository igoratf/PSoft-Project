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
        <th scope="col"></th>
      </tr>
    </thead>
    <tbody is="transition-group" leave-active-class="animated zoomOut faster">
      <tr v-for="(list, index) in listTest" :key="index">
        <input class="course-checkbox" type="checkbox" :value="list" v-model="checked">
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
                <option disabled seleted value="">Selecione a grade</option>
                <option>Nova</option>
                <option>Antiga</option>
                <option>Ambas</option>
              </select></td>
        <td v-else>{{list.coursePlan}}</td>
        <button @click="makeEditable(index)"><i class="far fa-edit"></i></button>
        <button class="btn-remove" @click="deleteCourse(index)"><i class="fas fa-times"></i></button>
      </tr>    
    </tbody>
  </table>
  {{selected}}
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
        editable: false
      };
    },
    methods: {
      submit() {},
      deleteCourse(index) {
        this.listTest.splice(index, 1);
      },
      makeEditable(index) {
        if (this.selected) {
          this.selected = null;
        } else {
          this.selected = this.listTest[index];
        }
        this.editable = !this.editable;
      },
      endEditable() {
        this.selected = null;
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
  </style>
  */