<template>

  <section class="student-registration">
    <MenuPreMat />

    <div class="container">
      <div class="row">
        <div class="col"></div>
        <div class="col">
          <div class="form-container">

            <h1> Cadastro </h1>
            <hr>
            <div class="row">
              <div class="col">
                Para continuar, por favor insira sua matrícula abaixo
              </div>
            </div>
            <hr>
            <form>
              <div class="form-group">
                <label for="exampleInputEmail1">Matrícula</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Insira sua matrícula" required>
                <small id="emailHelp" class="form-text text-muted">Campo obrigatório</small>
              </div>
              <hr>
              <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>

          </div>
        </div>
        <div class="col"></div>
      </div>
    </div>
  </section>

</template>

<script>
import MenuPreMat from "@/components/MenuPreMat.vue";

export default {
  name: "student-registration",
  components: {
    MenuPreMat
  },
  mounted() {},
  data() {
    return {
      enrollmentNumber: null
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
  margin-top: 15%;
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
</style>
