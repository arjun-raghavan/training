<template>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
                <h1>Filters & Mixins</h1>
                <p>{{text | filterToUppercase | filter-to-lowercase}}</p>
                <p>Filters can be a good choice but sometimes computed properties are better choice </p>
                <input v-model="filterText">
                <ul>
                    <li v-for="fruit in filteredFruits" :key="fruit">{{fruit}}</li>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        data(){
            return {
                text: 'hello',
                filterText:'',
                fruits: ['apple', 'banana', 'mango', 'melon']
            }
        },
        filters: {
            filterToUppercase(value){
                return value.toUpperCase();
            }
        },
        computed: {
            filteredFruits(){
                return this.fruits.filter((element) => {
                    return element.match(this.filterText);
                })
            }
        }
    }
</script>

<style>

</style>
