<template>
  <div class="main-container">
    <div class="title"><b>𝙝𝙤𝙭𝙮</b>.. 날씨가 궁금하신가요 ?</div>
    <div class="content">
      <div class="weather-image">
        <img
          class="w-img"
          :src="weatherImg"
          alt="없어"
          @mouseover="mouseOver"
          @click="imageClick"
          @mouseleave="mouseLeave"
        />
      </div>
      <div class="weather-info">
        <div>기온 : {{ tmp }}℃</div>
        <div>하늘상태 : {{ sky }}</div>
        <div>강수형태 : {{ pty }}</div>
        <div>강수확률 : {{ pop }}%</div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import {
  getCurrentWeather,
  getTodayWeather,
} from "@/util/weather-api/WeatherApi.js";

const currentWeatherItems = ref([]);
const todayWeatherItems = ref([]);
const weatherImg = ref("/images/weather/cloudy.png");
const tmp = ref(null); // 기온
const sky = ref(null); // 하늘 상태
const pty = ref(null); // 강수 형태
const pop = ref(0); // 강수 확률
const tmn = ref(0); // 일 최저기온
const tmx = ref(0); // 일 최고기온

onMounted(() => {
  getTodayWeather()
    .then((data) => {
      console.log(data);
      todayWeatherItems.value = data;
      console.log(todayWeatherItems.value);
      setDayWeatherInfo();
      getCurrentWeather()
        .then((data) => {
          currentWeatherItems.value = data;
          setCurrentWeatherInfo();
          console.log(tmp.value);
          console.log(sky.value);
          console.log(pty.value);
          console.log(pop.value);
          console.log(tmn.value);
          console.log(tmx.value);
        })
        .catch((e) => {
          console.log(e);
        });
    })
    .catch((e) => {
      console.log(e);
    });
});
function setDayWeatherInfo() {
  console.log(todayWeatherItems.value);
  todayWeatherItems.value.forEach((item, index) => {
    switch (item.category) {
      case "POP": // 강수 확률
        pop.value = item.fcstValue;
        break;
      case "SKY": // 하늘 상태
        sky.value = item.fcstValue;
        break;
      case "TMN": // 일 최저기온
        tmn.value = item.fcstValue;
        break;
      case "TMX": // 일 최고기온
        tmx.value = item.fcstValue;
        break;
    }
  });
}
function setCurrentWeatherInfo() {
  currentWeatherItems.forEach((item, index) => {
    switch (item.category) {
      case "T1H":
        tmp.value = item.fcstValue;
        break;
      case "PTY":
        pty.value = item.fcstValue;
        break;
    }
  });
}
</script>
<style scoped>
* {
  box-sizing: border-box;
}
.main-container {
  width: 29%;
  /* background-color: #e0e0e0; */
  box-sizing: border-box;
  padding-top: 10px;
  padding-left: 5px;
  padding-right: 5px;
  display: flex;
  flex-direction: column;
  border: double 7px rgb(241, 241, 241);
  border-radius: 30px;
}
.title {
  height: 50px;
  display: flex;
  align-items: center;
  padding-left: 10px;
}
.content {
  height: 100%;
  box-sizing: border-box;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
}
.weather-image {
  height: 100%;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
}
.w-img {
  width: 90px;
}
</style>
