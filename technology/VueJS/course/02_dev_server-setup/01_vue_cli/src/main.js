import Vue from 'vue'
// import App from './App.vue'
// import App01 from './App01.vue';
import ServerState from './components/ServerState';
// import AppComponentDeepDive from './component-deep-dive/AppComponentDeepDive';
import AppComponentCommunication from "./component-communication/AppComponentCommunication";

Vue.component('app-servers', ServerState);

Vue.config.productionTip = false

new Vue({
  render: h => h(AppComponentCommunication),
}).$mount('#app')