<template>
    <div class="component">
        <h3>You may edit the User here</h3>
        <p>Edit me!</p>
        <p>User Age: {{ userAge }}</p>
        <button @click="editAge">Edit Age</button>
    </div>
</template>

<script>
    import {eventBus} from "../../main";

    export default{
        props: ['userAge'],
        methods: {
            editAge(){
                // this.userAge = 20; this will change only locally. donot mutate the props
                // this.$emit('event-age-edit', 20);
                eventBus.$emit('event-age-edit', 20)
            }
        }
    }
</script>

<style scoped>
    div {
        background-color: lightgreen !important;
    }
</style>
