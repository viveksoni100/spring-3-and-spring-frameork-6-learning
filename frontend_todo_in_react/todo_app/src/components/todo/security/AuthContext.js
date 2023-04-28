import { createContext, useContext, useState } from "react";

export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)

export default function AuthProvider({ children }) {

    const [number, setNumber] = useState(0)
    const [isAuthenticated, setAuthenticated] = useState(false)

    // setInterval(
    //     () => setNumber(number + 1), 5000
    // )

    function login(username, password) {
        if (username === 'vivek' && password === 'password') {
            setAuthenticated(true)
            return true
        } else {
            setAuthenticated(false)
            return false
        }
    }

    // function logout() {
    //     setAuthenticated(false)
    // }

    const valueToBeShared = { number, isAuthenticated, setAuthenticated, login }
    return (
        < AuthContext.Provider value = { valueToBeShared } >
            { children }
        </AuthContext.Provider>
    )
}