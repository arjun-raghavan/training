import React from "react";
import logo from "./logo.svg";
import "./App.css";
import Cookies from "js-cookie";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      ext_name: Cookies.get("ext_name"),
      username: Cookies.get("username")
    };
  }

  render() {
    console.log("ext_name: " + this.state.ext_name);
    console.log("username: " + this.state.username);
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
        </header>
      </div>
    );
  }
}

export default App;
