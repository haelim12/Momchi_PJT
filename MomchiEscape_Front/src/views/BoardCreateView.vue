<template>
  <TheHeaderNav />
  <div class="create-container">
    <div class="create-body">
      <div class="create-title">게시물 작성중 .. 🧑‍💻</div>
      <PostInputForm
        :from="title"
        :name="title.name"
        :type="title.type"
        :placeholder="title.placeholder"
        @send-data="titleInput"
      />
      <PostInputForm
        :from="content"
        :name="content.name"
        :type="content.type"
        :placeholder="content.placeholder"
        @send-data="contentInput"
      />
      <div class="name">종류 *</div>
        <select v-model="selectedType" @change="onTypeChange" class="select">
          <option value="" disabled selected>선택</option>
          <option
            v-for="(typeName, index) in type"
            :key="index"
            :value="typeName">
            {{ typeName }}
          </option>
        </select>
      <PostInputForm
        v-show="isUrlNeeded"
        :from="url"
        :name="url.name"
        :type="url.type"
        :placeholder="url.placeholder"
        @send-data="urlInput"
      />
      <div class="blank"></div>
      <button class="button" @click="create">작성</button>
    </div>
  </div>
</template>

<script setup>
import PostInputForm from "@/components/board/PostInputForm.vue";

import { useRouter } from "vue-router";
import { ref } from "vue";
import { savePost } from "../util/PostApi";
import TheHeaderNav from "../components/common/TheHeaderNav.vue";

const type = ["영상 추천", "후기", "🍯팁"];
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
  placeholder: "내용을 입력해 주세요",
  message: "",
  color: "",
});
const url = ref({
  name: "동영상 링크",
  type: "text",
  placeholder: "링크를 입력해 주세요",
  message: "",
  color: "",
});

const router = useRouter();

const titleValue = ref("");
const contentValue = ref("");
const typeValue = ref("");
const selectedType = ref("");
const isUrlNeeded = ref(false);

const titleInput = (inputValue) => {
  titleValue.value = inputValue;
};
const contentInput = (inputValue) => {
  contentValue.value = inputValue;
};
const urlInput = (inputValue) => {
  urlValue.value = inputValue;
};
const onTypeChange = (inputValue) => {
  console.log(inputValue.target.value);
  selectedType.value = inputValue.target.value;
  if (selectedType.value === "영상 추천") {
    isUrlNeeded.value = true;
    console.log(isUrlNeeded.value);
  }
  else {
    isUrlNeeded.value = false;
  }
};

const create = () => {
  if (titleValue.value && contentValue.value && postTypeValue.value) {
    const post = {
      title: titleValue.value,
      content: contentValue.value,
      url:urlValue.v
    }
    savePost()
    
  }

};
</script>

<style scoped>
.create-container {
  width: 100%;
  height: 100%;
  min-height: 900px;
  padding: 70px;
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  align-items: center;
}
div {
  -ms-overflow-style: none;
  scrollbar-width: none;
}
div::-webkit-scrollbar {
  display: none;
}
.create-title {
  width: 50%;
  height: 50px;
  font-size: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 50px;
  color: #565959;
}
.create-body {
  width: 70%;
  max-width: 600px;
  min-height: 850px;
  padding-top: 50px;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  border: solid 1px rgb(178, 175, 175);
  border-radius: 20px;
  box-sizing: border-box;
}
.button {
  width: 355px;
  height: 43px;
  padding-left: 10px;
  margin-top: 5px;
  margin-bottom: 15px;
  font-size: 14px;
  border-radius: 5px;
  border: 0;
  background-color: #cbcbcb;
  color: white;
}
.button:hover {
  background-color: #fce8f0;
  color: #333333b9;
  cursor: pointer;
}
.select {
  width: 355px;
  height: 43px;
  box-sizing: border-box;
  padding-left: 10px;
  padding-right: 10px;
  border: solid #999999 1px;
  border-radius: 5px;
  font-size: 14px;
  color: #999999;

  appearance: none;
}

.name {
  width: 350px;
  text-align: left;
  font-size: 14px;
  padding: 7px;
  color: #999999;
}
.blank {
  height: 50px;
}
</style>
