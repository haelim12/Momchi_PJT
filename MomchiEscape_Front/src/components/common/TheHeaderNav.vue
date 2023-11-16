<template>
  <div class="nav--container">
    <img :src="logo" alt="없어" />
    <header>
      <nav>
        <RouterLink to="/">Home</RouterLink> |
        <RouterLink to="/youtube">Youtube</RouterLink> |
        <RouterLink :to="{ name: 'boardList' }">BoardList</RouterLink> |
        <RouterLink :to="{ name: 'boardCreate' }">BoardCreate</RouterLink> |
        <RouterLink :to="{ name: 'kakao' }">Kakao</RouterLink> |
        <RouterLink :to="{ name: 'tmdb' }">TMDB</RouterLink>
      </nav>
    </header>
  </div>
</template>

<script setup>
import logo from "/images/chichiface.png";
</script>

<style scoped>
img {
  width: 70px;
  padding-bottom: 30px;
  height: auto;
  text-align: center;
}
#container {
  text-align: center;
}

.nav--container {
  padding: 30px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

nav a {
  font-weight: bold;
  text-decoration: none;
  color: #404141;
}

nav a.router-link-exact-active {
  color: #eac3c9;
}
</style>
