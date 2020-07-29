<template>
    <div class="container">
      <app-quote-grid :quotes="quotes"></app-quote-grid>
    </div>
</template>

<script>
    import QuoteGrid from "./components/QuoteGrid";

    export default {
      data(){
        return {
          quotes: ['first quote'],
          maxQuotes: 10
        }
      },
      components: {
        appQuoteGrid: QuoteGrid
      }        
    }
</script>

<style>
</style>
