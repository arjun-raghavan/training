<template>
  <v-app>
    
    <Header></Header>
    <v-main>
      <Exception @click.native="launchCaseManagement"></Exception>
      <DecisionCriteria/>
    </v-main>
    <v-footer app>
    <input type="text" v-model="port"> <input type="text" v-model="casetype">
    </v-footer>
  </v-app>
</template>

<script>
 import Header from './components/Header';
 import Exception from "./components/Exception";
 import DecisionCriteria from "./components/DecisionCriteria";

export default {
  name: 'App',

  components: {
    Header,
    Exception,
    DecisionCriteria
  },
  data: () => ({
    navs: [
      {
        text: 'Case Management',
        disabled: false

      },
      {
        text: 'Case Overview',
        disabled: false
      }
      // { text:'dashboard',disabled:false, to:{name: 'dashboard'}, exact: true }
    ],
    port: 9100,
    casetype: 10
  }),
  methods: {
            launchCaseManagement(){
                const uri = `http://casemanagement.example.com:${this.port}?casetype=${this.casetype}`
                console.log("launchCaseManagement : "+uri);
                console.log(`location=${location.host}`);
                this.setCookie("username","arjun-raghavan", 2);
                window.location.href = uri;
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
                document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/;domain=example.com";
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
        }
};
</script>

<style scoped>
#bitem {
    cursor: pointer;
  }
</style>
