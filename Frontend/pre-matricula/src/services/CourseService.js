import axios from '../auth-axios/axios';


export default {
    registerDiscipline(discipline) {
       return axios.put('/course/disciplines/put', {
        discipline
      })
    },

    studentEnroll(idToken, codeList) {
        return axios.put('/course/enroll', {
            studentID: idToken,
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