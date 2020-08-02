<template>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
                <h1>Routing</h1>
                <button class="btn btn-dark" @click="launchCaseManagement">Case Management</button>
                <hr>
                <!-- <app-header></app-header> -->
                <router-view name="header-top"></router-view>
                <transition name="slide" mode="out-in">
                    <router-view></router-view>
                </transition>
                <router-view name="header-bottom"></router-view>
            </div>
        </div>
    </div>
</template>

<script>
    import Header from "./components/Header.vue";

    export default {
        components: {
            appHeader: Header
        },
        methods: {
            launchCaseManagement(){
                console.log("launchCaseManagement : http://example.com:8082?casetype=10");
                this.setCookie("username","arjun-raghavan", 2);
                window.location.href = 'http://example.com:8082?casetype=10';
                // var state = {
                //     localkey: "key-value"
                // };
                // var title = "CM";
                // var url   = "http://example.com:8082?casetype=10";

                // history.pushState(state, title, url);
            },
            setCookie(cname, cvalue, exdays) {
                var d = new Date();
                d.setTime(d.getTime() + (exdays*24*60*60*1000));
                var expires = "expires="+ d.toUTCString();
                document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
            },
            checkCookie(){
                var user = this.getCookie("username");
                if (user != "") {
                    alert("Welcome again " + user);
                } else {
                    // user = prompt("Please enter your name:", "");
                    // if (user != "" && user != null) {
                    // this.setCookie("username", user, 365);
                    // }
                    console.log("cookie not set");
                }
            },
            getCookie(cname) {
                var name = cname + "=";
                var decodedCookie = decodeURIComponent(document.cookie);
                var ca = decodedCookie.split(';');
                for(var i = 0; i < ca.length; i++) {
                    var c = ca[i];
                    while (c.charAt(0) == ' ') {
                    c = c.substring(1);
                    }
                    if (c.indexOf(name) == 0) {
                    return c.substring(name.length, c.length);
                    }
                }
                return "";
                }
        },
        mounted(){
            console.log("--App.Vue--mounted--");
            console.log(window.history);
            this.checkCookie();
            console.log("--App.Vue--mounted--");
        },
        beforeDestroy(){
            console.log("--App.Vue--beforeDestroy--");
            console.log(window.history);
            console.log("--App.Vue--beforeDestroy--");
        }
    }
</script>

<style>
    .slide-leave-active {
        transition: opacity 1s ease;
        opacity: 0;
        animation: slide-out 1s ease-out forwards;
    }

    .slide-leave {
        opacity: 1;
        transform: translateX(0);
    }

    .slide-enter-active {
        animation: slide-in 1s ease-out forwards;
    }

    @keyframes slide-out {
        0% {
            transform: translateY(0);
        }
        100% {
            transform: translateY(-30px);
        }
    }

    @keyframes slide-in {
        0% {
            transform: translateY(-30px);
        }
        100% {
            transform: translateY(0);
        }
    }
</style>
