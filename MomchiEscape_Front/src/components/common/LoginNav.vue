<template>
  <div>
    <div v-if="isLoggedin" class="login-bar">
      <button class="button" @click="toLogin">Login</button>
      <button class="button" @click="toRegist">Regist</button>
    </div>
    <div v-if="!isLoggedin" class="login-bar">
      <div class="profile_name">{{ userStore.user.name }}님 안녕하세요</div>
      <div class="nav-blank"></div> 
      
      <img class="img" :src="logo" @click="toProfile"/> 
      <div class="nav-blank_1"></div> 
      <button class="button" @click="logout">Logout</button>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import { computed, onMounted, onUpdated, ref } from "vue";
import { useUserStore } from "@/stores/userStore";

const router = useRouter();
const userStore = useUserStore();
const logo = "/images/profile_chichi.png";

const isLoggedin = computed(() => {
  if (!userStore.user) {
    return true;
  }
  else {
    return false;
  }
});

const toRegist = () => {
  router.push("/regist");
};

const toLogin = () => {
  router.push("/login");
};

const logout = () => {
  localStorage.clear();
  window.location.reload();
};

const toProfile = () => {
  router.push("/profile");
}
</script>

<style scoped>
.login-bar {
  margin-top: 20px;
  margin-right: 10px;
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  align-items: center;
}
.img{
  width: 35px;
  padding: 2px;
}
.img:hover{
    cursor: pointer;
}
.button {
  width: 65px;
  height: 30px;
  font-size: 14px;
  border-radius: 20px;
  border: 0;
  background-color: #fce8f0;
  color: #333333b9;
  margin: 2px;
}
.button:hover {
  background-color: rgb(189, 188, 188);
  color: white;
  cursor: pointer;
}
.profile_name{
  font-size: 14px;
  color: rgb(67, 65, 65);
}
.nav-blank{
  width: 10px;
}
.nav-blank_1{
  width: 5px;
}
</style>
