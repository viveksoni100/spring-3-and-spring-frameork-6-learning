import {Link, useParams} from "react-router-dom"
import {useState} from "react";
import {retrieveHelloWorldBean, retrieveHelloWorldBeanPathVariable} from "./api/HelloWorldApiServicce"

export default function WelcomeComponent() {

    const {username} = useParams()
    const [msg, setMsg] = useState(null)

    function successfulResponse(response) {
        setMsg(response.data.message + "-" + response.status)
        console.log(response)
    }

    function errorResponse(error) {
        console.log(error)
    }

    function callHelloWorldRestApi() {
        /*retrieveHelloWorldBean()
            .then((response) => successfulResponse(response))
            .catch((error) => errorResponse(error))*/
        retrieveHelloWorldBeanPathVariable("vivek")
            .then((response) => successfulResponse(response))
            .catch((error) => errorResponse(error))
    }

    return (
        <div className="Welcome">
            Welcome Component - {username} manage your <Link to="/todos">todos</Link>
            <div>
                <button className="btn btn-success m-3"
                        onClick={callHelloWorldRestApi}>call hello world rest api
                </button>
                <div className="text-info">{msg}</div>
            </div>
        </div>
    )
}