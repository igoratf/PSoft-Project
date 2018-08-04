import axios from 'axios'

const API_URL = 'https://prematriculapp.herokuapp.com'
// const API_URL = 'http://25.0.134.235:8080'

axios.defaults.headers = {
  'Content-Type': 'application/json',
  Authorization: 'Bearer ' + localStorage.getItem('token'),
  withCredentials: true
}

export default axios.create({
  baseURL: API_URL
})


