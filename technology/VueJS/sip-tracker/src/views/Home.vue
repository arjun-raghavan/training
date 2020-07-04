<template>
  <div class="home">
    <!-- <img alt="Vue logo" src="../assets/logo.png"> -->
    <!-- <MfSummary/> -->
    <Portfolio/>
    <br/>
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue';
// import MfSummary from '@/components/MfSummary.vue';
import Portfolio from '@/components/Portfolio.vue';

export default {
  name: 'Home',
  components: {
    Portfolio,
  },
};
</script>
