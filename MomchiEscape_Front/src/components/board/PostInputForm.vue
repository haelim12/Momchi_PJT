<template>
  <div class="input-container">
    <div class="name">{{ props.name }}</div>
    <input
      v-model="inputValue"
      :type="props.type"
      class="text-input"
      :placeholder="props.placeholder"
      @change="$emit('send-data', inputValue)"
    />
  </div>
</template>

<script setup>
import { ref, defineProps, defineEmits, onMounted } from "vue";
import { usePostStore } from "@/stores/postStore";

const postStore = usePostStore();
const props = defineProps(["type", "name", "placeholder"]);
const inputValue = ref("");
const emit = defineEmits(["send-data"]);

onMounted(() => {
  // console.log(props.name);
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
