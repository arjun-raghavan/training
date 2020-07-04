<template>
  <div id="fund" class="row col-sm-12">
    <Card v-for="fund in nav" :key="fund.name" :fundnav="fund"></Card>
  </div>

</template>

<script>

import Card from '@/components/Card.vue';

export default {
  data() {
    return {
      test: 12,
    };
  },
  components: {
    Card,
  },
  computed: {
    nav() {
      return this.$store.getters.navHistory;
    },
  },
};
</script>

<style scoped>
</style>
