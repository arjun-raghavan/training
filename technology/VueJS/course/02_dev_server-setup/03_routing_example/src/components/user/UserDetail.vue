<template>
    <div>
    <h3>Some User Details</h3>
    <p>User with id : {{ $route.params.id}} loaded</p>
    <!-- //:to="'/user/'+ $route.params.id + '/edit'" -->
    <router-link 
        tag="button" 
        :to="{name: 'userEdit', params: {id:$route.params.id}, query: {locale: 'en', q: 100 }}"
        class="btn btn-primary">Edit User</router-link>
    </div>
</template>

<script>
</script>