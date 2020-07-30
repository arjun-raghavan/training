<template>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
                <h1>Directives Exercise</h1>
                <!-- Exercise -->
                <!-- Build a Custom Directive which works like v-on (Listen for Events) -->
                <button class="btn btn-primary" v-custom-on-click:click="clicked">Click here</button>
                <button class="btn btn-secondary" v-generic-on:click="clicked">Click here</button>
                <button 
                    class="btn btn-warning" 
                    v-generic-on:click="clicked" 
                    v-generic-on:mouseenter="mouseEnter" 
                    v-generic-on:mouseleave="mouseLeave">Click here</button>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        directives:{
            'custom-on-click':{
                bind(el,binding){
                    if(binding.arg == 'click'){
                        console.log("arg click bind");
                        
                        el.onclick = () => {
                            console.log("in directive clicked");
                            binding.value();
                        }
                    }
                }
            },
            'generic-on':{
                bind(el,binding){
                    el.addEventListener(binding.arg, binding.value);
                }
            }
        },
        methods: {
            clicked(){
                console.log("BUTTON CLICKED");
            },
            mouseEnter(){
                console.log("mouseEnter");
            },
            mouseLeave(){
                console.log("mouseLeave");
            }
        }
    }
</script>

<style>
</style>
