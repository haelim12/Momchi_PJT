<template>
  <div>
    <LoginNavVue />
    <MomChiVue />
    <RouterView />
  </div>
</template>

<script setup>
import MomChiVue from "./components/common/MomChi.vue";
import LoginNavVue from "./components/common/LoginNav.vue";
</script>

<style scoped></style>
