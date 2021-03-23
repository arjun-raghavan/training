<template>
  <div>
    <button @click="getSelectedRows()">Get Selected Rows</button>
    <button @click="toggleGroupby()">Toggle Groupby</button>
    <ag-grid-vue
      style="width: 500px; height: 500px"
      class="ag-theme-alpine"
      :columnDefs="columnDefs"
      :rowData="rowData"
      rowSelection="multiple"
      @grid-ready="onGridReady"
    >
    </ag-grid-vue>
  </div>
</template>

<script>
// @ is an alias to /src
import { AgGridVue } from "ag-grid-vue";

export default {
  name: "App",
  data() {
    return {
      columnDefs: null,
      rowData: null,
      gridApi: null,
      columnApi: null,
      autoGroupColumnDef: null,
    };
  },
  components: {
    AgGridVue,
  },
  beforeMount() {
    this.columnDefs = [
      { headerName: "Make", field: "make", rowGroup: false },
      { headerName: "Model", field: "model" },
      { headerName: "Price", field: "price" },
    ];

    this.autoGroupColumnDef = {
      headerName: "Model",
      field: "model",
      cellRenderer: "agGroupCellRenderer",
      cellRendererParams: {
        checkbox: true,
      },
    };

    fetch("https://www.ag-grid.com/example-assets/row-data.json")
      .then((result) => result.json())
      .then((rowData) => (this.rowData = rowData));
  },
  methods: {
    onGridReady(params) {
      this.gridApi = params.api;
      this.columnApi = params.columnApi;
    },
    getSelectedRows() {
      const selectedNodes = this.gridApi.getSelectedNodes();
      const selectedData = selectedNodes.map((node) => node.data);
      const selectedDataStringPresentation = selectedData
        .map((node) => `${node.make} ${node.model}`)
        .join(", ");
      alert(`Selected nodes: ${selectedDataStringPresentation}`);
    },
    toggleGroupby() {
      var item = this.columnDefs.find((x) => x.field == "make");
      if (item) {
        item.rowGroup = !item.rowGroup;
      }
      console.log(this.columnDefs);
      this.$forceUpdate();
    },
  },
};
</script>
