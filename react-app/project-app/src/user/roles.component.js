import React from 'react'
import { useHistory } from "react-router-dom";

import './user.component.css'

export default function RoleSelection() {

    const history = useHistory()

    function onSelectRole(role) {
        history.push('/login', { params: { role } })
    }

    return (
        <>
            <div className="mainContainer">
                <div className="imgContainer">
                    image section
               </div>
                <div className="verticalLine"></div>
                <div className="rightContainer">
                    <div className="rightChild">
                        Whats your Role ?
                    </div>
                    <div className="rightChild">
                        <input className="btn btn-primary" type="button" value="Admin" onClick={() => onSelectRole('admin')}
                        />
                    </div>
                    <div className="rightChild">
                        <input className="btn btn-primary" type="button" value="Clerk" onClick={() => onSelectRole('clerk')} />
                    </div>
                    <div className="rightChild">
                        <input className="btn btn-primary" type="button" value="Doctor" onClick={() => onSelectRole('doctor')} />
                    </div>
                    <div className="rightChild">
                        <input className="btn btn-primary" type="button" value="Patient" onClick={() => onSelectRole('patient')} />
                    </div>
                    <div className="rightChild">
                        <a className="text-secondary">If registered click here to login</a>
                    </div>
                </div>
            </div>
        </>
    )
}
