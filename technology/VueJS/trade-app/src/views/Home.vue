<template>
  <div class="home">
    <!-- <img alt="Vue logo" src="../assets/logo.png"> -->
    <MfSummary/>
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue';
import MfSummary from '@/components/MfSummary.vue';

export default {
  name: 'Home',
  components: {
    HelloWorld,
    MfSummary,
  },
};
</script>
