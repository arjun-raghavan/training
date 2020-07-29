<template>
    <div class="row">
      <app-quote v-for="quote in quotes" :key="quote">
        <h2>quote</h2>
      </app-quote>
    </div>
</template>

<script>
    import Quote from "./QuoteView";

    export default {
      props: ['quotes'],
      components:{
        appQuote: Quote
      }
    }
</script>

<style>
</style>
