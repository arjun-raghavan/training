import React from "react";
import logo from "./../logo.svg";
import "./App.css";

import { Route, withRouter, Switch } from "react-router-dom";
import { Layout, notification } from "antd";
import Signup from "./../signup/Signup";

function App() {
    return ( <
        >
        <
        Switch > { " " } <
        Route path = "/signup"
        component = { Signup } > { " " } <
        /Route>{" "} <
        /Switch>{" "} <
        />
    );
}

export default App;