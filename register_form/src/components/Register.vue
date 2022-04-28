<template>
  <div class="form-div">
    <img class="logo_big" src="../assets/logo.png">
     <form class="form">
        <img class="logo" src="../assets/logo.png">
        <h3 class="form_title">Регистрация</h3>
        <div class="desktop_input">
          <span class="email-text">Email: </span>
          <input type="text" class="form_input" id="email-text">
        </div>
        <div class="desktop_input">
          <span>Логин: </span>
          <input type="text" class="form_input" id="login-text">
        </div>
        <div class="desktop_input">
          <span>Пароль: </span>
          <input type="password" class="form_input" id="pass-text">
        </div>
        <div class="desktop_input">
          <span>Повторить пароль: </span>
          <input type="password" class="form_input" id="pass2-text">
        </div>
        <div class="mobile_input">
          <input type="text" class="form_input" placeholder="Email" id="email-text">
        </div>
        <div class="mobile_input">
          <input type="text" class="form_input" id="login-text" placeholder="Логин">
        </div>
        <div class="mobile_input">
            <input type="password" class="form_input" id="pass-text" placeholder="Пароль">
        </div>
        <div class="mobile_input">
            <input type="password" class="form_input" id="pass2-text"
            placeholder="Повторите пароль">
        </div>
        <p>
          <input class="checkbox" id="input" type="checkbox">
          <label class="checkbox_text" for="input">Запомнить данные пользователя</label>
        </p>
        <p>
            <button class="form_btn" type="button" v-on:click="signUp">Зарегистрироваться</button>
        </p>
      </form>
  </div>
</template>

<script lang="ts">
/* eslint-disable */
import axios from 'axios';

export default {
  methods: {
    signUp() {
      const email :HTMLInputElement = document.getElementById('email-text') as HTMLInputElement;
      const login :HTMLInputElement = document.getElementById('login-text') as HTMLInputElement;
      const pass :HTMLInputElement = document.getElementById('pass-text') as HTMLInputElement;
      const pass2 :HTMLInputElement = document.getElementById('pass2-text') as HTMLInputElement;
      const config = {
        url: 'api/user/registration',
      };
      const data = {
        'login': login.value,
        'email': email.value,
      };
      if (email.value === '') {
        alert('Введите почту');
        return;
      }
      if (login.value === '') {
        alert('Введите логин');
        return;
      }
      if (pass.value === '') {
        alert('Введите пароль');
        return;
      }
      if (pass.value !== pass2.value) {
        alert('Пароли не совпадают');
        return;
      }
      axios.post(config.url, data, { headers: { 'x-mock-match-request-body': true, 'Content-Type': 'application/json' } })
        .then((response) => {
          if (!response.data.verification) {
            alert('Логин уже занят');
          } else {
            alert('Успешно');
          }
        })
        .catch((error) => {
          alert('Успешно');
        });
    },
  },
};
</script>

<style>
.desktop_input {
  display: flex;
  flex-direction: column;
}
.form-div {
  display: flex;
  align-items: center;
}
.logo_big {
  width: 40%;
  background: #444;
}
.mobile_input {
  display:none;
}
.logo {
  display: none;
  width: 20%;
  padding-top: 10px;
}
.form {
  display: flex;
  flex-direction: column;
  width: 50%;
  margin-left: 10px;
}
.form_title {
  font-size: 1.5rem;
  font-weight: 500;
  color: #333;
}
.form_input {
  margin: 5px 0;
  width: 90%;
  padding: 10px;
  border: solid 1px #333;
  font-size: inherit;
}
.form_btn {
  border: none;
  cursor: pointer;
  font-size: inherit;
  background-color: #03a9f4;
  color: #fff;
  padding: 10px 50px;
}
@media (max-width: 768px) {
  .desktop_input {
    display: none;
  }
  .checkbox_text{
    font-size: 32px;
  }
  .mobile_input {
    display: flex;
    width: 100%;
  }
  .form_btn {
    width: 100%;
    font-size: 32px;
    padding: 20px 100px;
  }
  .form_title {
    font-size: 48px;
  }
  .form_input {
    font-size: 32px;
  }
  .form {
    align-items: center;
    width: 100vw;
  }
  .logo_big {
    display: none;
  }
  .logo {
    display: flex;
  }
}
@media (max-width: 480px) {
  .logo {
    width: 50%;
  }
  .form-div {
    width: 100%;
  }
}
</style>
