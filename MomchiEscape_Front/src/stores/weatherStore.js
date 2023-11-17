import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

export const useWeatherStore = defineStore("weatherData", () => {
  return { getCurrentWeather };
});
