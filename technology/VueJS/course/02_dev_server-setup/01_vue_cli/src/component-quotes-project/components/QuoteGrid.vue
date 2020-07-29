<template>
    <div class="row">
      <app-quote v-for="(quote, index) in quotes" :key="quote" @click.native="deleteQuote(index)">
        {{quote}}
      </app-quote>
    </div>
</template>

<script>
    import Quote from "./QuoteView";

    export default {
      props: ['quotes'],
      components:{
        appQuote: Quote
      },
      methods: {
        deleteQuote(index){
          console.log("quote to be delete "+index);
          this.$emit('event-delete-quote',index)
        }
      }
    }
</script>

<style>
</style>
