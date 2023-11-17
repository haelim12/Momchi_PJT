<template>
  <div class="main-container">
      <div class="title">
        인기 순위
      </div>
      <div class="body">
        <div class="popular-each">
          <img class="img" :src="logo"/>
          <div class="text">
            User1
          </div>
        </div>
        <div class="popular-each">
          <img class="img" :src="logo"/>
          <div class="text">
            User2
          </div>
        </div>
      </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import logo from "/images/pinkchichiface.png";

const popularList = ref([]);
const popularPerson = ref([]);
// 인기 순위 배열로 받아와서 v-for로 출력 하면 될듯
// 동영상이었나..?


</script>
<style scoped>
*{
  box-sizing: border-box;
  color: #565959;
}
.main-container {
  width: 29%;
  min-height: 600px;
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
.popular-each{
  padding-top: 10px;
  padding-left: 10px;
  margin-bottom: 10px;
  display: flex;
  align-items: center;
}
.img{
  width: 30px;
}
.text{
  padding-left: 20px;
}
</style>
