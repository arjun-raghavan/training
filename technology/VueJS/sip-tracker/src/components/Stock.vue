<template>
  <div class="row">
    <br>
    <StockSummaryCard :stock="stock"></StockSummaryCard>
    <!-- DETAILS -->
    <div class="panel panel-default">
      <table id="portfolio">
        <tr>
        <th>Date</th>
        <th>Quantity</th>
        <th>Invested Price</th>
        <th>Current Price</th>
        <th>LTCG</th>
        <th>STCG</th>
        <th>%</th>
        </tr>
        <tr v-for="(investment, index) in computedStock.investments" :key="index">
        <td>{{investment.date}}</td>
        <td>{{investment.qty}}</td>
        <td>{{investment.price}}</td>
        <td>{{stock.currentPrice}}</td>
        <td :class="{ loss: investment.ltcg < 0, gain: investment.ltcg > 0 }">
          {{investment.ltcg | filterToFixed }}
        </td>
        <td :class="{ loss: investment.stcg < 0, gain: investment.stcg > 0 }">
          {{investment.stcg | filterToFixed}}
        </td>
        <td>{{returns(investment, computedStock)}}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import StockSummaryCard from './StockSummaryCard.vue';

export default {
  props: ['stock'],
  data() {
    return {
    };
  },
  computed: {
    computedStock() {
      const localInvestments = this.stock.investments.map((item) => {
        const lCapitalGains = { ltcg: this.ltcg(item, this.stock) };
        const sCapitalGains = { stcg: this.stcg(item, this.stock) };
        return { ...item, ...lCapitalGains, ...sCapitalGains };
      });
      const computedProps = { ...this.stock, investments: localInvestments };
      return computedProps;
    },
    investedValue() {
      // console.log(this.computedStock.investments);
      return this.computedStock.totalQuantity * this.averageInvestment;
    },
    currentValue() {
      return this.computedStock.totalQuantity * this.computedStock.currentPrice;
    },
    ltcgSummay() {
      let totalLtcg = 0;
      this.computedStock.investments.forEach(
        (element) => {
          totalLtcg += element.ltcg;
        },
      );
      return totalLtcg;
    },
    stcgSummary() {
      let totalStcg = 0;
      this.computedStock.investments.forEach(
        (element) => { totalStcg += element.stcg; },
      );
      return totalStcg;
    },
    profitLoss() {
      return this.currentValue - this.investedValue;
    },
    averageInvestment() {
      let averageValue = 0;
      let count = 0;
      this.computedStock.investments.forEach((element) => {
        averageValue = (averageValue * count + (element.qty * element.price))
                        / (count + element.qty);
        count += element.qty;
      });

      return averageValue;
    },
  },
  filters: {
    filterToFixed(value) {
      return value.toFixed(2);
    },
    fitlerToCaps(value) {
      return value.toUpperCase();
    },
  },
  methods: {
    profit(investment, stock) {
      return ((stock.currentPrice - investment.price) * investment.qty);
    },
    ltcg(investment, stock) {
      const numberOfMonths = this.differenceBetweenMonths(stock.currentDate, investment.date);
      if (numberOfMonths < 12) {
        return 0;
      }
      return this.profit(investment, stock);
    },
    stcg(investment, stock) {
      const numberOfMonths = this.differenceBetweenMonths(stock.currentDate, investment.date);
      if (numberOfMonths >= 12) {
        return 0;
      }
      return ((stock.currentPrice - investment.price) * investment.qty);
    },
    dateObject(dateStr) {
      const currentDateArr = dateStr.split('-');
      const currentDateStr = `${currentDateArr[1]}/${currentDateArr[0]}/${currentDateArr[2]}`;
      return new Date(currentDateStr);
    },
    differenceBetweenMonths(currDateStr, investmentDateStr) {
      const currentDate = this.dateObject(currDateStr);
      const investedDate = this.dateObject(investmentDateStr);
      return this.monthsDiff(investedDate, currentDate);
    },
    returns(investment, stock) {
      const currentValue = investment.qty * stock.currentPrice;
      const investedValue = investment.qty * investment.price;
      const numberOfMonths = this.differenceBetweenMonths(stock.currentDate, investment.date);
      if (numberOfMonths < 12) {
        return `${(((stock.currentPrice - investment.price) / investment.price) * 100).toFixed(2)}%`;
      }
      const cagr = (((currentValue / investedValue) ** (12 / numberOfMonths))) - 1;
      return `${(cagr * 100).toFixed(2)} %`;
    },
    monthsDiff(d1, d2) {
      const date1 = new Date(d1);
      const date2 = new Date(d2);
      const years = this.yearsDiff(d1, d2);
      const months = (years * 12) + (date2.getMonth() - date1.getMonth());
      return months;
    },
    yearsDiff(d1, d2) {
      const date1 = new Date(d1);
      const date2 = new Date(d2);
      const yearsDiff = date2.getFullYear() - date1.getFullYear();
      return yearsDiff;
    },
  },
  components: {
    StockSummaryCard,
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

#portfolio td.error {
  border: 1px solid red;
  background-color: #ffc9ae;
}

#portfolio tr:nth-child(even){background-color: #f2f2f2;}

#portfolio tr:hover {background-color: #ddd;}

#portfolio th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #02010e;
  color: white;
}

.loss{
  border: 1px solid red;
  background-color: #ffc9ae;
}

.gain{
  border: 1px solid greenyellow;
  background-color: rgb(123, 207, 40);
}

.card {
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  padding: 10px;
}

.title{
  font-weight: bold;
}
</style>
