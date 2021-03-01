import React from 'react'
import './roles.component.css'

export default function RoleSelection() {
    return (
        <>
            <div className="container">
                <div className="imgContainer">
                    image section
               </div>
                <div className="verticalLine"></div>
                <div className="rolesContainer">
                    <div className="roleDiv">
                        Whats your Role ?
                    </div>
                    <div className="roleDiv">
                        <input type="button" value="Admin" />
                    </div>
                    <div className="roleDiv">
                        <input type="button" value="Clerk" />
                    </div>
                    <div className="roleDiv">
                        <input type="button" value="Doctor" />
                    </div>
                    <div className="roleDiv">
                        <input type="button" value="Patient" />
                    </div>
                    <div className="roleDiv">

                    </div>
                    <div className="roleDiv">
                        <a>If registered click here to login</a>
                    </div>
                </div>
            </div>
        </>
    )
}
