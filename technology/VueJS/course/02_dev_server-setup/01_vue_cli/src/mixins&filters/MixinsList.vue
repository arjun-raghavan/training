<template>
    <div class="container">
        <div class="row">
            <div>
                <h1>Filters & Mixins</h1>
                <input v-model="filterText">
                <ul>
                    <li v-for="fruit in filteredFruits" :key="fruit">{{fruit}}</li>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
  import {fruitMixin} from "./fruitMixin";

    export default {
      mixins : [fruitMixin],
      created(){
        console.log("MixinList Component Created");
      }
    }
</script>

<style>

</style>
