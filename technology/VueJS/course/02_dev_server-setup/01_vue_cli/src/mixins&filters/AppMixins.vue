<template>
    <div class="container">
        <div class="row">
            <div>
                <h1>Filters & Mixins</h1>
                <p>{{text | filterToUppercase | filter-to-lowercase}}</p>
                <p>Filters can be a good choice but sometimes computed properties are better choice </p>
                <input v-model="filterText">
                <ul>
                    <li v-for="fruit in filteredFruits" :key="fruit">{{fruit}}</li>
                </ul>
                <hr>
                <app-mixins-list></app-mixins-list>
            </div>
        </div>
    </div>
</template>

<script>
    import MixinsList from "./MixinsList";
    import {fruitMixin} from "./fruitMixin";

    export default {
        data(){
            return {
                text: 'hello'
            }
        },
        filters: {
            filterToUppercase(value){
                return value.toUpperCase();
            }
        },
        mixins : [fruitMixin],
        components: {
          appMixinsList: MixinsList
        }
    }
</script>

<style>

</style>
