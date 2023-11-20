import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useWeatherStore = defineStore("weather", () => {
    const weatherImg = ref("/images/weather/sunny.png");
    const weatherText = ref(" ");

    const sunnyImg = "/images/weather/sunny.png";
    const cloudyImg = "/images/weather/cloudy.png";
    const snowyImg = "/images/weather/snowy.png";
    const rainyImg = "/images/weather/rainy.png";

    const tmp = ref(null); // 기온
    const sky = ref(null); // 하늘 상태
    const pty = ref(null); // 강수 형태
    const pop = ref(0); // 강수 확률
    const tmn = ref(0); // 일 최저기온
    const tmx = ref(0); // 일 최고기온

    
})