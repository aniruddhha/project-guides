import React from 'react'
import { Route } from "react-router-dom"
import DashboardAdmin from './dashboard-admin.component';
import DashboardClerk from './dashboard-clerk.component';
import DashboardDoctor from './dashboard-doctor.component';
import DashboardPatient from './doctor-patient.component';

export default function RoutesDashboard({ match: { url } }) {
    return (
        <>
            <Route path={`${url}/admin`} component={DashboardAdmin} />
            <Route path={`${url}/clerk`} component={DashboardClerk} />
            <Route path={`${url}/doctor`} component={DashboardDoctor} />
            <Route path={`${url}/patient`} component={DashboardPatient} />
        </>
    )
}
