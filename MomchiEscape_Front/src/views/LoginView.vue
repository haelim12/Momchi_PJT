<template>
  <div class="login-container">
    <div class="login-body">
      <div class="login-title">로그인 중..🐢</div>
      <InputForm from="id" @send-data="emailInput" />
      <InputForm from="password" @send-data="passwordInput" />
      <div class="blank"></div>
      <button class="button" @click="login">로그인</button>
    </div>
  </div>
</template>

<script setup>
import InputForm from "@/components/user/InputForm.vue";

import { useRouter } from "vue-router";
import { ref } from "vue";
import { useFormStore } from "@/stores/formStore";
import { loginApi } from "../util/UserApi";

const router = useRouter();
const formStore = useFormStore();

const emailValue = ref("");
const passwordValue = ref("");

const emailInput = (inputValue) => {
  emailValue.value = inputValue;
};
const passwordInput = (inputValue) => {
  passwordValue.value = inputValue;
};

const login = () => {
  if (emailValue.value && passwordValue.value) {
    const user = {
      email: emailValue.value,
      password: passwordValue.value
    };
    
    loginApi(user)
      .then((data) => {
        localStorage.setItem("user", JSON.stringify(data));
        const loginUser = localStorage.getItem("user");
        console.log(loginUser);
      alert("로그인 완료!");
      router.push("/").then(() => {
          window.location.reload();
        });
      })
      .catch(() => {
        alert("아이디 또는 비밀번호가 잘못되었습니다");
    })
  }
  else {
    alert("제발 똑바로 입력하세요");
  }
}

</script>
<style scoped>
.login-container {
  width: 100%;
  height: 100%;
  min-height: 700px;
  padding-top: 70px;
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.login-title {
  width: 50%;
  height: 50px;
  font-size: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 50px;
  color: #565959;
}
.login-body {
  width: 50%;
  max-width: 600px;
  min-height: 500px;
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
.blank {
  height: 20px;
}
</style>
