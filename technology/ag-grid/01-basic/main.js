var columnDefs = [
    { field: "make" },
    { field: "model" },
    { field: "price" }
  ];

  var rowData = [
    { make: "Citroen", model: "C5 Aircross", price: 3000000 },
    { make: "Renault", model: "Kiger", price: 545000 },
    { make: "Kia", model: "Sonet", price: 679000 }
  ];

  // let the grid know which columns and what data to use
  var gridOptions = {
    columnDefs: columnDefs,
    rowData: rowData
  };

  // lookup the container we want the Grid to use
  var eGridDiv = document.querySelector('#myGrid');

  // create the grid passing in the div to use together with the columns & data we want to use
  new agGrid.Grid(eGridDiv, gridOptions);