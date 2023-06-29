import {Link, useParams} from "react-router-dom";
import {useState} from "react";
import {retrieveHelloWorldBeanPathVariable} from "./api/HelloWorldApiServicce";
import {useAuth} from "./security/AuthContext";

export default function WelcomeComponent() {

    const {username} = useParams();
    const [msg, setMsg] = useState(null);
    const authContext = useAuth();

    function successfulResponse(response) {
        setMsg(response.data.message + "-" + response.status);
        console.log(response);
    }

    function errorResponse(error) {
        console.log(error);
    }

    function callHelloWorldRestApi() {

        retrieveHelloWorldBeanPathVariable("vivek", authContext.token)
            .then((response) => successfulResponse(response))
            .catch((error) => errorResponse(error));
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