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
          :value="typeName"
        >
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
      <div class="name">난이도</div>
      <select v-show="isUrlNeeded" v-model="level" class="select">
        <option value="" disabled selected>선택</option>
        <option
          v-for="(typeName, index) in levelType"
          :key="index"
          :value="typeName"
        >
          {{ typeName }}
        </option>
      </select>
      <div class="blank"></div>
      <button class="button" @click="create">작성</button>
      <div class="blank-bottom"></div>
    </div>
  </div>
</template>

<script setup>
import PostInputForm from "@/components/board/PostInputForm.vue";

import { useRouter } from "vue-router";
import { ref } from "vue";
import { savePost } from "../util/PostApi";
import { isValidYouTubeUrl } from "@/util/InputCheck";
import TheHeaderNav from "../components/common/TheHeaderNav.vue";

const type = ["후기", "영상 추천", "honey팁"];
const levelType = ["초보", "중수", "고수"];
const title = ref({
  name: "제목 *",
  type: "text",
  placeholder: "제목를 입력해 주세요",
});
const content = ref({
  name: "내용 *",
  type: "textarea",
  placeholder: "내용을 입력해 주세요",
});
const url = ref({
  name: "동영상 링크",
  type: "text",
  placeholder: "링크를 입력해 주세요",
});

const router = useRouter();

const titleValue = ref("");
const contentValue = ref("");
const selectedType = ref("후기");
const urlValue = ref("");
const level = ref("초보");
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
  selectedType.value = inputValue.target.value;
  if (selectedType.value === "영상 추천") {
    isUrlNeeded.value = true;
  } else {
    isUrlNeeded.value = false;
  }
};

const create = () => {
  const user = JSON.parse(localStorage.getItem("user"));

  // 로그인 하지 않은 유저가 만약에 접근한 경우, 홈 화면으로 이동 및 게시글 작성 불가
  if (!user) {
    alert("로그인 후 이용해주세요");
    router.push("/").then(() => {
      window.location.reload();
    });
    return;
  }

  // 값이 정확하게 입력 되었는지 확인
  if (!isValidInput()) {
    alert("입력 값을 확인해주세요");
    return;
  }

  // 요청 객체 생성 후 axios 요청
  const post = {
    title: titleValue.value,
    content: contentValue.value,
    userId: user.userId,
    contentType: selectedType.value,
    url: urlValue.value,
    level: level.value,
  };
  savePost(post)
    .then(() => {
      alert("등록이 완료되었습니다");
      if (selectedType.value === "영상 추천") {
        router.push("/youtube").then(() => {
          window.location.reload();
        });
      } else {
        router.push("/board").then(() => {
          window.location.reload();
        });
      }
    })
    .catch((e) => {
      console.log(e);
    });
};

function isValidInput() {
  const isTitleEmpty = !titleValue.value;
  const isContentEmpty = !contentValue.value;
  const isTypeEmpty = !selectedType.value;

  let isUrlValid = true;
  if (selectedType.value === "영상 추천") {
    if (!urlValue || !isValidYouTubeUrl(urlValue.value) || !level.value) {
      isUrlValid = false;
    }
  }
  return isTitleEmpty || isContentEmpty || isTypeEmpty || isUrlValid;
}
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
  margin-bottom: 30px;
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
  height: 20px;
}
.blank-bottom {
  height: 70px;
}
</style>
