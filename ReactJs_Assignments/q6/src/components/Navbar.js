import React from "react";
import Home from "./Home";
import Projects from "./Projects";
import Services from "./Services";
import Contacts from "./Contacts";
import "./Navbar.css";
import { Link, BrowserRouter as Router, Switch, Route } from "react-router-dom";
export default function Navbar() {
  return (
      <Router>
          <div>
      <div className="navbar">
        <Link className="link" to="/Home">
                  <h1>Home</h1>
        </Link>
        <Link className="link" to="/Projects">
          <h1>Projects</h1>
        </Link>
        <Link className="link" to="/Services">
          <h1>Services</h1>
        </Link>
        <Link className="link" to="/Contacts">
          <h1>Contacts</h1>
              </Link>
              </div>
              <div>
                  <Route path="/Home" component={Home} />
                  <Route path="/Projects" component={Projects} />
                  <Route path="/Services" component={Services} />
                  <Route path="/Contacts" component={Contacts} />
              </div>
              <div className="box">

              </div>
          </div>
    </Router>
  );
}
