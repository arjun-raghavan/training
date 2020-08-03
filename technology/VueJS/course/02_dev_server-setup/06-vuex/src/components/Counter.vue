<template>
<div>
    <div>
        <button class="btn btn-primary" @click="increment(100)">Increment</button>
        <button class="btn btn-primary" @click="decrement(100)">Decrement</button>
    </div>
    <div>
        <button class="btn btn-success" @click="asyncIncrement({by: 50, duration: 500})">Increment</button>
        <button class="btn btn-success" @click="asyncDecrement({by: 50, duration: 500})">Decrement</button>
    </div>
</div>
</template>

<script>
    //import {mapMutations} from 'vuex';
    import {mapActions} from 'vuex';

    export default {
        /*Without mapMutations
        methods: {
            increment() {
                // this.$emit('updated', 1);
                // this.$store.state.counter++;
                this.$store.commit('increment');
            },
            decrement() {
                // this.$emit('updated', -1);
                // this.$store.state.counter--;
                this.$store.commit('decrement');
            }
        }
        */
        /* using mapMutations
        methods: {
            ...mapMutations([
                'increment',
                'decrement'
            ]),
            ownMethod(){
                return "ownMethod";
            }
        }
        */
        //mapActions
        //What mapActions does
        // increment() { this.$store.dispatch('increment)} 
        methods: {
            ...mapActions([
                'increment',
                'decrement',
                'asyncIncrement',
                'asyncDecrement'
            ]),
            ownMethod(){
                return "ownMethod";
            }

        }
        
    }
</script>