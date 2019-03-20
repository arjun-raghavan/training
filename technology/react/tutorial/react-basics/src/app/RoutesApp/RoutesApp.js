import React from "react";
import { GISTS } from "./data";
import Sidebar from "../../components/Sidebar";
import SidebarItem from "../../components/SidebarItem";
import ContentWindow from "../../components/ContentWindow";

export default class RoutesApp extends React.Component {
  state = {
    gists: null
  };

  componentDidMount() {
    this.setState({ gists: GISTS });
  }

  render() {
    const { gists } = this.state;
    console.log(gists);
    return (
      <div style={{ display: "flex" }}>
        <Sidebar>
          {gists ? (
            gists.map(gist => (
              <SidebarItem key={gist.id}>
                {gist.description || "[no description]"}
              </SidebarItem>
            ))
          ) : (
            <div>Loading...</div>
          )}
        </Sidebar>
        <ContentWindow>
          <h1>Welcome</h1>
        </ContentWindow>
      </div>
    );
  }
}
