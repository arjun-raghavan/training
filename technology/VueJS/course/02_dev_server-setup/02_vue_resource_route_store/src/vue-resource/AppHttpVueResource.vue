<template>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
                <h1>https://apphttpvueresource.firebaseio.com/</h1>

                <div class="form-group">
                    <label>Username</label>
                    <input class="form-control" type="text" v-model="user.username">
                </div>

                <div class="form-group">
                    <label>Mail</label>
                    <input class="form-control" type="text" v-model="user.email">
                </div>

                <button type="button" class="btn btn-primary" @click="submit">Submit</button>
                <button type="button" class="btn btn-warning" @click="save">Resource Save</button>
                <button type="button" class="btn btn-danger" @click="saveAction">Save Alt - Action</button>
                <hr>
                 <div class="form-group">
                    <label>Node</label>
                <input class="form-control" type="text" v-model="node">
                </div>
                <br>
                <button type="button" class="btn btn-primary" @click="fetchData">Fetch Data</button>
                <button type="button" class="btn btn-primary" @click="fetchDataNode">Fetch Data Node</button>
                <br>
                <ul>
                    <li class="list-group-item" v-for="user in users" :key="user.email">{{user.username}}</li>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  data () {
    return {
      user: {
        username: '',
        email: ''
      },
      users: [],
      resource: {},
      node: 'data'
    }
  },
  methods: {
    save () {
      this.resource.save({}, this.user)
    },
    saveAction () {
      this.resource.saveAlt(this.user)
    },
    submit () {
    //   this.$http.post('https://apphttpvueresource.firebaseio.com/data.json', this.user)
      this.$http.post('data.json', this.user)
        .then(response => { console.log(response) }, error => { console.log(error) })
    },
    fetchData () {
    //   this.$http.get('https://apphttpvueresource.firebaseio.com/data.json')
      this.$http.get('data.json')
        .then(response => {
          return response.json()
        }).then(data => {
          console.log(data)
          const resultArray = []
          for (const key in data) {
            resultArray.push(data[key])
          }
          this.users = resultArray
          console.log(this.users)
        })
    },
    fetchDataNode () {
      this.resource.getData({ node: this.node })
        .then(response => {
          return response.json()
        }).then(data => {
          const resultArray = []
          for (const key in data) {
            resultArray.push(data[key])
          }
          this.users = resultArray
        })
    }
  },
  created () {
    const customActions = {
      saveAlt: { method: 'POST', url: 'alt.json' },
      getData: { method: 'GET' }
    }
    // this.resource = this.$resource('data.json', {}, customActions)
    this.resource = this.$resource('{node}.json', {}, customActions)
  }
}
</script>

<style>
</style>
