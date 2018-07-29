<template lang="html">

  <section class="dashboard">
    <MenuPreMat />
    <h1>dashboard Component</h1>
  </section>

</template>

<script>
import MenuPreMat from '@/components/MenuPreMat.vue';
import AuthService from '../services/AuthService.js';

  export default  {
    name: 'dashboard',
    components: {
      MenuPreMat
    },
    props: [],
    mounted() {

    },
    data() {
      return {

      }
    },
    methods: {
      checkCurrentLogin() {
      if (AuthService.checkCurrentLogin()) {
        this.$router.replace(this.$route.query.redirect || '/dashboard')
      } else {
        this.$router.replace('/login')
      }
    }
    },
    computed: {

    },
    updated () {
      this.checkCurrentLogin();
    },
    created () {
      this.checkCurrentLogin();
    }
}
</script>

<style scoped>

</style>
