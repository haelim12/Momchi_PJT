<template>
  <div class="input-container">
    <div class="name">{{ props.name }}</div>
    <textarea
      v-if="props.type === 'textarea'"
      v-model="inputValue"
      class="text-input-textarea"
      :placeholder="props.placeholder"
      @input="$emit('send-data', inputValue)"
    ></textarea>
    <input 
      v-else
      v-model="inputValue"
      :type="props.type"
      class="text-input"
      :placeholder="props.placeholder"
      @input="$emit('send-data', inputValue)"
    />
  </div>
</template>

<script setup>
import { ref, defineProps, defineEmits } from "vue";
import { usePostStore } from "@/stores/postStore"

const postStore = usePostStore();
const inputValue = ref("");
const emit = defineEmits(["send-data"]);

const post = computed(() => {
  return postStore.post;
})
</script>

<style scoped>
.input-container {
  width: 400px;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-bottom: 30px;
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

.text-input-textarea {
  width: 340px;
  height: 200px;
  padding-left: 7px;
  padding-top: 10px;
  font-size: 12px;
  font: #999999;
  border: solid #999999 1px;
  border-radius: 5px;
  resize: none;
}
.message {
  width: 350px;
  text-align: left;
  /* margin-left: 5px; */
  font-size: 12px;
  margin-top: 7px;
  margin-bottom: 5px;
  color: #999999;
}
</style>
