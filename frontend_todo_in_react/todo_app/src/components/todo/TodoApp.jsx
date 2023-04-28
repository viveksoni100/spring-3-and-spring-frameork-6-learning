import { useState } from "react"
import { BrowserRouter, Link, Route, Routes, useNavigate, useParams } from "react-router-dom"
import './TodoApp.css'

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={<LoginComponent></LoginComponent>}></Route>
                    <Route path='/login' element={<LoginComponent></LoginComponent>}></Route>
                    <Route path='/welcome/:username' element={<WelcomeComponent></WelcomeComponent>}></Route>
                    <Route path='/todos' element={<ListTodosComponent></ListTodosComponent>}></Route>
                    
                    <Route path='*' element={<ErrorComponent></ErrorComponent>}></Route>
                </Routes>
            </BrowserRouter>
        </div>
    )
}

function LoginComponent() {

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

function WelcomeComponent() {

    const {username} = useParams()

    return (
        <div className="Welcome">
            Welcome Component - {username}
            <Link to="/todos">todos</Link>
        </div>
    )
}

function ErrorComponent() {
    return (
        <div className="ErrorComponent">
            હાલ ભાગ ડોફા
        </div>
    )
}

function ListTodosComponent() {

    const todos =[
        {id: 1, description: 'Learn AWS'},
        {id: 2, description: 'Learn Docker'},
        {id: 3, description: 'Learn gRPC'}
    ]

    return (
        <div className="ListTodosComponent">
            <table border="1">
                <thead>
                    <tr>
                        <td>id</td>
                        <td>description</td>
                    </tr>
                </thead>
                <tbody>
                    {todos.map(todo => (
                        <tr key={todo.id}>
                            <td>{todo.id}</td>
                            <td>{todo.description}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}