<template>
  <div class="nav--container">
    <header>
      <div class="menu-bar">
        <RouterLink to="/">Home</RouterLink> |
        <RouterLink to="/youtube">Video</RouterLink> |
        <RouterLink :to="{ name: 'board' }">Board</RouterLink>
      </div>
    </header>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import { ref } from "vue";

const router = useRouter();

const isHover = ref(false);
</script>

<style scoped>
.logo-img {
  width: auto;
  padding-bottom: 50px;
  height: 90px;
  text-align: center;
}
.logo-img:hover {
  cursor: pointer;
}

#container {
  text-align: center;
}

.nav--container {
  width: 100%;
  height: 50px;
  padding-top: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
  border-bottom: dotted 4px rgb(210, 210, 210);
}

.menu-bar a {
  font-weight: bold;
  text-decoration: none;
  color: #404141;
}

.menu-bar a.router-link-exact-active {
  color: #eac3c9;
}
</style>
