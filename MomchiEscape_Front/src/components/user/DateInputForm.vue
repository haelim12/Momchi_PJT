<template>
  <div class="input-container">
    <div class="name">{{ type.name }}</div>
    <input
      v-model="inputValue"
      class="date-input"
      type="date"
      :min="type.min"
      :max="maxDate"
      @input="$emit('send-data', inputValue)"
    />
  </div>
  <div class="blank">&nbsp;</div>
</template>

<script setup>
import { ref, computed, defineProps, defineEmits } from "vue";
import { useFormStore } from "@/stores/formStore";

const formStore = useFormStore();
const inputValue = ref("1996-12-05");
const emit = defineEmits(["send-data"]);

const type = computed(() => {
  return formStore.birthday;
});

const maxDate = computed(() => {
  const today = new Date();
  const year = today.getFullYear();
  const month = String(today.getMonth() + 1).padStart(2, "0");
  const day = String(today.getDate()).padStart(2, "0");
  return `${year}-${month}-${day}`;
});
</script>

<style scoped>
.input-container {
  width: 350px;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}

.name {
  width: 100%;
  text-align: left;
  font-size: 14px;
  padding-bottom: 7px;
  color: #999999;
}

.date-input {
  width: 100%;
  height: 40px;
  padding-right: 10px;
  font-size: 12px;
  text-align: center;
  color: #999999;
  border: solid 1px #999999;
  border-radius: 5px;
  box-sizing: border-box;
  margin-bottom: 7px;
}
.blank {
  width: 350px;
  text-align: left;
  margin-left: 5px;
  font-size: 12px;
  margin-top: 7px;
  color: #999999;
}
</style>
