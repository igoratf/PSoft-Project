import Vue from 'vue'
import App from './App.vue'
import router from './router'
import firebase from 'firebase/app';
import 'firebase/auth';

Vue.config.productionTip = false

// Initialize firebase
var config = {
  apiKey: "AIzaSyBaDErOT7wcfaFbtJXFG3MVx84IF-K-cJE",
  authDomain: "prematricula-b0cd0.firebaseapp.com",
  databaseURL: "https://prematricula-b0cd0.firebaseio.com",
  projectId: "prematricula-b0cd0",
  storageBucket: "prematricula-b0cd0.appspot.com",
  messagingSenderId: "539700258396"
};
firebase.initializeApp(config);


new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
