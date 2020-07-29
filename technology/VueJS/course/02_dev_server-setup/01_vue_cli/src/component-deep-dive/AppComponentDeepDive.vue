<template>
    <div class="container">
        <app-header></app-header>
        <hr>
        <div class="row">
            <app-servers></app-servers>
            <ServerDetails></ServerDetails>
        </div>
        <hr>
        <appFooter></appFooter>
    </div>
</template>

<script>
import Header from "./components/Header.vue";
import Footer from "./components/Footer.vue";
import ServerList from "./components/ServerList.vue";
import ServerDetails from "./components/ServerDetails.vue";

export default {
    components: {
        appHeader: Header,
        appFooter: Footer,
        'app-servers': ServerList,
        ServerDetails
    }
}

</script>

<style>

</style>
