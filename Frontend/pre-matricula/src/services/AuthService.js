import firebase from 'firebase/app';
import 'firebase/auth';

export default {
signInWithGoogle() {
const provider = new firebase.auth.GoogleAuthProvider()
    firebase.auth().signInWithPopup(provider)
    .then(data => console.log(data.user, data.credential.accessToken))
    .catch(error => alert(error.message))
    
    },
    signOut() {
    firebase.auth().signOut()
    .catch(error => alert(error.message))
    }

}