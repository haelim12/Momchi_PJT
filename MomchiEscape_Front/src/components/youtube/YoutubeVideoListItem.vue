<template>
  <div class="main-container">
    <iframe
      class="video-player"
      :src="video.url"
      title="{{ video.title }}"
      frameborder="0"
      allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
      allowfullscreen
    ></iframe>
    <div class="info">
      <div class="video-title">제목 : {{ video.title }}</div>
      <div class="video-content">레벨 : {{ video.level }}</div>
    </div>
  </div>
</template>

<script setup>
const props = defineProps({
  video: {
    type: Object,
    required: true,
  },
});

const clickVideo = function () {};
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
  padding-left: 7px;
  height: 55px;
  /* background-color: rgb(235, 235, 235); */
}
.video-title {
  font-size: 16px;
  margin-bottom: 5px;
}
.video-content {
  font-size: 12px;
}
</style>
