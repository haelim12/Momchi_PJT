<template>
  <div class="main">
    <LoginNavVue />
    <MomChiVue />
    <RouterView />
  </div>
  <Footer />
</template>

<script setup>
import MomChiVue from "./components/common/MomChi.vue";
import LoginNavVue from "./components/common/LoginNav.vue";
import Footer from "./components/common/Footer.vue";
</script>

<style scoped>
.main {
  min-width: 750px;
}
</style>
