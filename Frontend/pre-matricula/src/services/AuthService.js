import firebase from 'firebase/app';
import 'firebase/auth';
import axios from '../auth-axios/axios';

export default {
signInWithGoogle() {
    firebase.auth().useDeviceLanguage();
    const provider = new firebase.auth.GoogleAuthProvider()
    provider.setCustomParameters({hd: 'ccc.ufcg.edu.br'})
    return firebase.auth().signInWithPopup(provider)
    },

signOut() {
    localStorage.clear();
    return firebase.auth().signOut()
    },

checkCurrentLogin() {
    if (localStorage.token) {
        return true;
    } else {
        return false;
    }
},


getCurrentUser() {
    let user = localStorage.user
    if (user) {
        return JSON.parse(user)
    } else {
        return undefined
    }
},

getUserRole() {
    let user = firebase.auth().currentUser;
    if (user) {
        user.role = 'admin'
        user.registered = false
        return user.role
    } else {
        return ''
    }
    

}
}