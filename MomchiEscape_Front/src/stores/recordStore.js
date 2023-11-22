import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useRecordStore = defineStore("recordData", () => {
    const records = ref([]);
    return { records };
})