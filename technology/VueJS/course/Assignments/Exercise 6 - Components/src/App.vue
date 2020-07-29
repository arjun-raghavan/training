<template>
    <div class="container">
        <Header></Header>
        <hr>
        <div class="row">
            <ServerList></ServerList>
            <ServerDetails></ServerDetails>
        </div>
        <hr>
        <Footer></Footer>
    </div>
</template>

<script>
import Header from "./components/Header.vue";
import Footer from "./components/Footer.vue";
import ServerList from "./components/ServerList.vue";
import ServerDetails from "./components/ServerDetails.vue";

export default {
    components: {
        Header,
        Footer,
        ServerList,
        ServerDetails
    }
}

</script>

<style>

</style>
