<template>
  <TheHeaderNav />
  <div class="body-container">
    <div class="upper-container">
      <UserInfoVue />
      <WeatherForecast />
    </div>
    <div class="lower-container">
      <PopularVideo />
      <VideoRank />
    </div>
  </div>
</template>

<script setup>
import TheHeaderNav from "../components/common/TheHeaderNav.vue";
import PopularVideo from "../components/main/PopularVideo.vue";
import UserInfoVue from "../components/main/UserInfo.vue";
import VideoRank from "../components/main/VideoRank.vue";
import WeatherForecast from "../components/main/WeatherForecast.vue";
</script>

<style scoped>
.body-container {
  width: 100%;
  min-height: 1022px;
  padding-top: 20px;
  padding-left: 6%;
  padding-right: 6%;
  box-sizing: border-box;
}
.upper-container {
  height: 25%;
  min-height: 200px;
  margin-bottom: 20px;
  box-sizing: border-box;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  padding-bottom: 20px;
  border-bottom: solid 2px rgb(236, 236, 236);
}
.lower-container {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  box-sizing: border-box;
}
</style>
