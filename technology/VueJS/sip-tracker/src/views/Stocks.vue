<template>
  <div class="stocks">
    <Stock
      v-for="stock in stocks"
      :key="stock.name"
      :stock="stock"></Stock>
  </div>
</template>

<script>
import Stock from '@/components/Stock.vue';

export default {
  name: 'stocks',
  computed: {
    stocks() {
      return this.$store.getters.stocks;
    },
  },
  components: {
    Stock,
  },
};
</script>
