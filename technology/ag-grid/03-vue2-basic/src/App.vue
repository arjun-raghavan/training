<template>
  <ag-grid-vue
    style="width: 500px; height: 500px"
    class="ag-theme-alpine"
    :columnDefs="columnDefs"
    :rowData="rowData"
    rowSelection="multiple"
  >
  </ag-grid-vue>
</template>

<script>
import { AgGridVue } from "ag-grid-vue";

export default {
  name: "App",
  data() {
    return {
      columnDefs: null,
      rowData: null,
    };
  },
  components: {
    AgGridVue,
  },
  beforeMount() {
    this.columnDefs = [
      {
        field: "make",
        sortable: true,
        filter: true,
        // checkboxSelection: true,
        cellRenderer: function (params) {
          let flag =
            "<img border='0' width='15' height='10' style='margin-bottom: 2px' src='https://raw.githubusercontent.com/ag-grid/ag-grid-docs/master/src/images/flags/de.png'>";
          return flag + " " + params.value;
        },
      },
      { 
        field: "model", sortable: true, filter: true,
        cellRenderer: function (params) {
          let data = params.data;
          console.log(data);
          let skills = [];
          skills.push('<img src="https://raw.githubusercontent.com/ag-grid/ag-grid-docs/master/src/images/skills/android.png" width="16px" title="android" />');
          skills.push('<img src="https://raw.githubusercontent.com/ag-grid/ag-grid-docs/master/src/images/skills/css.png" width="16px" title="css" />');
          skills.push('<img src="https://raw.githubusercontent.com/ag-grid/ag-grid-docs/master/src/images/skills/html5.png" width="16px" title="html5" />');
          skills.push('<img src="https://raw.githubusercontent.com/ag-grid/ag-grid-docs/master/src/images/skills/mac.png" width="16px" title="mac" />');
          skills.push('<img src="https://raw.githubusercontent.com/ag-grid/ag-grid-docs/master/src/images/skills/windows.png" width="16px" title="windows" />');
          return skills.join(' ');
        },
      },
      { field: "price", sortable: true, filter: true },
    ];

    fetch("https://www.ag-grid.com/example-assets/row-data.json")
      .then((result) => result.json())
      .then((rowData) => (this.rowData = rowData));

    // this.rowData = [
    //   { make: "Toyota", model: "Celica", price: 35000 },
    //   { make: "Ford", model: "Mondeo", price: 32000 },
    //   { make: "Porsche", model: "Boxter", price: 72000 },
    // ];
  },
};
</script>

<style lang="scss">
@import "../node_modules/ag-grid-community/dist/styles/ag-grid.css";
@import "../node_modules/ag-grid-community/dist/styles/ag-theme-alpine.css";
</style>
