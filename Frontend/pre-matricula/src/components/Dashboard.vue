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

    },
    computed: {

    },
    updated () {
    },
    created () {
      
    },
    beforeRouteEnter (to, from, next) {
      if (AuthService.checkCurrentLogin()) {
        console.log('verificado')
      } else {
        this.$router.replace('/login')
      }
    }
}
</script>

<style scoped>

</style>
