<template>
  <div>
    <Column
      ><Card :carddata="myCard" v-for="(myCard, index) in cards" :key="index"
    /></Column>
    <Column />
    <Column />
    <Column
      style="
        justify-content: spac e-between;
        flex-direction: column;
        display: flex;
      "
      ><component :is="child_component"></component
    ></Column>
    <!-- <b-button variant="warning" @click="navigateToDetails" style="float: right"
      >View Details</b-button
    > -->
  </div>
</template>

<script>
import Column from "./Column";
import Card from "./Card";
import ButtonNavigateToL2 from "./ButtonNavigateToL2";
import { L1Cases1056 } from "./data/cases-data-L1";
import { L1Cases2 } from "./data/cases-data-L1-2";
import { groupbyvalue } from "./data/groupbyvalue.js";

export default {
  data() {
    return { child_component: "ButtonNavigateToL2" };
  },
  components: {
    Column,
    Card,
    ButtonNavigateToL2,
  },
  methods: {
    navigateToDetails() {
      this.$router.push("/details");
    },
  },
  computed: {
    cards() {
      //console.log(L1Cases1056);
      //Iterate to JSON object
      //Group the values based on caseType & wrongful value
      console.log("groupbyvalue", groupbyvalue(L1Cases2));
      return L1Cases1056;
    },
  },
};
</script>
