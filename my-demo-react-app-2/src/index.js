import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";

function yoTime() {
  const myElement = <div>Yo, it's {new Date().toLocaleTimeString()}!</div>;
  ReactDOM.render(myElement, document.getElementById("root"));
}

setInterval(yoTime, 1000);
// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
