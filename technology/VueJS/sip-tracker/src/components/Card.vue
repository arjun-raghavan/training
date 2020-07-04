<template>
  <div class="col-sm-6 col-md-4">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">
                    {{fundnav.name}}
                </h3>
            </div>
            <div class="panel-body">
              <input
                      type="date"
                      class="form-control"
                      v-model="date"
              >
              <br>
              <input
                      type="number"
                      class="form-control"
                      placeholder="NAV"
                      v-model="nav"
              >
              <small>(₹{{ fundnav.curentNav }} on {{fundnav.currentDate}})</small>
              <br>
              <div class="pull-right">
                    <button class="btn btn-info" @click="updateNav">Update</button>
              </div>
            </div>
        </div>
    </div>
</template>

<script>

export default {
  props: ['fundnav'],
  data() {
    return {
      nav: 0,
      date: {},
    };
  },
  methods: {
    updateNav() {
      console.log(this.date);
      const date1 = this.date.split('-');
      const newDate = `${date1[2]}-${date1[1]}-${date1[0]}`;
      console.log(newDate);

      const payload = {
        name: this.fundnav.name,
        nav: this.nav,
        date: newDate,
      };
      console.log(payload);
      this.$store.commit('addNav', payload);
    },
  },
};
</script>

<style scoped>
</style>
