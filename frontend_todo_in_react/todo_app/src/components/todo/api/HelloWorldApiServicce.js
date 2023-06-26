import axios from "axios";

const apiClient = axios.create({
    baseURL: 'http://localhost:9292'
});

export const retrieveHelloWorldBean = () => apiClient.get('/hello-world-bean');
export const retrieveHelloWorldBeanPathVariable = (username) => apiClient.get(`/hello-world/path-variable/${username}`, {
    headers: {
        Authorization: 'Basic dml2ZWs6cGFzc3dvcmQ='
    }
});
export const executeBasicAuthenticationService = (token) => apiClient.get(`/basicauth`, {
    headers: {
        Authorization: token
    }
});