<template>
  <div>
    <TheHeaderNav />
    <div class="body-container">
      <div class="title">운동영상</div>
      <br />
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

const videoList = ref([
  {
    title: "롤드컵 우승 개좋아",
    level: "초급",
    url: "https://www.youtube.com/embed/7CKuhmS6VG0?si=xkhsVfz6p5uWDpqp",
  },
  {
    title: "세븐틴 - 예쁘다",
    level: "중수",
    url: "https://www.youtube.com/embed/hLf0j1WD5BY?si=gR6Xvxlhx44oHAa8",
  },
  {
    title: "롤드컵 우승 개좋아",
    level: "초급",
    url: "https://www.youtube.com/embed/7CKuhmS6VG0?si=xkhsVfz6p5uWDpqp",
  },
  {
    title: "세븐틴 - 예쁘다",
    level: "중수",
    url: "https://www.youtube.com/embed/hLf0j1WD5BY?si=gR6Xvxlhx44oHAa8",
  },
  {
    title: "세븐틴 - 예쁘다",
    level: "중수",
    url: "https://www.youtube.com/embed/hLf0j1WD5BY?si=gR6Xvxlhx44oHAa8",
  },
]);
</script>

<style scoped>
* {
  box-sizing: border-box;
}
.body-container {
  width: 100%;
  height: 100vh;
  /* background-color: beige; */
  padding-top: 20px;
  padding-left: 6%;
  padding-right: 6%;
  box-sizing: border-box;
}
.title {
  font-size: 20px;
}
.video-pair {
  width: 100%;
  display: flex;
  justify-content: space-between;
  /* justify-content: flex-start; */
}
</style>
