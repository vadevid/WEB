<template>
  <div>
    <Fio lastName="Кислицын" firstName="Иван" middleName="Александрович" />
    <Vyatsu :results="results" />
  </div>
</template>

<script lang="ts">
import Vue from 'vue';
import axios from 'axios';
import Fio from '../../fio/src/components/Fio.vue';
import Vyatsu from '../../vyatsu/src/components/Vyatsu.vue';

const url = 'http://localhost:8080/admission/';

export default Vue.extend({
  name: 'App',
  components: {
    Fio, Vyatsu,
  },
  data() {
    return { Fio, results: [] };
  },
  mounted() {
    axios.get(url).then((response: any) => {
      console.log(response);
      this.results = response.data;
    }).catch((error: any) => console.log(error));
  },
});
</script>
