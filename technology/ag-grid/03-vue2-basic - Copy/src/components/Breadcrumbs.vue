<template>
  <nav aria-label="breadcrumb">
    <!-- <ol class="breadcrumb">
    <li class="breadcrumb-item"><router-link to="/overview">Overview</router-link></li>
    <li class="breadcrumb-item"><router-link to="/details">Details</router-link></li>
  </ol> -->

     <b-breadcrumb>
      <b-breadcrumb-item
        to="/overview"
        active-class="active"
        v-b-tooltip.hover
        title="Summary View Of Exceptions"
        >Overview</b-breadcrumb-item
      >
      <b-breadcrumb-item
        to="/details"
        active-class="active"
        v-b-tooltip.hover
        title="Details View Of Exceptions"
        >Details</b-breadcrumb-item
      >
    </b-breadcrumb>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      items: [
        {
          text: "Overview",
          to: { name: "overview" },
        },
        {
          text: "Details",
          to: { name: "details" },
        },
      ],
    };
  },
};
</script>

<style scoped lang="scss">
// h3 {
//   margin: 40px 0 0;
// }
// ul {
//   list-style-type: none;
//   padding: 0;
// }
// li {
//   display: inline-block;
//   margin: 0 10px;
// }
// a {
//   color: #42b983;
// }
</style>