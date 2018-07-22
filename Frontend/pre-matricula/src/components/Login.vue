<template>
  <div class="login-container">
    <div class="container">
      <div class="row">
        <div class="col"></div>
        <div class="col">
          <div class="form-container">
            <h1> Login </h1>
            <hr>
            <form>

              <div class="form-group">
                <label for="exampleInputEmail1">Email address</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
              </div>

              <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
              </div>

              <div class="row">
                <div class="col">
                  <small>
                    <a href="#">Change password</a>
                  </small>
                </div>

                <div class="col">
                  <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">
                      <small>Remember me</small>
                    </label>
                  </div>
                </div>
              </div>
              <br>

              <div class="form-group">
                <button type="submit" class="btn btn-primary">Login</button>
              </div>
              <hr>

              <button class="btn btn-google" @click="signInWithGoogle">
                <i class="fab fa-google"></i> Sign in with Google</button>

            </form>
          </div>
        </div>
        <div class="col"></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      authUser: null
    };
  },
  methods: {
    signInWithGoogle() {
       const provider = new firebase.auth.GoogleAuthProvider()
      firebase.auth().signInWithPopup(provider)
      .then(data => console.log(data.user, data.credential.accessToken))
      .catch(error => alert(error.message))
      
    }
  },
  created() {
  firebase.auth().onAuthStateChanged(user => {
    this.authUser = user;
  });
  }
  
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.form-container {
  width: 100%;
  border: 2px solid black;
  padding: 12px;
}

.forgot-pass {
  float: left;
}

.check-remember {
  float: right;
}

.btn-google {
  color: white;
  background: #b71c1c;
}
</style>
