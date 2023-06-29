import {apiClient} from './ApiClient';

export const retrieveHelloWorldBeanPathVariable = (username) => apiClient.get(`/hello-world/path-variable/${username}`);