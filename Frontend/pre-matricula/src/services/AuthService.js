import firebase from 'firebase/app';
import 'firebase/auth';
import router from '../router';

export default {
signInWithGoogle() {
const provider = new firebase.auth.GoogleAuthProvider()
provider.setCustomParameters({hd: 'ccc.ufcg.edu.br'});
    firebase.auth().signInWithPopup(provider)
    .then(data => {
        console.log(data.user, data.credential.accessToken);
        router.push('cadastro');
        })
    .catch(error => alert(error.message))
    },
    signOut() {
    firebase.auth().signOut()
    .then(() => router.push('/login'))
    .catch(error => alert(error.message))
    }

}