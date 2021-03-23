<template>
  <div>
    <ag-grid-vue
      style="width: 1111px; height: 500px"
      class="ag-theme-alpine"
      :gridOptions="gridOptions"
      :columnDefs="columnDefs"
      :rowData="rowData"
      rowSelection="multiple"
    >
    </ag-grid-vue>
  </div>
</template>

<script>
import { AgGridVue } from "ag-grid-vue";
import { eventBus } from "./../main.js";

export default {
  name: "Details",
  data() {
    return {
      gridOptions: null,
      columnDefs: null,
      rowData: null,
    };
  },
  components: {
    AgGridVue,
  },
  beforeMount() {
    this.gridOptions = {};
    this.columnDefs = [
      {
        field: "RowSelect",
        headerName: "",
        checkboxSelection: true,
        suppressMenu: true,
        suppressSorting: true,
        pinned: "left",
        headerCellRenderer: function () {
          let flag =
            "<img border='0' width='15' height='10' style='margin-bottom: 2px' src='https://raw.githubusercontent.com/ag-grid/ag-grid-docs/master/src/images/flags/de.png'>";
          return flag;
        },
        resizable: true,
      },
      {
        field: "WrongfulValue",
        sortable: true,
        filter: true,
        pinned: "left",
        resizable: true,
        // rowGroup: true
      },
      {
        field: "F1",
        headerName: "Material Number",
        sortable: true,
        filter: true,
        suppressToolPanel: true,
        setColumnVisible: false,
        // checkboxSelection: true,
        cellRenderer: function (params) {
          let flag =
            "<img border='0' width='15' height='10' style='margin-bottom: 2px' src='https://raw.githubusercontent.com/ag-grid/ag-grid-docs/master/src/images/flags/de.png'>";
          return flag + " " + params.value;
        },
        resizable: true,
      },
      {
        field: "F2",
        headerName: "Order Type",
        sortable: true,
        filter: true,
        cellRenderer: function (params) {
          let data = params.data;
          console.log(data);
          let skills = [];
          skills.push(
            '<img src="https://raw.githubusercontent.com/ag-grid/ag-grid-docs/master/src/images/skills/android.png" width="16px" title="android" />'
          );
          // skills.push('<img src="https://raw.githubusercontent.com/ag-grid/ag-grid-docs/master/src/images/skills/css.png" width="16px" title="css" />');
          // skills.push('<img src="https://raw.githubusercontent.com/ag-grid/ag-grid-docs/master/src/images/skills/html5.png" width="16px" title="html5" />');
          // skills.push('<img src="https://raw.githubusercontent.com/ag-grid/ag-grid-docs/master/src/images/skills/mac.png" width="16px" title="mac" />');
          // skills.push('<img src="https://raw.githubusercontent.com/ag-grid/ag-grid-docs/master/src/images/skills/windows.png" width="16px" title="windows" />');
          return params.value + " " + skills.join(" ");
        },
        resizable: true,
      },
      { field: "F3", headerName: "Customer PO#", sortable: true, filter: true },
      {
        field: "F4",
        headerName: "Customer Sold To",
        sortable: true,
        filter: true,
        resizable: true,
      },
      // {
      //   field: "F4",
      //   headerName: "Customer Ship To",
      //   sortable: true,
      //   filter: true,
      //   resizable: true,
      // },
      {
        field: "F5",
        headerName: "Material ID",
        sortable: true,
        filter: true,
        resizable: true,
      },
      {
        field: "F6",
        headerName: "Size",
        sortable: true,
        filter: true,
        resizable: true,
      },
      {
        field: "F7",
        headerName: "Qunatity",
        sortable: true,
        filter: true,
        resizable: true,
      },
      {
        field: "F8",
        headerName: "Contract #",
        sortable: true,
        filter: true,
        resizable: true,
      },
      {
        field: "F9",
        headerName: "Region Code",
        sortable: true,
        filter: true,
        resizable: true,
      },
      { field: "F10", sortable: true, filter: true, resizable: true },
      { field: "F11", sortable: true, filter: true, resizable: true },
      { field: "F12", sortable: true, filter: true, resizable: true },
      { field: "F13", sortable: true, filter: true, resizable: true },
      { field: "F14", sortable: true, filter: true, resizable: true },
      { field: "F15", sortable: true, filter: true, resizable: true },
      { field: "F16", sortable: true, filter: true, resizable: true },
      { field: "F17", sortable: true, filter: true, resizable: true },
      { field: "F18", sortable: true, filter: true, resizable: true },
      { field: "F19", sortable: true, filter: true, resizable: true },
      { field: "F20", sortable: true, filter: true, resizable: true },
      { field: "F21", sortable: true, filter: true, resizable: true },
      { field: "F22", sortable: true, filter: true, resizable: true },
      { field: "F23", sortable: true, filter: true, resizable: true },
      { field: "F24", sortable: true, filter: true, resizable: true },
      { field: "F25", sortable: true, filter: true, resizable: true },
      { field: "F26", sortable: true, filter: true, resizable: true },
      { field: "F27", sortable: true, filter: true, resizable: true },

      {
        field: "Actions",
        sortable: true,
        filter: true,
        resizable: true,
        pinned: "right",
        cellRenderer: function () {
          return `
            <select name="actions" id="actions">
              <option value="update">Update</option>
              <option value="reporcess">Reprocess</option>
              <option value="delete">Delete</option>
            </select>
          `;
        },
      },
    ];

    fetch("https://mockend.com/arjun-raghavan/training/cases")
      .then((result) => result.json())
      .then((rowData) => (this.rowData = rowData));

    // this.rowData = [
    //   { make: "Toyota", model: "Celica", price: 35000 },
    //   { make: "Ford", model: "Mondeo", price: 32000 },
    //   { make: "Porsche", model: "Boxter", price: 72000 },
    // ];
  },
  mounted() {
    console.log("Details.mounted", this.gridOptions);
    this.gridColumnApi = this.gridOptions.columnApi;
    var allColumnIds = [];
    this.gridOptions.columnApi.getAllColumns().forEach(function (column) {
      allColumnIds.push(column.colId);
    });

    this.gridOptions.columnApi.autoSizeColumns(allColumnIds, false);

    eventBus.$on("saveModal", (selectedColumns) => {
      this.showModal = false;
      this.selected = selectedColumns;
      var list = [
        "F1",
        "F2",
        "F3",
        "F4",
        "F5",
        "F6",
        "F7",
        "F8",
        "F9",
        "F10",
        "F11",
        "F12",
        "F13",
        "F14",
        "F15",
        "F16",
        "F17",
        "F18",
        "F19",
        "F20",
        "F21",
        "F22",
        "F23",
        "F24",
        "F25",
        "F26",
        "F27",
      ];
      let difference = list.filter((x) => !selectedColumns.includes(x));
      this.gridOptions.columnApi.setColumnsVisible(selectedColumns, true);
      this.gridOptions.columnApi.setColumnsVisible(difference, false);
    });
  },
};
</script>

<style lang="scss">
@import "../../node_modules/ag-grid-community/dist/styles/ag-grid.css";
@import "../../node_modules/ag-grid-community/dist/styles/ag-theme-alpine.css";
</style>
