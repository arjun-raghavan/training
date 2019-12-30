import React from "react";
import { Route } from "react-router-dom";
import NavBar from "./NavBar/NavBar";
import Question from "./Question/Question";
import Questions from "./Questions/Questions";
import Callback from "./Callback";
import NewQuestion from "./NewQuestion/NewQuestion";
import SecuredRoute from "./SecuredRoute/SecuredRoute";
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
      <div>
        <NavBar />
        <Route exact path="/" component={Questions} />
        <Route exact path="/question/:questionId" component={Question} />
        <Route exact path="/callback" component={Callback} />
        <SecuredRoute path="/new-question" component={NewQuestion} />
      </div>
    );
  }
}

export default App;
