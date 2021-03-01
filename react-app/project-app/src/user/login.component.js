import React, { useEffect } from 'react'
import { useLocation } from "react-router-dom";
import './user.component.css'
import './login.component.css'

export default function Login(props) {

    const location = useLocation()

    useEffect(() => {
        console.log(location.state.params)
    }, [])

    return (
        <>
            <div className="mainContainer">
                <div className="imgContainer">
                    image section
                </div>
                <div className="verticalLine"></div>
                <div className="rightContainer">
                    <div className="rightChild">
                        Login
                    </div>
                    <div className="rightChild">
                        <form>
                            <div class="form-group">
                                <label for="ipUsNm">User Name</label>
                                <input id="ipUsNm" type="text" class="form-control" placeholder="User Name" />
                            </div>
                            <div class="form-group">
                                <label for="ipPass">Password</label>
                                <input id="ipPass" type="password" class="form-control" placeholder="Password" />
                            </div>
                            <div class="form-group">
                                <input type="submit" class="form-control btn btn-primary" value="Login" />
                            </div>
                        </form>
                    </div>
                    <div className="rightChild">
                        <a>For Registering Click Here</a>
                    </div>
                </div>
            </div>
        </>
    )
}
