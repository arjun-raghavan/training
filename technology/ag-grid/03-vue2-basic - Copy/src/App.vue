<template>
  <div>
    <div class="container">
      <Header />
      <Breadcrumbs />
      <b-container>
        <b-row class="text-center" align-v="center" align-h="end">
          <!-- Button trigger modal -->
          <b-button size="sm" class="mb-2" @click="showModal = true">
            <b-icon icon="gear-fill" aria-hidden="true"></b-icon> Edit Columns
          </b-button>
        </b-row>
      </b-container>

      <EditTableColumns :show="showModal" :selectedColumns="selected" />
      <div>
        <Filters />
        <div>
          <router-view></router-view>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Header from "./components/Header";
import Breadcrumbs from "./components/Breadcrumbs";
import Filters from "./components/Filters";
import EditTableColumns from "./components/EditTableColumns";
import { eventBus } from "./main.js";

export default {
  name: "App",
  data() {
    return {
      gridOptions: null,
      columnDefs: null,
      rowData: null,
      showModal: false,
      selected: ["F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9"],
    };
  },
  components: {
    Header,
    Breadcrumbs,
    Filters,
    EditTableColumns,
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
      },
      {
        field: "F1",
        headerName: "Material Number",
        sortable: true,
        filter: true,
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
      {
        field: "F4",
        headerName: "Customer Ship To",
        sortable: true,
        filter: true,
        resizable: true,
      },
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
  },
  mounted() {
    console.log("mounted");
    // this.gridColumnApi = this.gridOptions.columnApi;
    var allColumnIds = [];
    this.gridOptions.columnApi.getAllColumns().forEach(function (column) {
      allColumnIds.push(column.colId);
    });

    this.gridOptions.columnApi.autoSizeColumns(allColumnIds, false);
  },
  created() {
    eventBus.$on("saveModal", (selectedColumns) => {
      this.showModal = false;
      this.selected = selectedColumns;
    });

    eventBus.$on("closeModal", (show) => {
      console.log("closeModal :", show);
      this.showModal = false;
    });
  },
};
</script>

<style lang="scss">
@import "../node_modules/ag-grid-community/dist/styles/ag-grid.css";
@import "../node_modules/ag-grid-community/dist/styles/ag-theme-alpine.css";
.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: table;
  transition: opacity 0.3s ease;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}
</style>
