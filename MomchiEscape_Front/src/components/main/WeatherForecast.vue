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
        <div class="info">기온 : {{ tmp }}℃</div>
        <div class="info">강수확률 : {{ pop }}%</div>
        <div class="info">최저기온 : {{ tmn }}℃</div>
        <div class="info">최고기온 : {{ tmx }}℃</div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { getCurrentWeather, getTodayWeather } from "@/util/WeatherApi.js";

let currentWeatherItems = [];
let todayWeatherItems = [];
const weatherImg = ref("/images/weather/sunny.png");

const sunnyImg = "/images/weather/sunny.png";
const cloudyImg = "/images/weather/cloudy.png";
const snowyImg = "/images/weather/snowy.png";
const rainyImg = "/images/weather/rainy.png";

const tmp = ref(0); // 기온
const sky = ref(0); // 하늘 상태
const pty = ref(0); // 강수 형태
const pop = ref(0); // 강수 확률
const tmn = ref(0); // 일 최저기온
const tmx = ref(0); // 일 최고기온

onMounted(() => {
  getTodayWeather()
    .then((data) => {
      todayWeatherItems = data.item;
      setDayWeatherInfo();
      getCurrentWeather()
        .then((data) => {
          currentWeatherItems = data.item;
          setCurrentWeatherInfo();
        })
        .catch((e) => {
          console.log(e);
        });
    })
    .catch((e) => {
      console.log(e);
    });
});
function setWeatherImg() {
  // Cloudy
  if (sky.value === 3 || sky.value == 4) {
    weatherImg.value = cloudyImg;
  }
  // Rain
  if (
    pty.value === 1 ||
    pty.value === 2 ||
    pty.value === 5 ||
    pty.value === 6
  ) {
    weatherImg.value = rainyImg;
  }
  // Snow
  if (pty.value === 3 || pty.value === 7) {
    weatherImg.value = snowyImg;
  }
}

function setDayWeatherInfo() {
  todayWeatherItems.forEach((item, index) => {
    switch (item.category) {
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
      case "T1H": // 현재 온도 (섭씨)
        tmp.value = item.obsrValue;
        break;
      case "PTY": // 강수 형태
        pty.value = item.obsrValue;
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
  min-width: 300px;
  max-width: 400px;
  height: 200px;
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
.weather-info {
  width: 47%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: left;
  justify-content: center;
  padding-left: 30px;
}
.info {
  height: 25px;
  font-size: 14px;
  color: #565959;
}
.weather-image {
  width: 44%;
  height: auto;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
}
.w-img {
  width: 70%;
}
</style>
