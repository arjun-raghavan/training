<template>
  <div style="justify-content: center; display: flex">
    <b-button variant="warning" @click="navigateToDetails" style="float: right"
      >View Details</b-button
    >
  </div>
</template>

<script>
export default {
  methods: {
    navigateToDetails() {
      this.$router.push("/details");
    },
  },
};
</script>
