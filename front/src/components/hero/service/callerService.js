import axios from 'axios'
import { accountService } from "./accountService";


const Axios = axios.create({
    baseURL: 'http://localhost:9090'
})


Axios.interceptors.request.use(request => {

    if(accountService.isLogged()){
        request.headers.Authorization = 'Bearer '+accountService.getToken()
    }

    return request
})

Axios.interceptors.response.use(response => {
    return response
}, error => {
    if(error.response.status === 401){
        accountService.logout()
        window.location = '/admin'
    }else{
        return Promise.reject(error)
    }
})

export default Axios;