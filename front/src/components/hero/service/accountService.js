import Axios from './callerService'
//import {jwt_decode} from 'jwt_decode'// Importez jwt_decode correctement
const jwt_decode = require('jwt-decode');

let login = (username, passwordL) => {
    return Axios.post(`http://localhost:9090/api/auth/signin`, { // Correction de l'URL d'authentification
        username: username,
        password: passwordL
    });
}

let saveToken = (token) => {
    localStorage.setItem('token', token);
    console.log('token', token);
}

let logout = () => {
    localStorage.removeItem('token');
}

let isLogged = () => {
    let token = localStorage.getItem('token');
    return !!token;
}

let getToken = () => {
    return localStorage.getItem('token');
}

let getTokenInfo = () => {
    return jwt_decode(getToken()); // Utilisez jwt_decode pour décoder le jeton
}

let getUserByUsername = (username) => {
    return Axios.get(`http://localhost:9090/api/auth/users/role/${username}`).then(res => res.data); // Correction de l'URL pour récupérer les informations de l'utilisateur par nom d'utilisateur
}

let saveRole = (roles) => {
    localStorage.setItem('role', roles);
}

let getRole = () => {
    return localStorage.getItem('role');
}

export const accountService = {
    login,
    saveToken,
    logout,
    isLogged,
    getToken,
    getTokenInfo,
    getUserByUsername,
    getRole,
    saveRole
};
