<template>
  <div class="main">
    <Fio lastName="Кислицын" firstName="Иван" middleName="Александрович" />
    <Vyatsu :results="results" />
    <div class="buttons">
      <button class="login-btn" v-on:click='toggleStyleLogin'>Логин</button>
      <button class="register-btn" v-on:click='toggleStyleRegister'>Регистрация</button>
    </div>
    <Login class="login"/>
    <Register class="register" />
  </div>
</template>

<script lang="ts">
import Vue from 'vue';
import axios from 'axios';
import Fio from '../../fio/src/components/Fio.vue';
import Vyatsu from '../../vyatsu/src/components/Vyatsu.vue';
import Login from '../../login_form/src/components/Login.vue';
import Register from '../../register_form/src/components/Register.vue';

const url = 'http://localhost:8080/admission/';
export default Vue.extend({
  name: 'App',
  components: {
    Fio,
    Vyatsu,
    Login,
    Register,
  },
  data() {
    return { Fio, results: [] };
  },
  mounted() {
    axios
      .get(url)
      .then((response: any) => {
        this.results = response.data;
      })
      .catch((error: any) => console.log(error));
  },
  methods: {
    toggleStyleLogin() {
      const login :HTMLDivElement = document.querySelector('.login');
      const register :HTMLDivElement = document.querySelector('.register');
      login.style.display = 'flex';
      register.style.display = 'none';
    },
    toggleStyleRegister() {
      const login :HTMLDivElement = document.querySelector('.login');
      const register :HTMLDivElement = document.querySelector('.register');
      login.style.display = 'none';
      register.style.display = 'flex';
    },
  },
});
</script>

<style>
.main {
  width: 100%;
}
.register {
  display: none;
}
.buttons {
  display: flex;
  justify-content: center;
  width: 100%;
  margin: 10px 0;
}
.login-btn {
  background-color: purple;
  margin-right: 100px;
  padding: 10px 20px;
  border-radius: 40px;
  color: white;
}
.register-btn {
  background-color: purple;
  margin-left: 100px;
  padding: 10px 20px;
  border-radius: 40px;
  color: white;
}
</style>
