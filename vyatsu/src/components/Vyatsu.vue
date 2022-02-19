<template>
  <iframe :srcdoc="results" class="frame" id="frame"></iframe>
</template>

<script lang="ts">
export default {
  props: {
    results: [],
  },
};
</script>

<style>
.frame {
  width: 100%;
  height: 650px;
}
</style>
