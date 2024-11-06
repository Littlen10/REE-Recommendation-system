<template>
  <div id="app">

    <index></index>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import Index from "@/components/index.vue";


export default {
  name: 'App',
  components: {
    Index

  }
}
</script>

<style>
#app {
  height: 100%;
}
</style>
