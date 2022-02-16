<template>
  <div>
    <Fio lastName="Кислицын" firstName="Иван" middleName="Александрович" />
  </div>
</template>

<script lang="ts">
import Vue from 'vue';
import Fio from '../../fio/src/components/Fio.vue';

export default Vue.extend({
  name: 'App',
  components: {
    Fio,
  },
  data() {
    return { results: [] };
  },
});
</script>
