<template>
  <div class="main">
    <LoginNavVue />
    <MomChiVue />
    <RouterView />
  </div>
</template>

<script setup>
import MomChiVue from "./components/common/MomChi.vue";
import LoginNavVue from "./components/common/LoginNav.vue";
</script>

<style scoped>
.main{
  min-width: 1100px;
}
</style>
