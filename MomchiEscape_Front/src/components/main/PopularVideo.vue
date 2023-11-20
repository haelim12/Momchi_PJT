<template>
  <div class="main-container">
    <div class="title">
      인기 동영상
    </div>
    <iframe class="youtube" src="https://www.youtube.com/embed/9bKCi4qwwIk?si=3vOfQtJFCooNCXpZ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
    <div class="info">
        <div class="video-title">제목 : {{ popularVideo.title }}</div>
        <div class="video-content">부위 : {{ popularVideo.part }}</div>
    </div>  
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";

const popularVideo = ref({ title: "지구본", part: "이따구로 살지 마시오 근데 이거 노래 좋아 ", url: "https://www.youtube.com/watch?v=L39bRZMCuoM" });

onMounted(() => {
  // 맨 처음 로딩될 때 동영상을 가져오는 함수 필요
  // 가져오는 api 해야 할듯?
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
