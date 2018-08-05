import axios from 'axios'

const API_URL = 'https://prematriculapp.herokuapp.com'
// const API_URL = 'http://25.0.134.235:8080'

var instance = axios.create({
  baseURL: API_URL
})

export default instance


