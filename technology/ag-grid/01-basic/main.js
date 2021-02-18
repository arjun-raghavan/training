var columnDefs = [
    { field: "title", sortable: true, filter: true },
    { field: "views", sortable: true, filter: true },
    { field: "createdAt", sortable: true, filter: true }
];

// https://mockend.com/arjun-raghavan/training/posts

var rowData = [
    { make: "Citroen", model: "C5 Aircross", price: 3000000 },
    { make: "Renault", model: "Kiger", price: 545000 },
    { make: "Kia", model: "Sonet", price: 679000 }
];

// let the grid know which columns and what data to use
var gridOptions = {
    columnDefs: columnDefs,
    // rowData: rowData
    rowSelection: 'multiple'
};


// lookup the container we want the Grid to use
var eGridDiv = document.querySelector('#myGrid');

// create the grid passing in the div to use together with the columns & data we want to use
new agGrid.Grid(eGridDiv, gridOptions);

agGrid.simpleHttpRequest({ url: 'https://mockend.com/arjun-raghavan/training/posts' })
    .then(function (data) {
        gridOptions.api.setRowData(data);
    });


function getSelectedRows() {
    var selectedNodes = gridOptions.api.getSelectedNodes();
    console.log(selectedNodes);
    var selectedData = selectedNodes.map(node => node.data);
    console.log(selectedData);
    var selectedDataStringPresentation = selectedData.map(node => node.title + ' ' + node.views).join(', ');
    alert(selectedDataStringPresentation);
}