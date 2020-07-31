<template>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
                <h1>{{title}}</h1>
                <!-- Exercise 1) -->
                <!-- Build a local Filter which reverses the Text it is applied on -->
                <h1>{{title | reverse}}</h1>
                <!-- Exercise 2 -->
                <!-- Build a global Filter which counts the length of a word and it appends it -->
                <!-- Like this: "Test" => Gets Filtered to => "Test (4)" -->
                <h1>{{title | filter-word-count}}</h1>
                <!-- Exercise 3 -->
                <!-- Do the same as in Exercises 1 & 2, now with Computed Properties -->
                <h1>{{reversedTitle}}</h1>
                <h1>{{titleWithLength}}</h1>
                <!-- Exercise 4 -->
                <!-- Share the Computed Property rebuilding Exercise 2 via a Mixin -->
                <h1>{{titleWithLength}}</h1>
            </div>
        </div>
    </div>
</template>

<script>
    import {lengthMixin} from "./lengthMixin";

    export default {
        mixins: [lengthMixin],
        data(){
            return {
                title: 'Filters & Mixins Assignment'
            }
        },
        filters: {
            reverse(value){
                return value.split("").reverse().join("");
            }
        },
        computed: {
            reversedTitle(){
                return this.title.split("").reverse().join("");
            },
            titleWithLength(){
                return this.title + '('+this.title.length +" )"
            }
        }
    }
</script>

<style>
</style>
