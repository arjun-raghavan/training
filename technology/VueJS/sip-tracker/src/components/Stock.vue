<template>
  <div class="row">
    <br>
    <div class="panel panel-default">
      <!-- SUMMARY -->
      <div class="panel-heading title">{{stock.name | fitlerToCaps}}</div>
      <div class="panel-body">
        <table>
          <td class="card">
            <label for="qty">Qty</label>
            <br>
            <span class="label label-default">{{stock.totalQuantity}}</span>
          </td>
          <td class="card">
            <label for="qty">Average Price</label>
            <br>
            <span class="label label-default">{{averageInvestment | filterToFixed}}</span>
          </td>
            <td class="card">
            <label>Invested Value</label>
            <br>
            <span class="label label-default">{{investedValue | filterToFixed}}</span>
          </td>
          <td class="card">
            <label>Current Value</label>
            <br>
            <span class="label label-default">{{currentValue| filterToFixed}}</span>
          </td>
          <td class="card">
            <label>Profit</label>
            <br>
            <span class="label label-default">{{profitLoss | filterToFixed}}</span>
          </td>
        </table>
      </div>
    </div>
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
        <tr v-for="(investment, index) in stock.investments" :key="index">
        <td>{{investment.date}}</td>
        <td>{{investment.qty}}</td>
        <td>{{investment.price}}</td>
        <td>{{stock.currentPrice}}</td>
        <td :class="{loss: ltcg(investment, stock) < 0, gain: ltcg(investment, stock) > 0 }">
          {{ltcg(investment, stock)}}
        </td>
        <td :class="{loss: stcg(investment, stock) >= 0 ? false : true,
                      gain: stcg(investment, stock) > 0 ? true : false}">
          {{stcg(investment, stock)}}
        </td>
        <td>{{returns(investment, stock)}}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>

export default {
  props: ['stock'],
  data() {
    return {
    };
  },
  computed: {
    localStocks() {
      return this.stock;
    },
    investedValue() {
      return this.stock.totalQuantity * this.averageInvestment;
    },
    currentValue() {
      return this.stock.totalQuantity * this.stock.currentPrice;
    },
    profitLoss() {
      return this.currentValue - this.investedValue;
    },
    averageInvestment() {
      let averageValue = 0;
      let count = 0;
      this.localStocks.investments.forEach((element) => {
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
      return ((stock.currentPrice - investment.price) * investment.qty).toFixed(2);
    },
    ltcg(investment, stock) {
      const numberOfMonths = this.differenceBetweenMonths(stock.currentDate, investment.date);
      if (numberOfMonths < 12) {
        return '0';
      }
      return this.profit(investment, stock);
    },
    stcg(investment, stock) {
      const numberOfMonths = this.differenceBetweenMonths(stock.currentDate, investment.date);
      if (numberOfMonths >= 12) {
        return '0';
      }
      console.log((numberOfMonths));
      return ((stock.currentPrice - investment.price) * investment.qty).toFixed(2);
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
  background-color: #4CAF50;
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
