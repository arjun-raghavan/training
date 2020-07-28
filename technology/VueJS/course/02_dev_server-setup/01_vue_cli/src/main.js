import Vue from 'vue'
// import App from './App.vue'
import App01 from './App01.vue';
import ServerState from './components/ServerState';

Vue.component('app-server-status', ServerState);

Vue.config.productionTip = false

new Vue({
  render: h => h(App01),
}).$mount('#app')
