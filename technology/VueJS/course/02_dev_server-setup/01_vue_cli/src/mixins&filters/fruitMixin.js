export const fruitMixin = {
  data(){
    return {
        filterText:'',
        fruits: ['apple', 'banana', 'mango', 'melon']
    }
  },
  computed: {
      filteredFruits(){
          return this.fruits.filter((element) => {
              return element.match(this.filterText);
          })
      }
  },
  created(){
    console.log("Mixin Created");
  }
}