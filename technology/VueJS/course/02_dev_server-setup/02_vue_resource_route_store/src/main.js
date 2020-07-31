import Vue from 'vue'
// import App from './App.vue'
// import router from './router'
// import store from './store'
import VueResource from 'vue-resource'
import AppHttpVueResource from './vue-resource/AppHttpVueResource'

Vue.use(VueResource)
Vue.http.options.root = 'https://<>.firebaseio.com/'

// interceptors - array of functions
Vue.http.interceptors.push((request, next) => {
  // if (request.method === 'POST') {
  //   request.method = 'PUT'
  // }
  console.log(request)
  next(response => {
    console.log(response)
    // response.json = () => { return { messages: response.body } }
  })
})

Vue.config.productionTip = false

new Vue({
  // router,
  // store,
  render: h => h(AppHttpVueResource)
}).$mount('#app')
