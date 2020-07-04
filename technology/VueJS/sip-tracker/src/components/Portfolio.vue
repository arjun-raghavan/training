<template>
<div class="row">
  <div class="page-header">
    <h1>Portfolio</h1>
  </div>
  <div class="alert alert-success" role="alert">Summary</div>
  <div class="panel panel-default">
    <table id="portfolio">
      <tr>
      <th>Folio No</th>
      <th>Name of fund</th>
      <th>Total Units</th>
      <th>Current Nav</th>
      <th>Invested Value</th>
      <th>Current Value</th>
      <th>Profit</th>
      <th>XIRR</th>
      </tr>
      <tr v-for="fund in portfolio" :key="fund.name">
      <td>{{fund.folio}}</td>
      <td>{{fund.name}}</td>
      <td>{{fund.units}}</td>
      <td>{{currentNav(fund)}}</td>
      <td>{{fund.investment}}</td>
      <td>{{currentValue(fund)}}</td>
      <td>{{profit(fund)}}</td>
      <td>{{XIRR(fund)}}</td>
      </tr>
    </table>
  </div>
  <Fund/>
</div>
</template>

<script>
import Fund from '@/components/Fund.vue';

export default {
  data() {
    return {};
  },
  components: {
    Fund,
  },
  computed: {
    portfolio() {
      return this.$store.getters.myPortfolio;
    },
    nav() {
      return this.$store.getters.navHistory;
    },
  },
  methods: {
    convertToFixedDecimal(value) {
      return Number(value.toFixed(2));
    },
    currentNav(fund) {
      console.log('currentNav');
      const fundNav = this.nav.find(
        (nav) => nav.name === fund.name,
      );
      if (fundNav) { return fundNav.curentNav; }
      return 0;
    },
    currentValue(fund) {
      const fundNav = this.nav.find(
        (nav) => nav.name === fund.name,
      );

      if (fundNav) {
        return this.convertToFixedDecimal(fund.units * fundNav.curentNav);
      }
      return this.convertToFixedDecimal(fund.units);
    },
    profit(fund) {
      return this.convertToFixedDecimal((fund.units * fund.nav) - fund.investment);
    },
    XIRR(fund) {
      return `${this.convertToFixedDecimal((this.profit(fund) / fund.investment) * 100)} %`;
    },
  },
};
</script>

<style scoped>
#portfolio {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#portfolio td, #portfolio th {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

#portfolio tr:nth-child(even){background-color: #f2f2f2;}

#portfolio tr:hover {background-color: #ddd;}

#portfolio th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
