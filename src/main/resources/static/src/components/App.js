import React from 'react';
//var React = require("react");
class App extends React.Component {
  hello(){
    alert("hello from outside!");
  }
    render(){
      let text = "server";
        return (
              <div>
                <h1>Hello React Skeleton</h1>
                <h2> welcome to the {text}</h2>
                <button onClick={this.hello}>click me </button>
              </div>
        );
        //redering DOM here, no need to seal with ""
    }
}

export default App;
