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
                <p v-local-highlight:background="'green'">Argument passed to directive</p>
                <p v-local-highlight="'green'">No Argument passed to directive</p>
                <p v-local-highlight:background.delayed="'green'">Modifier example along with arguments</p>
                <p v-local-highlight.delayed="'green'">Modifier example</p>
                <p v-local-highlight:background.delayed.blink="'green'">Modifier example along with arguments</p>
                <p v-local-highlight.delayed.blink="'green'">Modifier example</p>
                <p v-local-highlight-multi:background.delayed.blink="{mainColor: 'cyan', secondColor: 'violet', delay:500}">Multiple values passed - With Argument</p>
                <p v-local-highlight-multi.delayed.blink="{mainColor: 'cyan', secondColor: 'violet', delay:500}">Multiple values passed - Without Argument</p>
            </div>
        </div>
        <hr>
    </div>
</template>

<script>
    export default {
        directives: {
            'local-highlight':{
                bind(el, binding){
                    var delay = 0;
                    if(binding.modifiers['delayed']){
                        delay = 3000;
                    }

                    if(binding.modifiers['blink']){
                        let mainColor = binding.value;
                        let secondColor = 'yellow';
                        let currentColor = mainColor;
                        setTimeout(() => {
                            setInterval(() => {
                                currentColor == secondColor ? currentColor = mainColor : currentColor = secondColor
                                if(binding.arg == 'background'){
                                    el.style.backgroundColor = currentColor;
                                }else{
                                    el.style.color = currentColor;
                                }

                            }, 1000);
                        }, delay); 
                    }else{
                       setTimeout(() => {
                            if(binding.arg == 'background'){
                                el.style.backgroundColor = binding.value;
                            }else{
                                el.style.color = binding.value;
                            }
                        }, delay); 
                    }

                    
                }  
            },
            'local-highlight-multi':{
                bind(el, binding){
                    var delay = 0;
                    if(binding.modifiers['delayed']){
                        delay = 3000;
                    }

                    if(binding.modifiers['blink']){
                        let mainColor = binding.value.mainColor;
                        let secondColor = binding.value.secondColor;
                        let currentColor = mainColor;
                        setTimeout(() => {
                            setInterval(() => {
                                currentColor == secondColor ? currentColor = mainColor : currentColor = secondColor
                                if(binding.arg == 'background'){
                                    el.style.backgroundColor = currentColor;
                                }else{
                                    el.style.color = currentColor;
                                }

                            }, binding.value.delay);
                        }, delay); 
                    }else{
                       setTimeout(() => {
                            if(binding.arg == 'background'){
                                el.style.backgroundColor = binding.value.mainColor;
                            }else{
                                el.style.color = binding.value.secondColor;
                            }
                        }, delay); 
                    }
                }  
            }
        }
    }
</script>

<style>

</style>
