import React from "react";

const Gist = ({ gist }) => {
  console.log(gist);
  return (
    <div>
      <h1>{gist.description || "[No Description]"}</h1>
    </div>
  );
};

export default Gist;
