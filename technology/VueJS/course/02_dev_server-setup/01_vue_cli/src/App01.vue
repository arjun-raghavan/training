<template>
  <div>
    <app-servers :style="{backgroundColor: color}"></app-servers>
    <hr>
    <app-server-status v-for="server in 5" :key="server"></app-server-status>
  </div>
</template>

<script>

  import ServerStatus from './components/ServerStatus';

  export default {
    components: {
      'app-server-status': ServerStatus
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
