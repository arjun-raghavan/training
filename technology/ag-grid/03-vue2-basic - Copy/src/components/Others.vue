<template>
  <div>
    <button @click="computeTime">Add 1</button>
    <p>The button above has been clicked {{ counter }} times.</p>
  </div>
</template>

<script>
import { casesData } from "./data/cases-data.js";
import { cases500 } from "./data/cases-format-500.js";
import { cases1 } from "./data/cases-format-1.js";
import { transformData } from "./data/utils.js";

export default {
  name: "Others",
  data() {
    return {
      counter: 0,
    };
  },
  methods: {
    computeTime() {
      console.log(casesData.length);
      this.counter += 1;

      var startTime = Date.now();
      var newdata = transformData(cases1);
      var endTime = Date.now();

      console.log("newdata", newdata);
      console.log("Time Taken: ", endTime - startTime);

      var inpData = [...cases500, ...cases500,...cases500, ...cases500,...cases500, ...cases500,...cases500, ...cases500];
      var inpData1 = [...inpData,...inpData,...inpData,...inpData];
      const t0 = performance.now();
      transformData(inpData1);
      const t1 = performance.now();
      console.log("Transforming: ",inpData1.length);
      console.log(`Call to doSomething took ${t1 - t0} milliseconds.`);
      // console.log("newdata01", newdata01);
    },
    printCaseId(singleCase) {
      console.log(singleCase);
      console.log(Object.keys(singleCase));

      return singleCase.caseId;
    },
    sleep(milliseconds) {
      const date = Date.now();
      let currentDate = null;
      do {
        currentDate = Date.now();
      } while (currentDate - date < milliseconds);
    },
  },
};
</script>

<style lang="scss">
</style>
