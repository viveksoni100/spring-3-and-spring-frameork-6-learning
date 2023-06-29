import {createContext, useContext, useState} from "react";
import {apiClient} from "../api/ApiClient";
import {executeBasicAuthenticationService} from "../api/AuthenticationApiService";

export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export default function AuthProvider({children}) {

    const [isAuthenticated, setAuthenticated] = useState(false);
    const [username, setUsername] = useState(null);
    const [token, setToken] = useState(null);

    async function login(username, password) {

        const baToken = "Basic " + window.btoa(username + ":" + password);

        try {
            const res = await executeBasicAuthenticationService(baToken);

            if (res.status === 200) {
                setAuthenticated(true);
                setUsername(username);
                setToken(baToken);

                apiClient.interceptors.request.use(
                    (config) => {
                        config.headers.Authorization = baToken;
                        return config;
                    }
                );

                return true
            } else {
                logout();
                return false
            }
        } catch (err) {
            logout();
        }
    }

    function logout() {
        setAuthenticated(false);
        setToken(null);
        setUsername(null);
    }

    const valueToBeShared = {isAuthenticated, login, logout, username, token};
    return (
        <AuthContext.Provider value={valueToBeShared}>
            {children}
        </AuthContext.Provider>
    )
}