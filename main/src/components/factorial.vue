<template>
<!-- eslint-disable max-len -->
    <div>
    <input id="input" type="number">
    <button id="send" v-on:click="Calculate">OK</button>
    <span id="result"></span>
    </div>
<!-- eslint-enable max-len -->
</template>

<script lang="ts">
/* eslint-disable */
import * as jsPlumbing from '../../../js_plumbing.js';

const inputs : HTMLInputElement = document.getElementById('input') as HTMLInputElement;
const sendBtn : HTMLButtonElement = document.getElementById('send') as HTMLButtonElement;
const resultText : HTMLSpanElement = document.getElementById('result') as HTMLSpanElement;

export default {
  data() {
    return {
      return: { result: null },
    };
  },
  components: {
  },
  props: {
    results: [],
  },
  methods: {
    Calculate() {
      const result = jsPlumbing.Module.ccall('factorial',
        'number',
        ['x'], [3]);
      console.log(result);
    },
  },
};
</script>
