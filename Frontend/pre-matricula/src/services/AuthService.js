import firebase from 'firebase/app';
import 'firebase/auth';
import router from '../router';

export default {
signInWithGoogle() {
    const provider = new firebase.auth.GoogleAuthProvider()
      provider.setCustomParameters({hd: 'ccc.ufcg.edu.br'});
      return firebase.auth().signInWithPopup(provider)
    },

signOut() {
    return firebase.auth().signOut()
    }
}