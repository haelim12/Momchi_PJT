<template>
  <div class="main-container">
    <TheHeaderNav />
    <div class="body-container">
      <div class="title-container">
        <div class="title">운동영상</div>
        <div class="video-nav">
          <div class="nav-blank"></div>
          <div class="nav-button" @click="allClick" :class="{ active: all }">
            전체
          </div>
          <div
            class="nav-button"
            @click="level1Click"
            :class="{ active: level1 }"
          >
            초보
          </div>
          <div
            class="nav-button"
            @click="level2Click"
            :class="{ active: level2 }"
          >
            중수
          </div>
          <div
            class="nav-button"
            @click="level3Click"
            :class="{ active: level3 }"
          >
            고수
          </div>
        </div>
      </div>
      <div class="content-container">
        <div v-for="index in Math.ceil(videoList.length / 2)" :key="index">
          <div class="video-pair">
            <YoutbeVideoListItem :video="videoList[(index - 1) * 2]" />
            <div class="blank"></div>
            <YoutbeVideoListItem
              :video="videoList[(index - 1) * 2 + 1]"
              v-if="videoList[(index - 1) * 2 + 1]"
            />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import TheHeaderNav from "@/components/common/TheHeaderNav.vue";
import YoutbeVideoListItem from "@/components/youtube/YoutubeVideoListItem.vue";
import { onMounted, ref } from "vue";
import { getVideos, getVideosByLevel } from "@/util/VideoApi";

const all = ref(true);
const level1 = ref(false);
const level2 = ref(false);
const level3 = ref(false);

const videoList = ref([]);

onMounted(() => {
  getVideos()
    .then((data) => {
      videoList.value = data;
    })
    .catch((e) => {
      console.log(e);
    });
});

const allClick = () => {
  all.value = true;
  level1.value = false;
  level2.value = false;
  level3.value = false;
  getVideos()
    .then((data) => {
      videoList.value = data;
    })
    .catch((e) => {
      console.log(e);
    });
};
const level1Click = () => {
  all.value = false;
  level1.value = true;
  level2.value = false;
  level3.value = false;
  videoCall(1);
};
const level2Click = () => {
  all.value = false;
  level1.value = false;
  level2.value = true;
  level3.value = false;
  videoCall(2);
};
const level3Click = () => {
  all.value = false;
  level1.value = false;
  level2.value = false;
  level3.value = true;
  videoCall(3);
};

function videoCall(level) {
  getVideosByLevel(level)
    .then((data) => {
      videoList.value = data;
    })
    .catch((e) => {
      console.log(e);
    });
}
</script>

<style scoped>
* {
  box-sizing: border-box;
}
.main-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.title-container {
  width: 100%;
  display: flex;
  align-items: center;
  height: 40px;
  margin-bottom: 20px;
  margin-right: 10px;
  justify-content: space-between;
}
.body-container {
  max-width: 1200px;
  width: 100%;
  /* height: 100vh; */
  padding-top: 30px;
  padding-left: 6%;
  padding-right: 6%;
  padding-bottom: 50px;
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  /* background-color: aquamarine; */
}
.content-container {
  width: 100%;
}
.title {
  font-size: 20px;
}
.video-nav {
  display: flex;
  align-items: center;
}
.nav-button {
  font-size: 14px;
  color: white;
  background-color: #f3c4cfe3;
  width: 60px;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 100px;
  margin-left: 10px;
}
.nav-button:hover {
  cursor: pointer;
}
.active {
  background-color: #f092a6;
}
.video-pair {
  width: 100%;
  display: flex;
  justify-content: space-between;
  /* background-color: aqua; */
}
.blank {
  width: 30px;
}
</style>
