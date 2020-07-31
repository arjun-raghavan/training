<template>
    <div>
    <h3>Some User Details</h3>
    <p>User with id : {{ $route.params.id}} loaded</p>
    <!-- //:to="'/user/'+ $route.params.id + '/edit'" -->
    <!--
    <router-link 
        tag="button" 
        :to="{name: 'userEdit', params: {id:$route.params.id}, query: {locale: 'en', q: 100 }}"
        class="btn btn-primary">Edit User</router-link>
    -->
    <router-link
        tag="button"
        :to="link"
        class="btn btn-primary">Edit User
    </router-link>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                link: {
                    name: 'userEdit',
                    params: {
                        id: this.$route.params.id
                    },
                    query: {
                        locale: 'en',
                        q: 100
                    },
                    hash: '#data'
                }
            }
        },
        beforeRouteEnter(to, from, next) {
            // you can access your view instance here. The component is not loaded.
            // component is loaded only after next() is called.
            // a way to access once component is loaded - function callback
            /*
                next(vm => {
                    vm.link;
                })
            */

            if (true) {
                next();
            } else {
                next(false);
            }
        }
    }
</script>