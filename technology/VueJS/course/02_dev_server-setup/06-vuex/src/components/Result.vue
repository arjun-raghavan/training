<template>
<div>
    
    <p>Double Counter is: {{ doubleCounter }}</p>
    <p>Clicks: {{ stringCounter }}</p>
    <p>ownComputedProp: {{ ownComputedProp }}</p>
    
</div>
</template>

<script>
    import {mapGetters} from 'vuex';

    export default {
        // props: ['counter']
        /**
        computed: {

            counter(){
                return this.$store.state.counter;
            },
            doubleCounter(){
                return this.$store.getters.doubleCounter;
            },
            stringCounter(){
                return this.$store.getters.stringCounter;
            }
        }
        **/
        /**
        computed: mapGetters([
            'doubleCounter',
            'stringCounter'
        ])
        **/
        // Adding additional computed properties
        computed: {
            ...mapGetters([
            'doubleCounter',
            'stringCounter'
            ]),
            ownComputedProp(){
                return 0;
            }
        }
    }
</script>