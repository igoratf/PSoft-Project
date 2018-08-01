import axios from '../auth-axios/axios';


export default {
    registerDiscipline(discipline) {
        console.log(discipline)
       return axios.put('/disciplines', {
        discipline
      })
    },

    studentEnroll(codeList) {
        return axios.put('/course/enroll', {
            codes: codeList
        })
    },

    getDisciplines() {
        return axios.get('/disciplines')
    },

    deleteDiscipline(code) {
        return axios.delete('/course/disciplines/{code}')
    }

}