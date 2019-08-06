import React from "react";
import Signup from "./../signup/Signup";
import { Route, withRouter, Switch } from "react-router-dom";
import { Layout, notification } from "antd";
const { Content } = Layout;

function AppCopy() {
    return ( <
        Layout className = "app-container" >
        <
        Content className = "app-content" >
        <
        div className = "container" / >
        <
        /Content>{" "} <
        /Layout>
    );
}

export default AppCopy;