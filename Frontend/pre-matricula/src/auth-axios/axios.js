import axios from 'axios'

const API_URL = 'http://25.0.134.235:8080'

export default axios.create({
  baseURL: API_URL,
  headers: {
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + localStorage.token
  }
})