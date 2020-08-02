<template>
  <div class="home">
    <p>{{ $route.query.casetype }}</p>
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    HelloWorld
  },
  created () {
    console.log('Home - Created')
    window.addEventListener('message', this.receiveMessage, false)
  },
  methods: {
    receiveMessage (event) {
      console.log('Home - receiveMessage')
      console.log(event.origin)
      console.log(event)
    }
  }
}
</script>
