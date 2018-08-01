import axios from '../auth-axios/axios';


export default {
    registerDiscipline(discipline) {
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
        return axios.get('/course/disciplines')
    },

    deleteDiscipline(code) {
        return axios.delete('/course/disciplines/{code}')
    }

}