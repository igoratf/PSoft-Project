import axios from '../auth-axios/axios';


export default {
    registerDiscipline(discipline) {
        console.log(discipline)
       return axios.put('/disciplines', discipline)
    },

    getDisciplines() {
        return axios.get('/disciplines')
    },

    deleteDiscipline(code) {
        return axios.delete('/course/disciplines/{code}')
    },

    submitEnrollment(courseList) {
        return axios.put('/coordination/enroll', courseList)
    },

    getEnrollments() {
        return axios.get('/students')
    }

}