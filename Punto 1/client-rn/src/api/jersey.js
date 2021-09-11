import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:8080/myapp/travel'
});


export default instance;
