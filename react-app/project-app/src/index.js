import React from 'react';
import ReactDOM from 'react-dom';
import Approval from './approval/approval.component';
import Billing from './billing/billing.component';
import 'bootstrap/dist/css/bootstrap.min.css';
import './index.css';
import Patient from './patient/patient.component';
import reportWebVitals from './reportWebVitals';
import TestResult from './test-result/test-result';
import Treatment from './treatment/treatment';
import { BrowserRouter, Route, Switch } from "react-router-dom"

import RoutesDashboard from './dashboard/routes-dashboard.component';
import RoleSelection from './user/roles.component';
import Login from './user/login.component';
import Registration from './user/registration.component';

ReactDOM.render(
  <BrowserRouter>
    <Switch>
      <Route path="/" component={RoleSelection} exact />
      <Route path="/login" component={Login} />
      <Route path="/registration" component={Registration} />
      <Route path="/dashboard" component={RoutesDashboard} />
      <Route path="/patient" component={Patient} />
      <Route path="/test-result" component={TestResult} />
      <Route path="/treatment" component={Treatment} />
      <Route path="/approval" component={Approval} />
      <Route path="/billing" component={Billing} />
    </Switch>
  </BrowserRouter>
  ,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
