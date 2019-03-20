import React from "react";
import { BrowserRouter as Router, Link, Route } from "react-router-dom";

import { GISTS } from "./data";
import Sidebar from "../../components/Sidebar";
import SidebarItem from "../../components/SidebarItem";
import ContentWindow from "../../components/ContentWindow";
import Gist from "../../components/Gist";

export default class RoutesApp extends React.Component {
  state = {
    gists: null
  };

  componentDidMount() {
    this.setState({ gists: GISTS });
  }

  render() {
    const { gists } = this.state;
    return (
      <Router>
        <div style={{ display: "flex" }}>
          <Sidebar>
            {gists ? (
              gists.map(gist => (
                <SidebarItem key={gist.id}>
                  <Link to={`/gist/${gist.id}`}>
                    {gist.description || "[no description]"}
                  </Link>
                </SidebarItem>
              ))
            ) : (
              <div>Loading...</div>
            )}
          </Sidebar>
          <ContentWindow>
            <Route exact={true} path="/" render={() => <h1>Welcome</h1>} />
            {gists && (
              <Route
                path="/gist/:id"
                render={({ match }) => (
                  <Gist gist={gists.find(g => g.id === match.params.id)} />
                )}
              />
            )}
          </ContentWindow>
        </div>
      </Router>
    );
  }
}
