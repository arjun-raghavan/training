<template>
  <div>
    <app-server-status :style="{backgroundColor: color}"></app-server-status>
    <hr>
    <Comp/>
  </div>
</template>

<script>

  import Comp from './components/ServerState';

  export default {
    components: {
      Comp
    },
    data(){
      return {
        status : "Critical",
        color: 'gray'
      }
    }
  }
</script>

<style>
</style>
