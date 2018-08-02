import axios from 'axios'

const API_URL = 'http://localhost:8080'
// const API_URL = 'http://25.0.134.235:8080'

export default axios.create({
  baseURL: API_URL,
  headers: {
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + localStorage.getItem('token')
  }
})
