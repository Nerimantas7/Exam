import axios from "axios";
import { getToken } from "./AuthService";

const REST_API_BASE_URL = 'http://localhost:8080/api/advert';

// Add a request interceptor
axios.interceptors.request.use(function (config) {

    config.headers['Authorization'] = getToken();

    return config;

  }, function (error) {
    
    return Promise.reject(error);
  });

export const listAdverts = () => {
    return axios.get(REST_API_BASE_URL);
}

export const createAdvert = (advert) => axios.post(REST_API_BASE_URL, advert);

export const getAdvert = (advertId) => axios.get(REST_API_BASE_URL + '/' + advertId);

export const updateAdvert = (advertId, advert) => axios.put(REST_API_BASE_URL + '/' + advertId, advert);

export const deleteAdvert = (advertId) => axios.delete(REST_API_BASE_URL + '/' + advertId);