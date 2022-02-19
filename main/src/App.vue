<template>
  <div class="main">
    <Fio lastName="Кислицын" firstName="Иван" middleName="Александрович" />
    <Vyatsu :results="results" />
    <Login class="login" />
  </div>
</template>

<script lang="ts">
import Vue from 'vue';
import axios from 'axios';
import Fio from '../../fio/src/components/Fio.vue';
import Vyatsu from '../../vyatsu/src/components/Vyatsu.vue';
import Login from '../../login_form/src/components/Login.vue';

const url = 'http://localhost:8080/admission/';

export default Vue.extend({
  name: 'App',
  components: {
    Fio,
    Vyatsu,
    Login,
  },
  data() {
    return { Fio, results: [] };
  },
  mounted() {
    axios
      .get(url)
      .then((response: any) => {
        console.log(response);
        this.results = response.data;
      })
      .catch((error: any) => console.log(error));
  },
});
</script>

<style>
.main {
  width: 100%;
}
</style>
