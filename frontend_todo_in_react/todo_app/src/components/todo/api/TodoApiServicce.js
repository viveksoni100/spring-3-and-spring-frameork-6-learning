import axios from "axios";

const apiClient = axios.create({
    baseURL: 'http://localhost:9292'
})

export const retrieveHelloWorldBean = () => apiClient.get('/hello-world-bean')
export const retrieveHelloWorldBeanPathVariable = (username) => apiClient.get(`/hello-world/path-variable/${username}`)
