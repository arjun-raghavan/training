import React from "react";

const Sidebar = props => (
  <div
    style={{
      width: "33vw",
      height: "100vh",
      overflow: "auto",
      background: "#eee"
    }}
    {...props}
  />
);

export default Sidebar;
