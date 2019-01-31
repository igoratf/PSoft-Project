import Vue from 'vue'
import App from './App.vue'
import router from './router'
import firebase from 'firebase/app';
import 'firebase/auth';
import axios from './auth-axios/axios';

Vue.config.productionTip = false

// Initialize firebase
var config = {
  apiKey: '<<apiKeyHere>>',
  authDomain: "prematricula-b0cd0.firebaseapp.com",
  databaseURL: "https://prematricula-b0cd0.firebaseio.com",
  projectId: "prematricula-b0cd0",
  storageBucket: "prematricula-b0cd0.appspot.com",
  messagingSenderId: "539700258396"
};
firebase.initializeApp(config);

export default firebase

Vue.prototype.$eventHub = new Vue();

new Vue({
  router,
  axios,
  render: h => h(App)
}).$mount('#app')
