<template>
  <div v-html="results"></div>
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
