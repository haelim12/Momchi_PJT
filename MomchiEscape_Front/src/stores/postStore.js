import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const usePostStore = defineStore("formData", () => {
  const title = ref({
    name: "제목 *",
    type: "text",
    placeholder: "제목를 입력해 주세요",
    message: "",
    color: "",
  });
  const content = ref({
    name: "내용 *",
    type: "textarea",
    placeholder: "내용를 입력해 주세요",
    message: "",
    color: "",
  });
  const url = ref({
    name: "url",
    type: "text",
    placeholder: "동영상 링크를 입력해 주세요",
    message: "",
    color: "",
  });
  const postType = ref({ name: "postType", type: "text" });

  const setTitle = (message, color) => {
    title.value = { ...title.value, message, color };
  };

  const setContent = (message, color) => {
    content.value = { ...content.value, message, color };
  };

  const setUrl = (message, color) => {
    url.value = { ...url.value, message, color };
  };
  return {
    title,
    content,
    url,
    postType,
    setTitle,
    setContent,
    setUrl,
  };
});
