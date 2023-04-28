import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom"
import ErrorComponent from "./ErrorComponent"
import FooterComponent from "./FooterComponent"
import HeaderComponent from "./HeaderComponent"
import WelcomeComponent from "./WelcomeComponent"
import LogoutComponent from "./LogoutComponent"
import ListTodosComponent from "./ListTodosComponent"
import LoginComponent from "./LoginComponent"
import AuthProvider, { useAuth } from "./security/AuthContext"
import './TodoApp.css'
import React from "react";

function AuthenticatedRoute({ children }) {
    const authContext = useAuth()
    if (authContext.isAuthenticated)
        return children
    return <Navigate to="/"/>
}

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <AuthProvider>
                <BrowserRouter>
                    <HeaderComponent/>
                    <Routes>
                        <Route path='/' element={<LoginComponent></LoginComponent>}></Route>
                        <Route path='/login' element={<LoginComponent></LoginComponent>}></Route>
                        <Route path='/welcome/:username' element={
                            <AuthenticatedRoute>
                                <WelcomeComponent></WelcomeComponent>
                            </AuthenticatedRoute>}/>
                        <Route path='/todos' element={
                            <AuthenticatedRoute>
                                <ListTodosComponent></ListTodosComponent>
                            </AuthenticatedRoute>}/>
                        <Route path='/logout' element={
                            <AuthenticatedRoute>
                                <LogoutComponent></LogoutComponent>
                            </AuthenticatedRoute>}/>
                        <Route path='*' element={<ErrorComponent></ErrorComponent>}></Route>
                    </Routes>
                    <FooterComponent/>
                </BrowserRouter>
            </AuthProvider>
        </div>
    )
}