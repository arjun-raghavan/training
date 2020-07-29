<template>
    <div class="row">
      <div class="col-12">
      <div class="card">
      <h5 class="card-header">Quote</h5>
      <div class="card-body">
        <textarea class="form-control" rows="3" v-model="quote"></textarea>
        <br>
        <button class="btn btn-primary" @click.prevent="createNew">Add Quote</button>  
      </div>
      </div>
      </div>
    </div>
</template>

<script>
    export default {
      data(){
        return {
          quote: ''
        }
      },
      methods: {
        createNew(){
          this.$emit('event-quote-add',this.quote);
          this.quote = '';
        }
      }
    }
</script>

<style>
</style>
