import { useState } from "react"
import { useNavigate } from "react-router-dom"

export default function LoginComponent() {

    const [username, setUsername] = useState('vivek')
    const [password, setPassword] = useState('pass')
    const [showSuccessMsg, setShowSuccessMsg] = useState(false)
    const [showErrorMsg, setShowErrorMsg] = useState(false)
    const navigate = useNavigate()

    return (
        <div className="Login">
            {showSuccessMsg && <div className="successMsg">authenticated successfully</div>}
            {showErrorMsg && <div className="errorMsg">authentication failed</div>}
            <div className="LoginForm">
                <div>
                    <label>username : </label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange}></input>
                </div>
                <div>
                    <label>password : </label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange}></input>
                </div>
                <div>
                    <button type="button" name="login" onClick={handleSubmit}>Login</button>
                </div>
            </div>
        </div>
    )

    function handleUsernameChange(event) {
        setUsername(event.target.value)
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value)
    }

    function handleSubmit(event) {
        if (username === 'vivek' && password === 'password') {
            setShowSuccessMsg(true)
            setShowErrorMsg(false)
            navigate(`/welcome/${username}`)
        } else {
            setShowSuccessMsg(false)
            setShowErrorMsg(true)
        }
    }
}