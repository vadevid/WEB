<template>
  <div class="form-div">
    <img class="logo_big" src="../assets/logo.png">
     <form class="form">
        <img class="logo" src="../assets/logo.png">
        <h3 class="form_title">Вход</h3>
        <div class="desktop_input">
          <span>Логин: </span>
          <input type="text" class="form_input">
        </div>
        <div class="desktop_input">
          <span>Пароль: </span>
          <input type="password" class="form_input">
        </div>
        <div class="mobile_input">
          <input type="text" class="form_input" placeholder="Логин">
        </div>
        <div class="mobile_input">
            <input type="password" class="form_input" placeholder="Пароль">
        </div>
        <p>
          <input class="checkbox" id="input" type="checkbox">
          <label class="checkbox_text" for="input">Запомнить данные пользователя</label>
        </p>
        <p>
            <button class="form_btn">Войти</button>
        </p>
      </form>
  </div>
</template>

<script lang="ts">

export default {
};
</script>

<style>
.desktop_input {
  display: flex;
  flex-direction: column;
}
.form-div {
  display: flex;
}
.logo_big {
  width: 50%;
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
