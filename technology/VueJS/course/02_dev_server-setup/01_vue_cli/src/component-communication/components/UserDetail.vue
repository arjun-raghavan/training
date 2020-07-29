<template>
    <div class="component">
        <h3>You may view the User Details here</h3>
        <p>Many Details</p>
        <p>User Name: {{ name }}</p>
        <p>Reversed Name: {{ reverseName() }}</p>
        <button @click="resetName">Reset my name</button>
    </div>
</template>

<script>
    export default{
        props: {
            // name: String
            // name: [String, Array]
            name: {
                type: String,
                required: true
                // default: 'Test' // provide default is required is not true
            }
        },
        methods: {
            reverseName(){
                return this.name.split("").reverse().join("");
            },
            resetName(){
                // this.name = "John Wick"; //mutating the prop
                this.$emit('event-name-reset', "John Wick");
            }
        }     
    }
</script>

<style scoped>
    div {
        background-color: lightcoral !important;
    }
</style>
