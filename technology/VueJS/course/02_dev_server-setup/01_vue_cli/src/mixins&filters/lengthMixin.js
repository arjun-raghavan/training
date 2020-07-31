export const lengthMixin = {
  computed: {
    titleWithLength(){
      return this.title + '('+this.title.length+')';
    }
  }
}