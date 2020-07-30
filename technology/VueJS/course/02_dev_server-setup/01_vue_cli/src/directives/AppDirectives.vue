<template>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
                <h1>Built in Directives</h1>
                <p v-text="'Some Text'"></p>
                <p v-html="'<strong>Some Text</strong>'"></p>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
                <h1>Global Custom Directives</h1>
                <p v-highlight:background="'red'">Argument passed to directive</p>
                <p v-highlight="'red'">No Argument passed to directive</p>
                <p v-highlight:background.delayed="'red'">Modifier example along with arguments</p>
                <p v-highlight.delayed="'red'">Modifier example</p>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
                <h1>Local Directives</h1>
                <p v-text="'Some Text'"></p>
                <p v-html="'<strong>Some Text</strong>'"></p>
            </div>
        </div>
        <hr>
    </div>
</template>

<script>
    export default {
    }
</script>

<style>

</style>
