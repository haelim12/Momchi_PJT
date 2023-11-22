import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const usePostStore = defineStore("postData", () => {
    const posts = ref([]);
    const editingPost = ref({});
    return { posts, editingPost };
})