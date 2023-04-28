import { BrowserRouter, Route, Routes } from "react-router-dom"
import ErrorComponent from "./ErrorComponent"
import FooterComponent from "./FooterComponent"
import HeaderComponent from "./HeaderComponent"
import WelcomeComponent from "./WelcomeComponent"
import LogoutComponent from "./LogoutComponent"
import ListTodosComponent from "./ListTodosComponent"
import LoginComponent from "./LoginComponent"
import './TodoApp.css'

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <BrowserRouter>
            <HeaderComponent></HeaderComponent>
            <Routes>
                <Route path='/' element={<LoginComponent></LoginComponent>}></Route>
                <Route path='/login' element={<LoginComponent></LoginComponent>}></Route>
                <Route path='/welcome/:username' element={<WelcomeComponent></WelcomeComponent>}></Route>
                <Route path='/todos' element={<ListTodosComponent></ListTodosComponent>}></Route>
                <Route path='/logout' element={<LogoutComponent></LogoutComponent>}></Route>
                <Route path='*' element={<ErrorComponent></ErrorComponent>}></Route>
            </Routes>
            <FooterComponent></FooterComponent>
            </BrowserRouter>
        </div>
    )
}