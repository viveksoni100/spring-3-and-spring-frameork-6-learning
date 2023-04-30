import axios from "axios";

const apiClient = axios.create({
    baseURL: 'http://localhost:9292'
});

export const retrieveTodosByUserApi = (username) => apiClient.get(`/users/${username}/todos`);
export const deleteTodosByUserAndIdApi = (username, id) => apiClient.delete(`/users/${username}/todos/${id}`);
