<template>
  <v-app-bar
      app
      color="black"
      dark
    >
      <div class="d-flex align-center">
        <v-img
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="/white-nike-logo.png"
          transition="scale-transition"
          width="40"
        />

      </div>
      <v-toolbar-title>NIKE ORDER WORKSPACE</v-toolbar-title>
      <v-spacer></v-spacer>

      <!-- <v-btn
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank"
        text
      >
        <span class="mr-2">Latest Release</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn> -->
    </v-app-bar>
</template>

<script>
  export default {
    name: 'Header',

    data: () => ({}),
  }
</script>
