<template>

  <section class="student-registration">
    <MenuPreMat auth-user="authUser"/>
    <h1>Student Registration Component</h1>
  </section>

</template>

<script>
import MenuPreMat from '@/components/MenuPreMat.vue'

  export default  {
    name: 'student-registration',
    components: {
      MenuPreMat
    },
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
