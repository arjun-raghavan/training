<template>
  <div>
    <table id="investments">
    <tr>
    <th>SIP Date</th>
    <th>Max Value</th>
    <th>Max Returns</th>
    <th>Lowest Value</th>
    <th>Lowest Returns</th>
    <th>Current Value</th>
    <th>Current Returns</th>
    <th>Profit / loss</th>
    <th>Invested Value</th>
    </tr>
    <tr v-for="entry in data" :key="entry">
    <td>{{entry.investedDate}}</td>
    <td>{{maxValue(entry)}}</td>
    <td>{{entry.maxReturns}}</td>
    <td>{{entry.lowValue}}</td>
    <td>{{entry.lowReturns}}</td>
    <td>{{currentValue(entry)}}</td>
    <td>{{currentReturns(entry)}}</td>
    <td>{{profit(entry)}}</td>
    <td>{{entry.investedValue}}</td>
    </tr>
    </table>
    <br>
  </div>
</template>

<script>
// import { csvToJson } from 'convert-csv-to-json';

export default {
  data() {
    return {
      counter: 0,
      persons: [{ name: 'Max', age: 27, color: 'red' },
        { name: 'Anna', age: 'unknown', color: 'blue' },
      ],
      data: [
        {
          investedDate: '01-06-2019',
          investedNav: 23.9,
          investedValue: 2390,
          maxNav: 25.0,
          maxNavDate: '01-03-2020',
          maxValue: 2500,
          maxReturns: '10%',
          lowNav: 20.0,
          lowNavDate: '01-12-2019',
          lowValue: 2000,
          lowReturns: '10%',
          units: 100,
          currentNav: 24,
        },
        {
          investedDate: '01-06-2019',
          investedNav: 23.9,
          investedValue: 2390,
          maxNav: 25.0,
          maxNavDate: '01-03-2020',
          maxValue: 2500,
          maxReturns: '10%',
          lowNav: 20.0,
          lowNavDate: '01-12-2019',
          lowValue: 2000,
          lowReturns: '10%',
          units: 100,
          currentNav: 24,
        },
        {
          investedDate: '01-06-2019',
          investedNav: 23.9,
          investedValue: 2390,
          maxNav: 25.0,
          maxNavDate: '01-03-2020',
          maxValue: 2500,
          maxReturns: '10%',
          lowNav: 20.0,
          lowNavDate: '01-12-2019',
          lowValue: 2000,
          lowReturns: '10%',
          units: 100,
          currentNav: 30,
        },
      ],
    };
  },
  methods: {
    onFileChange(e) {
      const files = e.target.files || e.dataTransfer.files;
      if (!files.length) { return; }
      // this.printContentsOfFile(files[0]);
      console.log(files[0]);
      // const json = csvToJson.getJsonFromCsv(files[0]);
      // console.log(json);
    },
    printContentsOfFile(file) {
      const promise = new Promise((resolve) => {
        const reader = new FileReader();
        const vm = this;
        reader.onload = (e) => {
          console.log(e);
          resolve((vm.fileinput = reader.result));
        };
        reader.readAsText(file);
      });

      promise.then(
        (result) => {
          /* handle a successful result */
          console.log(result);
          console.log(this.fileinput);
        },
        (error) => {
          /* handle an error */
          console.log(error);
        },
      );
    },
    currentValue(entry) {
      return entry.units * entry.currentNav;
    },
    maxValue(entry) {
      return entry.units * entry.maxNav;
    },
    profit(entry) {
      return (entry.units * entry.currentNav) - entry.investedValue;
    },
    currentReturns(entry) {
      const currentValue = entry.units * entry.currentNav;
      const currentDate = new Date();
      const date1 = entry.investedDate.split('-');
      const newDate = `${date1[1]}/${date1[0]}/${date1[2]}`;
      const investedDate = new Date(newDate);
      const numberOfMonths = this.monthsDiff(investedDate, currentDate);
      const cagr = (((currentValue / entry.investedValue) ** (12 / numberOfMonths))) - 1;
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

<!-- Add "scoped" attribute to limit CSS to this component only -->
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
