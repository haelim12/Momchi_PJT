<template>
  <div class="main-container">
    <iframe
      class="video-player"
      :src="video.videoUrl"
      controls="2"
      frameborder="0"
      allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
      allowfullscreen
    ></iframe>
    <div class="info">
      <div class="video-content" :style="{ 'background-color': buttonColor }">레벨 : {{ video.level }}</div>
      <button v-if="isLoggedIn" class="video-start-button" @click="recordClick">운동 시작</button>
      <div class="video-cnt">함께 운동중 {{ video.viewCnt }} 명</div>
    </div>
  </div>
</template>

<script setup>
import { computed, onMounted, ref, watchEffect } from "vue";
import { useRouter } from "vue-router";
import { useUserStore } from "@/stores/userStore";

const userStore = useUserStore();
const router = useRouter();

const isLoggedIn = computed(() => {
  const user = userStore.user;
  if (user) {
    return true;
  }
  else {
    return false;
  }
})

const props = defineProps({
  video: {
    type: Object,
    required: true,
  },
});

watchEffect(() => {
});


const buttonColor = computed(() => {
    switch (props.video.level) {
    case "초보":
      return "#F8CED8"; 
      break;
    case "중수":
      return "#F092A6"; 
      break;
    case "고수":
      return "#E95776"; 
      break;
    default:
      return ""; 
  }
})

function recordClick() {
  localStorage.setItem("video", JSON.stringify(props.video));
  router.push("/record");
}

</script>

<style scoped>
* {
  box-sizing: border-box;
}
.main-container {
  width: 49%;
  min-width: 250px;
  min-height: 200px;
  margin-bottom: 20px;
  padding: 5px;
  border: solid 1px rgb(178, 175, 175);
  border-radius: 5px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
.video-player {
  aspect-ratio: 16/9;
  border-radius: 5px;
}
.info {
  margin-top: 5px;
  padding-top: 5px;
  padding-left: 10px;
  padding-right: 20px;
  height:40px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.video-cnt{
  font-size: 14px;
  margin-bottom: 5px;
  color: #333333;
}
.video-start-button {
  width: 80px;
  height: 30px;
  font-size: 14px;
  border-radius: 20px;
  justify-content: center;
  align-items: center;
  border: 2px solid rgba(65, 65, 65, 0.31);
  background-color: #ffffff;
  color: #333333b9;
  margin: 2px;
}
.video-start-button:hover {
  color: white;
  border: none;
  background-color: #F092A6;
  cursor: pointer;
}
.video-content {
  font-size: 12px;
  color: white;
  background-color:  #f3c4cfe3;
  width: 80px;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 100px;
}
</style>
