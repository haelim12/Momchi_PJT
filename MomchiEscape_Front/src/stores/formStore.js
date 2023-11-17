import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useFormStore = defineStore("formData", () => {
  const email = ref({
    name: "이메일 *",
    type: "text",
    placeholder: "이메일를 입력해 주세요",
    message: "",
    color: "",
  });
  const id = ref({
    name: "아이디",
    type: "text",
    placeholder: "아이디를 입력해 주세요",
    message: "",
    color: "",
  });
  const name = ref({
    name: "이름 *",
    type: "text",
    placeholder: "이름을 입력해 주세요",
    message: "",
    color: "",
  });
  const nickName = ref({
    name: "닉네임 *",
    type: "text",
    placeholder: "닉네임을 입력해 주세요",
    message: "",
    color: "",
  });
  const password = ref({
    name: "비밀번호 *",
    type: "password",
    placeholder: "비밀번호를 입력해 주세요",
    message: "",
    color: "",
  });
  const passwordCheck = ref({
    name: "password-check",
    type: "password",
    placeholder: "비밀번호를 확인해주세요",
    message: "",
    color: "",
  });
  const birthday = ref({ name: "생일", min: "1900-01-01" });
  const level = ref({ name: "level", type: "text" });

  const setEmail = (message, color) => {
    email.value = { ...email.value, message, color };
  };

  const setPassword = (message, color) => {
    password.value = { ...password.value, message, color };
  };

  const setName = (message, color) => {
    name.value = { ...name.value, message, color };
  };

  const setPasswordCheck = (message, color) => {
    passwordCheck.value = { ...passwordCheck.value, message, color };
  };

  return {
    id,
    email,
    name,
    nickName,
    password,
    passwordCheck,
    birthday,
    setEmail,
    setPassword,
    setName,
    setPasswordCheck,
  };
});
