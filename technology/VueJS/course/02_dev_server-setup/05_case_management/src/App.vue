<template>
  <v-app>
    
    <Header></Header>
    <v-main>
      <!-- <HelloWorld/> -->
      <div>
      <v-toolbar flat>
      <v-btn icon @click="navigateBack">
        <v-icon>mdi-arrow-left</v-icon>
      </v-btn>
      <!-- <v-breadcrumbs :items="navs" style="color:black"></v-breadcrumbs> -->

      <v-breadcrumbs :items="navs">
          <template v-slot:item="{ item }">
            <v-breadcrumbs-item id="bitem"
              :disabled="item.disabled"
            >
              {{ item.text }}
            </v-breadcrumbs-item>
          </template>
        </v-breadcrumbs>

      </v-toolbar>
      </div>
      <p></p>
      <div>
        <v-card
    class="mx-auto"
    max-width="344"
    outlined
  >
    <v-list-item three-line>
      <v-list-item-content>
        <div class="overline mb-4">Case Type Count</div>
        <v-list-item-title class="headline mb-1">{{ $route.query.casetype }}</v-list-item-title>
      </v-list-item-content>
    </v-list-item>

  </v-card>
      </div>
      <br>
      <hr>
      <button @click="showHistory" class="btn btn-secondary">Show History</button>
    </v-main>
    <v-footer app>
    Case Management © Nike
    </v-footer>
  </v-app>
</template>

<script>
 import Header from './components/Header';
 
export default {
  name: 'App',

  components: {
    Header
  },
  data: () => ({
    navs: [
      {
        text: 'Case Management',
        disabled: false

      },
      {
        text: 'Case Overview',
        disabled: false
      }
      // { text:'dashboard',disabled:false, to:{name: 'dashboard'}, exact: true }
    ],
    port: 8080
  }),
  methods: {
    navigateBack(){
      console.log("navigateBack");
      console.log(window.history.go(-1));
    },
    showHistory(){
      console.log("showHistory");
      console.log(window);
    }
  }
};
</script>

<style scoped>
#bitem {
    cursor: pointer;
  }
</style>
