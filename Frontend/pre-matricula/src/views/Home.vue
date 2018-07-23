<template>
  <div class="home">
    <Login />
  </div>
</template>

<script>
// @ is an alias to /src
import Login from '@/components/Login.vue'
import CadastroAlunos from '@/components/CadastroAlunos.vue'

export default {
  name: 'home',
  components: {
    Login,
    CadastroAlunos
  }
}
</script>
