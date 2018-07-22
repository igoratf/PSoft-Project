<template>
  <div id="app">
    <menu-pre-mat/>
    <router-view/>
  </div>
</template>


<script>
import MenuPreMat from './components/MenuPreMat.vue'
export default {
  components: {
    'menu-pre-mat': MenuPreMat
  },
  name: 'app'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
