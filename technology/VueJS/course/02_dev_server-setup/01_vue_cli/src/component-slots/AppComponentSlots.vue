<template>
    <div class="container">
        <div class="row">
            <div class="col-12">
              <h2>Dynamic Rendering </h2>
              <h3>Component Destoryed</h3>
              <button @click="selectedComponent = 'Quote'">Quote</button>
              <button @click="selectedComponent = 'Author'">Author</button>
              <button @click="selectedComponent = 'New'">New</button>
              <component :is="selectedComponent"></component>
              <h3>Component Alive</h3>
              <keep-alive>
                <component :is="selectedComponent"></component>
              </keep-alive>
              <hr>
              <h2>Static Rendering </h2>
              <Quote>
                <h2 slot="title">{{quoteTitle}}</h2>
                <p>A wonderful quote</p>
              </Quote>  
              
              <Author></Author>
              <New></New>             
            </div>
        </div>
    </div>
</template>

<script>
    import Quote from './components/Quote';
    import Author from './components/Author';
    import New from './components/New';

    export default {
      data(){
        return {
          quoteTitle: 'The Quote',
          selectedComponent: 'Quote'
        }
      },
        components: {
          Quote,
          Author,
          New
        }
    }
</script>

<style scoped>

  /* h2 {
    color: cyan;
  } */

</style>
