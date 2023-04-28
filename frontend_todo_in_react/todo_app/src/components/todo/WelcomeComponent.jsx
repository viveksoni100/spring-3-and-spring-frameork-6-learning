import { Link, useParams } from "react-router-dom"

export default function WelcomeComponent() {

    const { username } = useParams()

    return (
        <div className="Welcome">
            Welcome Component - {username}
            <Link to="/todos">todos</Link>
        </div>
    )
}