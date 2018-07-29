import firebase from 'firebase/app';
import 'firebase/auth';

export default {
signInWithGoogle() {
    firebase.auth().useDeviceLanguage();
    const provider = new firebase.auth.GoogleAuthProvider()
    provider.addScope('email')
    provider.setCustomParameters({hd: 'ccc.ufcg.edu.br'})
    return firebase.auth().signInWithPopup(provider)
    },

signOut() {
    return firebase.auth().signOut()
    },

adminSignIn(email, password) {
    return firebase.auth().signInWithEmailAndPassword(email, password)
},

checkCurrentLogin() {
    if (localStorage.token) {
        return true;
    } else {
        return false;
    }
}
}