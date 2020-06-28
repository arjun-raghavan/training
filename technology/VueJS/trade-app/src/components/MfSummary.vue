<template>
  <div>
    <table id="investments">
    <tr>
    <th>Folio No</th>
    <th>Name of fund</th>
    <th>Total Units</th>
    <th>Current Nav</th>
    <th>Current Value</th>
    <th>Invested Value</th>
    <th>Profit</th>
    <th>XIRR</th>
    </tr>
    <tr v-for="fund in funds" :key="fund">
    <td>{{fund.folio}}</td>
    <td>{{fund.name}}</td>
    <td>{{fund.units}}</td>
    <td>{{fund.nav}}</td>
    <td>{{currentValue(fund)}}</td>
    <td>{{fund.investment}}</td>
    <td>{{profit(fund)}}</td>
    <td>{{XIRR(fund)}}</td>
    </tr>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      funds: [
        {
          folio: '2627332284',
          name: 'Canara Robeco Emerging Equities Fund',
          units: 2838.866,
          nav: 95.47,
          investment: 200000,
        }, {
          folio: '3477342',
          name: 'DSP Small Cap Fund',
          units: 2835.102,
          nav: 51.911,
          investment: 200000,
        }, {
          folio: '27264111',
          name: 'Franklin India Samller Companies Fund',
          units: 4467.219,
          nav: 43.8652,
          investment: 200000,
        }, {
          folio: '3477342',
          name: 'Mirae Asset Emerging Bluechip Fund',
          units: 2922.48,
          nav: 55.816,
          investment: 200000,
        }, {
          folio: '67851847',
          name: 'Principal Emerging Bluechip Fund',
          units: 962.287,
          nav: 103.65,
          investment: 200000,
        }, {
          folio: '603217690185',
          name: 'UTI Banking Fund',
          units: 2558.959,
          nav: 74.26,
          investment: 200000,
        },
      ],
    };
  },
  methods: {
    convertToFixedDecimal(value) {
      return Number(value.toFixed(2));
    },
    currentValue(fund) {
      return this.convertToFixedDecimal(fund.units * fund.nav);
    },
    profit(fund) {
      console.log(fund);
      return this.convertToFixedDecimal((fund.units * fund.nav) - fund.investment);
    },
    XIRR(fund) {
      return `${this.convertToFixedDecimal((this.profit(fund) / fund.investment) * 100)} %`;
    },
  },
};

</script>
<style scoped>
#investments {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#investments td, #investments th {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

#investments tr:nth-child(even){background-color: #f2f2f2;}

#investments tr:hover {background-color: #ddd;}

#investments th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
