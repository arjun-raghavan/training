import React from "react";
import ThemedToolbar from "../../components/ThemedToolbar";

const ThemeContext = React.createContext("light");

class ContextApiApp extends React.Component {
  render() {
    return (
      <ThemeContext.Provider value="dark">
        <ThemedToolbar />
      </ThemeContext.Provider>
    );
  }
}

export default ContextApiApp;
