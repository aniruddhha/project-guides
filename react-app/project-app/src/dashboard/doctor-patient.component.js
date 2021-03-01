import React, { useEffect } from 'react'

export default function DashboardPatient(props) {

    useEffect(() => {
        console.log(props)
    }, [])

    return (
        < div >
            Dashboard Patient
        </div >
    )
}
