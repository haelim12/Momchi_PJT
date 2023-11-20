<template>
  <div>
    <TheHeaderNav />
    <div class="body-container">
      <div class="title-container">
        <div class="title">운동영상</div>
        <div class="video-nav">
          <div class="nav-blank"></div>
            <div class="nav-button" @click="level1Click" :class="{ active: level1 }"> 초급 </div>
            <div class="nav-button" @click="level2Click" :class="{ active: level2 }"> 중급 </div>
            <div class="nav-button" @click="level3Click" :class="{ active: level3 }"> 고급 </div>
        </div>
      </div>
      <div v-for="index in Math.ceil(videoList.length / 2)" :key="index">
        <div class="video-pair">
          <YoutbeVideoListItem :video="videoList[(index - 1) * 2]" />
          <YoutbeVideoListItem
            :video="videoList[(index - 1) * 2 + 1]"
            v-if="videoList[(index - 1) * 2 + 1]"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import TheHeaderNav from "@/components/common/TheHeaderNav.vue";
import YoutbeVideoListItem from "@/components/youtube/YoutubeVideoListItem.vue";
import { onMounted, ref } from "vue";
import { getVideos } from "@/util/VideoApi";

const level1 = ref(false);
const level2 = ref(false);
const level3 = ref(false);

const videoList = ref([]);

onMounted(() => {
  getVideos()
    .then((data) => {
      console.log(data);
      videoList.value = data;
    })
    .catch(() => {
      
    })
})

const level1Click = () => {
    level1.value = true;
  level2.value = false;
  level3.value = false;

}
const level2Click = () => {
  level1.value = false;
  level2.value = true;
  level3.value = false;
}
const level3Click = () => {
  level1.value = false;
  level2.value = false;
  level3.value = true;
}
</script>

<style scoped>
* {
  box-sizing: border-box;
}
.title-container{
  display: flex;
  align-items: center;
  height: 40px;
  margin-bottom: 20px;
  margin-right: 10px;
  justify-content: space-between;
}
.body-container {
  width: 100%;
  height: 100vh;
  padding-top: 30px;
  padding-left: 6%;
  padding-right: 6%;
  box-sizing: border-box;
}
.title {
  font-size: 20px;
}
.video-nav{
  display: flex;
  align-items: center;
}
.nav-button{
  font-size: 14px;
  color: white;
  background-color:  #f3c4cfe3;
  width: 60px;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 100px;
  margin-left: 10px;
}
.nav-button:hover{
  cursor: pointer;
}
.active{
  background-color: #F092A6;
}
.video-pair {
  width: 100%;
  display: flex;
  justify-content: space-between;
}
</style>
