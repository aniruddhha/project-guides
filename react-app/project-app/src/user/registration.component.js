import React from 'react'
import './registration.component.css'

export default function Registration() {
    return (
        <>
            <div className="registrationContainer">
                <div className="ttl">
                    <h3>User reg</h3>
                </div>

                <div className="dvRole">
                    <input type="select" />
                </div>

                <div className="dvBsInf">
                    <div className="text-muted"> Baisc Info </div>
                    <div><hr /></div>
                </div>

                <div className="dvFirstName">
                    <input id="firstName" placeholder="firstName" type="text" />
                </div>
                <div className="dvLastName">
                    <input id="lastName" placeholder="lastName" type="text" />
                </div>
                <div className="dvGender">
                    <input id="gender" placeholder="gender" type="text" />
                </div>
                <div className="dvDob">
                    <input id="dob" placeholder="dob" type="text" />
                </div>
                <div className="dvContact">
                    <input id="contact" placeholder="contact" type="text" />
                </div>
                <div className="dvAddress">
                    <input id="address" placeholder="address" type="text" />
                </div>

                <div className="dvRegDtls">
                    <div className="text-muted"> Registration </div>
                    <div><hr /></div>
                </div>

                <div className="dvEmail">
                    <input id="email" placeholder="email" type="text" />
                </div>
                <div className="dvPassword">
                    <input id="password" placeholder="password" type="text" />
                </div>
                <div className="dvConfirmPassword">
                    <input id="confirmPassword" placeholder="confirmPassword" type="text" />
                </div>

                <div className="dvQuali">
                    <div className="text-muted"> Qualification </div>
                    <div><hr /></div>
                </div>

                <div className="dvQualification">
                    <input id="qualification" placeholder="qualification" type="text" />
                </div>
                <div className="dvSpelization">
                    <input id="spelization" placeholder="spelization" type="text" />
                </div>
                <div className="dvOther">
                    <input id="other" placeholder="other" type="text" />
                </div>

                <div className="dvDr">
                    <hr />
                </div>
                <div className="dvBtn">
                    <input type="button" value="Register" />
                </div>
            </div>
        </>
    )
}
