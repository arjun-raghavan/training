<template>
  <div>
    <Column />
    <Column />
    <Column />
    <Column
      style="
        justify-content: space-between;
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
import ButtonNavigateToL2 from "./ButtonNavigateToL2";

export default {
  data() {
    return { child_component: "ButtonNavigateToL2" };
  },
  components: {
    Column,
    ButtonNavigateToL2,
  },
  methods: {
    navigateToDetails() {
      this.$router.push("/details");
    },
  },
};
</script>
