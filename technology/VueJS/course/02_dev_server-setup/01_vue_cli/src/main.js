import Vue from 'vue'
// import App from './App.vue'
// import App01 from './App01.vue';
import ServerState from './components/ServerState';
// import AppComponentDeepDive from './component-deep-dive/AppComponentDeepDive';
// import AppComponentCommunication from "./component-communication/AppComponentCommunication";
// import AppComponentCommunicationEventBus from "./component-communication-eventbus/AppComponentCommunicationEventBus"
// import AppComponentSlots from './component-slots/AppComponentSlots';
// import AppAssignment from './component-assignment-08/AppAssignment';
// import AppComponentQuotesProject from './component-quotes-project/AppComponentQuotesProject';
// import AppForms from "./forms/AppForms"
// import AppFormsAssignment from "./forms/AppFormsAssignment"
import AppDirectives from "./directives/AppDirectives"


export const serverBus = new Vue();
export const eventBus = new Vue({
  data:{
  // can be accessed from all over application
  },
  methods: {
    changeAge(age){
      this.$emit('event-age-edit', age)
    }
  }
});
Vue.component('app-servers', ServerState);
Vue.directive('highlight',{
  bind(el, binding){
    // el.style.backgroundColor = 'green'
    // el.style.backgroundColor = binding.value

    var delay = 0;
    if(binding.modifiers['delayed']){
      delay = 3000;
    }

    setTimeout(() => {
      if(binding.arg == 'background'){
        el.style.backgroundColor = binding.value;
      }else{
        el.style.color = binding.value;
      }
    }, delay);

    
  }  
});//usage : v-highlight

Vue.config.productionTip = false

new Vue({
  render: h => h(AppDirectives),
}).$mount('#app')



