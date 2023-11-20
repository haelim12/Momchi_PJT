import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useUserStore = defineStore("userData", () => { 
    const user = computed(() => {
    const storedUser = localStorage.getItem("user");
    return storedUser ? JSON.parse(storedUser) : null;
  });

  return { user };
})