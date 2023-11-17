<template>
  <div>
    <TheHeaderNav />
    <h2>000님의</h2>
    <hr />
    <YoutubeVideoDetail />
    <hr />
    <YoutubeVideoList />
  </div>
</template>

<script setup>
import YoutubeVideoList from "@/components/youtube/YoutubeVideoList.vue";
import YoutubeVideoDetail from "../components/youtube/YoutubeVideoDetail.vue";
import TheHeaderNav from "../components/common/TheHeaderNav.vue";
</script>

<style scoped></style>
