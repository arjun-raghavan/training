<template>
  <div class="about row">
  <div class="page-header">
    <h1>Settings</h1>
  </div>
  <div class="alert alert-success" role="alert">Supported Funds</div>
  <div class="panel panel-default">
    <ul class="list-group">
    <li class="list-group-item" v-for="name in funds" :key="name"> {{name}}</li>
    </ul>
  </div>
  </div>
</template>

<script>
export default {
  computed: {
    funds() {
      return this.$store.getters.supportedFunds;
    },
  },
};
</script>
