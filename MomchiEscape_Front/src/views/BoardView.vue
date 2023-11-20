<template>
  <div>
    <TheHeaderNav />
    <div class="body-container">
      <div class="title">게시글</div>
      <button class="button" @click="toCreate">글 작성</button>
      <RouterView />
    </div>
  </div>
</template>

<script setup>
import TheHeaderNav from "../components/common/TheHeaderNav.vue";
import { useRouter } from "vue-router";
import { ref } from "vue";

const router = useRouter();

const toCreate = () => {
  router.push("/create");
};
</script>

<style scoped>
.body-container {
  width: 100%;
  height: 100vh;
  background-color: aquamarine;
  padding-top: 30px;
  padding-left: 6%;
  padding-right: 6%;
  box-sizing: border-box;
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
.title {
  font-size: 20px;
}
</style>
