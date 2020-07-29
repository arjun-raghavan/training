import Vue from 'vue'
// import App from './App.vue'
// import App01 from './App01.vue';
import ServerState from './components/ServerState';
import AppComponentDeepDive from './component-deep-dive/AppComponentDeepDive';

Vue.component('app-servers', ServerState);

Vue.config.productionTip = false

new Vue({
  render: h => h(AppComponentDeepDive),
}).$mount('#app')
