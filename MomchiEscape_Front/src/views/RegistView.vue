<template>
  <div class="regist-container">
    <div class="regist-body">
      <div class="regist-title">회원가입 중..🐢</div>
      <InputForm from="email" @send-data="emailInput" />
      <InputForm from="password" @send-data="passwordInput" />
      <InputForm from="name" @send-data="nameInput" />
      <InputForm from="nickname" @send-data="nickNameInput" />
      <DateInputFormVue @send-data="birthdayInput" />
      <div class="name">레벨</div>
      <select v-model="levelValue" class="select">
        <option value="">선택</option>
        <option
          v-for="(levelName, index) in level"
          :key="index"
          :value="levelName"
        >
          {{ levelName }}
        </option>
      </select>
      <div class="blank"></div>
      <button class="button" @click="regist">회원가입</button>
    </div>
  </div>
</template>

<script setup>
import InputForm from "@/components/user/InputForm.vue";
import DateInputFormVue from "../components/user/DateInputForm.vue";

import { useRouter } from "vue-router";
import { ref } from "vue";
import { useFormStore } from "@/stores/formStore";
import { registApi } from "@/util/UserApi";

const level = ["초보", "중수", "고수"];

const router = useRouter();
const formStore = useFormStore();

const emailValue = ref("");
const passwordValue = ref("");
const nameValue = ref("");
const nickNameValue = ref("");
const birthdayValue = ref("1996-12-05");
const levelValue = ref("");

const emailInput = (inputValue) => {
  emailValue.value = inputValue;
};
const passwordInput = (inputValue) => {
  passwordValue.value = inputValue;
};
const nameInput = (inputValue) => {
  nameValue.value = inputValue;
};
const nickNameInput = (inputValue) => {
  nickNameValue.value = inputValue;
};
const birthdayInput = (inputValue) => {
  birthdayValue.value = inputValue;
};

const regist = () => {
  if (
    emailValue.value &&
    passwordValue.value &&
    nameValue.value &&
    nickNameValue.value &&
    birthdayValue.value &&
    levelValue.value
  ) {
    const user = {
      email: emailValue.value,
      password: passwordValue.value,
      name: nameValue.value,
      nickName: nickNameValue.value,
      birthday: birthdayValue.value,
      level: levelValue.value,
    };
    registApi(user)
      .then(() => {
        console.log(data);
      })
      .catch(() => {});
  } else {
    alert("똑바로 입력하세요");
  }

  console.log(emailValue.value);
  console.log(passwordValue.value);
  console.log(nameValue.value);
  console.log(nickNameValue.value);
  console.log(birthdayValue.value);
  console.log(levelValue.value);
};
</script>

<style scoped>
.regist-container {
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
.regist-title {
  width: 50%;
  height: 50px;
  font-size: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 50px;
  color: #565959;
}
.regist-body {
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
  padding-bottom: 7px;
  color: #999999;
}
.blank {
  height: 50px;
}
</style>
