<template>
    <div>
       <h3>New Quote</h3>
       <button @click="counter++">Click: {{ counter }}</button>
    </div>
</template>

<script>
    export default {
      data: function(){
        return {
          counter: 0
        }
      },
      created(){
        console.log("new quote component created");
      },
      destroyed(){
        console.log("new quote component destroyed");
      },
      deactivated(){
        console.log("new quote component deactivated");
      },
      activated(){
        console.log("new quote component activated");
      }        
    }
</script>

<style scoped>
  div {
    border: 1px solid #ccc;
    box-shadow: 1px 1px 2px black;
    padding: 30px;
    margin: 30px auto;
    text-align: center;
  }
</style>
