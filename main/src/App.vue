<template>
  <div class="main">
    <Table/>
    <div class="buttons">
      <button class="login-btn" v-on:click='toggleStyleLogin'>Логин</button>
      <button class="register-btn" v-on:click='toggleStyleRegister'>Регистрация</button>
    </div>
    <Register class="register"/>
    <Login class="login"/>
  </div>
</template>
<script lang="ts">
import Vue from 'vue';
import axios from 'axios';
import Table from '../../table/src/components/table.vue';
import Login from '../../login_form/src/components/Login.vue';
import Register from '../../register_form/src/components/Register.vue';

export default {
  name: 'App',
  props: {
    results: [],
  },
  components: {
    Table,
    Login,
    Register,
  },
  methods: {
    toggleStyleLogin() {
      const login :HTMLDivElement = document.querySelector('.login') as HTMLDivElement;
      const register :HTMLDivElement = document.querySelector('.register') as HTMLDivElement;
      login.style.display = 'flex';
      register.style.display = 'none';
    },
    toggleStyleRegister() {
      const login :HTMLDivElement = document.querySelector('.login') as HTMLDivElement;
      const register :HTMLDivElement = document.querySelector('.register') as HTMLDivElement;
      login.style.display = 'none';
      register.style.display = 'flex';
    },
  },
};

</script>

<style>
  .conteiner table{
    border-radius: 1px;
  }
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
