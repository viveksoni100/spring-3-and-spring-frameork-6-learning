import {apiClient} from "./ApiClient";

export const executeBasicAuthenticationService = () => apiClient.get(`/basicauth`);