<template lang="html">

  <section class="dashboard">
    <MenuPreMat />
    <h1>dashboard Component</h1>
  </section>

</template>

<script>
import MenuPreMat from '@/components/MenuPreMat.vue'

  export default  {
    name: 'dashboard',
    components: {
      'menu-pre-mat': MenuPreMat
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

    }
}
</script>

<style scoped>

</style>
