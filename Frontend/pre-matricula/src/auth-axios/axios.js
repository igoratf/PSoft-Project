import axios from 'axios'

const API_URL = 'http://191.35.72.33:8080'

export default axios.create({
  baseURL: API_URL,
  headers: {
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + localStorage.token
  }
})