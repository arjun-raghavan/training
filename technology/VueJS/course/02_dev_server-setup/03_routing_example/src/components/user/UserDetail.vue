<template>
    <div>
    <h3>Some User Details</h3>
    <p>User with id : {{ $route.params.id}} loaded</p>
    <router-link 
        tag="button" 
        :to="'/user/'+ $route.params.id + '/edit'"
        class="btn btn-primary">Edit User</router-link>
    </div>
</template>

<script>
</script>