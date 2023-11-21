import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useVideoStore = defineStore("videoData", () => {
    const videos = ref([]);
    return { videos };
})