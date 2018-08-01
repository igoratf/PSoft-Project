import firebase from 'firebase/app';
import 'firebase/auth';
import axios from '../auth-axios/axios';
import router from '../router';

export default {
signInWithGoogle() {
    firebase.auth().useDeviceLanguage();
    const provider = new firebase.auth.GoogleAuthProvider()
    provider.setCustomParameters({hd: 'ccc.ufcg.edu.br'})
    return firebase.auth().signInWithPopup(provider)
    },

signOut() {
    router.replace("login")
    localStorage.clear();
    },

checkCurrentLogin() {
    if (localStorage.token) {
        return true;
    } else {
        return false;
    }
},

getCurrentUser() {
    let user = JSON.parse(localStorage.getItem('user'))
    if (user) {
        return user
    } else if (localStorage.getItem("token")) {
        console.log('to sem usuário')
        return this.getUser()
        .then((result) => {
            user = result.request.response;
            localStorage.setItem("user", user)
            return user
        })
        .catch((error) => {
            alert(error.message)
        })
    }
},

getUser() {
    return axios.get('/users')
},

getFirebaseUser() {
    return firebase.auth().currentUser;
}


}