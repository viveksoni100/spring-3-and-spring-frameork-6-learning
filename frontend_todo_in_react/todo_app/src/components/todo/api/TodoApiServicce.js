import axios from "axios";

const apiClient = axios.create({
    baseURL: 'http://localhost:9292'
});

export const retrieveTodosByUser = (username) => apiClient.get(`/users/${username}/todos`);
