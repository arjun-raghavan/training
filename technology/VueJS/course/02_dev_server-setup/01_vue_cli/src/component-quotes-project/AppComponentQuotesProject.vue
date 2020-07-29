<template>
    <div class="container">
      <app-header :quoteCount="quotes.length" :maxQuotes="maxQuotes"></app-header>
      <br>
      <app-new-quote @event-quote-add="newQuote"></app-new-quote>
      <br>
      <app-quote-grid :quotes="quotes" @event-delete-quote="deleteQuote"></app-quote-grid>
      <br>
      <div class="row">
        <div class="col-sm-12 text-center" @click="test"> 
          <div class="alert alert-info">Info: click on a quote to delete</div>
        </div>
      </div>
    </div>
</template>

<script>
    import QuoteGrid from "./components/QuoteGrid";
    import NewQuote from "./components/NewQuote";
    import QuoteHeader from "./components/QuoteHeader";
    

    export default {
      data(){
        return {
          quotes: ['first quote'],
          maxQuotes: 10
        }
      },
      components: {
        appQuoteGrid: QuoteGrid,
        appNewQuote: NewQuote,
        appHeader: QuoteHeader
      },
      methods:{
        newQuote(quote){
          if(this.quotes.length >= this.maxQuotes){
            return alert("Please delete quotes first");
          }

          this.quotes.push(quote);
        },
        deleteQuote(index){
          
          this.quotes.splice(index,1);
        },
        test(){
          console.log("clicked");
        }
      }        
    }
</script>

<style>
</style>
