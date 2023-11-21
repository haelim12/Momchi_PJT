<template>
  <div class="main-container">
      <div class="title">
        운동 순위
      </div>
      <div class="body">
        <div v-for="(user, index) in userStore.popularUsers" :key="user.id" class="popular-each">
          <div class="person-container">
            <img class="img" :src="logo" />
            <div class="text">
              {{ user.nickname }}
            </div>
          </div>
          <div class="text">{{ index+1 }}위</div>
        </div>
      </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { getPopularUser } from "@/util/UserApi";
import { useUserStore } from "@/stores/userStore";
import logo from "/images/pinkchichiface.png";

const userStore = useUserStore();
onMounted(() => {
  getPopularUser()
    .then((data) => {
      userStore.popularUsers = data;
  })
})

</script>
<style scoped>
*{
  box-sizing: border-box;
  color: #565959;
}
.main-container {
  width: 29%;
  min-height: 600px;
  max-width: 400px;
  margin-top: 20px;
  background-color:rgb(241, 241, 241);
  border-radius: 10px;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.title{
  height: 50px;
  width: 100%;
  font-size: 20px;
  padding-top: 15px;
  padding-left: 15px;
  padding-bottom: 5px;
  border-bottom: dotted 2px white;
}
.body{
  width: 100%;
  min-height: 500px;
  padding-top: 10px;
  padding-left: 5px;
}
.person-container{
  margin-top: 5px;
  display: flex;
  align-items: center;
}
.popular-each{
  margin-top: 5px;
  padding-left: 15px;
  padding-right: 25px;
  margin-bottom: 10px;
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.img{
  width: 30px;
}
.text{
  font-size: 15px;
  padding-left: 20px;
}
</style>
