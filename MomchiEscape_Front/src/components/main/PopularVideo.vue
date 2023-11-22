<template>
  <div class="main-container">
    <div class="title">
      가장 많이 시청 중인 동영상
    </div>
    <iframe class="youtube" :src=videoStore.popularVideo.videoUrl title="YouTube video player" controls="2" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
    <div class="info">
        <div class="video-title">난이도 : {{ videoStore.popularVideo.level }}용</div>
        <div class="video-content">함께 따라하며 운동해봐요 !</div>
    </div>  
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { useVideoStore } from "@/stores/videoStore";
import { getPopularVideo } from "@/util/VideoApi";

const videoStore = useVideoStore();

onMounted(() => {
  getPopularVideo()
    .then((data) => {
      videoStore.popularVideo = data;
  })
})

</script>

<style scoped>
*{
  box-sizing: border-box;
  color: #565959;
}
.main-container {
  width: 69%;
  min-height: 600px;
  margin-top: 20px;
}
.title{
  height: 40px;
  width: 100%;
  font-size: 20px;
  padding-top: 10px;
  padding-left: 5px;
  margin-bottom: 10px;
}
.youtube{
  width:99%;
  aspect-ratio: 16/9;
}
.info{
  margin-top: 20px;
  padding-left: 5px;
}
.video-title{
  font-size: 17px;
  margin-bottom: 15px;
}
.video-content{
  font-size: 12px;
}

</style>
