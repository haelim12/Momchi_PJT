<template>
  <div>
    <div class="name">{{ type.name }}</div>
    <input
      v-model="inputValue"
      class="text-input"
      :type="type.type"
      :placeholder="type.placeholder"
      @change="$emit('send-data', inputValue)"
    />
    <div class="message" :style="{ color: type.color }">
      {{ type.message }}&nbsp;
    </div>
  </div>
</template>

<script setup>
import { ref, computed, defineProps } from "vue";
import { useFormStore } from "@/stores/formStore";

const formStore = useFormStore();
const props = defineProps(["from"]);
const inputValue = ref("");
const emit = defineEmits(["send-data"]);

const type = computed(() => {
  switch (props.from) {
    case "email":
      return formStore.email;
    case "id":
      return formStore.id;
    case "name":
      return formStore.name;
    case "nickname":
      return formStore.nickName;
    case "password":
      return formStore.password;
    case "passwordCheck":
      return formStore.passwordCheck;
    default:
      return {};
  }
});
</script>

<style scoped>
.input-container {
  width: 400px;
  height: 100px;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.name {
  width: 350px;
  text-align: left;
  font-size: 14px;
  padding-bottom: 7px;
  color: #999999;
}
.text-input {
  width: 340px;
  height: 40px;
  padding-left: 10px;
  font-size: 12px;
  font: #999999;
  border: solid #999999 1px;
  border-radius: 5px;
}
.message {
  width: 350px;
  text-align: left;
  margin-left: 5px;
  font-size: 12px;
  margin-top: 7px;
  margin-bottom: 5px;
  color: #999999;
}
</style>
