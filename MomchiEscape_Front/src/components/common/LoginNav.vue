<template>
  <div>
    <div class="login-bar">
      <button class="button" @click="toLogin">Login</button>
      <button class="button" @click="toRegist">Regist</button>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import { ref } from "vue";

const router = useRouter();

const toRegist = () => {
  router.push("/regist");
};

const toLogin = () => {
  router.push("/login");
};
</script>

<style scoped>
.login-bar {
  margin-top: 20px;
  margin-right: 10px;
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
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
</style>
