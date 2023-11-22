<template>
  <TheHeaderNav />
  <div class="body-container">
    <div class="title-container">
      <div class="title">운동 기록</div>
    </div>
    <div class="main-container">
      <iframe
        class="video-player"
        :src="video.videoUrl"
        frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
        allowfullscreen
      ></iframe>
      <div class="stopwatch">{{ formattedTime }}</div>
      <div class="button-container">
        <button class="exercise-button" @click="startStopwatch">
          시작하기
        </button>
        <button class="exercise-button" @click="pauseStopwatch">
          잠깐 쉬기 ...
        </button>
        <button class="exercise-button" @click="stopStopwatch">
          이제 운동 그만 ⚰️
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import TheHeaderNav from "../components/common/TheHeaderNav.vue";
import { useRouter } from "vue-router";
import { computed, onMounted, ref, onUnmounted } from "vue";
import { registRecordApi } from "@/util/RecordApi.js";
import { useUserStore } from "@/stores/userStore";

const router = useRouter();
const video = computed(() => {
  return JSON.parse(localStorage.getItem("video"));
});
const userStore = useUserStore();
const elapsedSeconds = ref(0);
const intervalId = ref(null);
const isPaused = ref(true);

const formattedTime = computed(() => {
  const minutes = Math.floor(elapsedSeconds.value / 60);
  const seconds = elapsedSeconds.value % 60;
  const hours = Math.floor(elapsedSeconds.value / 3600);
  return `${String(hours).padStart(2, "0")}:${String(minutes).padStart(
    2,
    "0"
  )}:${String(seconds).padStart(2, "0")}`;
});

const startStopwatch = () => {
  if (isPaused.value) {
    intervalId.value = setInterval(() => {
      elapsedSeconds.value += 1;
    }, 1000);
    isPaused.value = false;
  }
};

const pauseStopwatch = () => {
  isPaused.value = true;
  clearInterval(intervalId.value);
};

const stopStopwatch = () => {
  pauseStopwatch();

  const user = userStore.user;
  const date = new Date();
  const formattedDate = `${date.getFullYear()}-${String(
    date.getMonth() + 1
  ).padStart(2, "0")}-${String(date.getDate()).padStart(2, "0")}`;

  const record = {
    userId: user.userId,
    date: formattedDate,
    time: formattedTime.value,
    videoId: video.value.videoId,
  };

  registRecordApi(record)
    .then(() => {
      alert("오늘 운동 끝 !");
      router.push("/youtube").then(() => {
        window.location.reload();
      });
    })
    .catch((e) => {
      console.log(e);
    });
};

// 컴포넌트가 소멸될 때 setInterval 정리
onUnmounted(() => {
  clearInterval(intervalId.value);
});
</script>

<style scoped>
* {
  box-sizing: border-box;
}
.body-container {
  width: 100%;
  height: 120vh;
  padding-top: 30px;
  padding-left: 6%;
  padding-right: 6%;
  box-sizing: border-box;
  /* background-color: yellow; */
}
.title-container {
  display: flex;
  align-items: center;
  height: 40px;
  width: 100%;
  margin-right: 10px;
  justify-content: space-between;
}
.title {
  font-size: 20px;
}
.main-container {
  width: 100%;
  height: 120vh;
  padding-top: 30px;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.video-player {
  width: 100%;
  aspect-ratio: 16/9;
  border-radius: 5px;
  margin-bottom: 60px;
}
.button-container {
  margin-top: 60px;
  width: 100%;
  display: flex;
  justify-content: space-around;
}
.exercise-button {
  width: 130px;
  height: 45px;
  text-align: center;
  border: none;
  border-radius: 5px;
  font-size: 14px;
}
.exercise-button:hover {
  cursor: pointer;
  background-color: #fce8f0;
}
.stopwatch {
  width: 350px;
  height: 80px;
  padding-top: 5px;
  display: flex;
  justify-content: center;
  align-items: center;
  border: 1px solid gray;
  color: #333333d3;
  border-radius: 10px;
  font-size: 60px;
}
</style>
