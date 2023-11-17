<template>
  <div class="logo--container">
    <img
      class="logo-img"
      :class="{ hovered: isHover }"
      :src="isHover ? logoWhite : logo"
      alt="없어"
      @mouseover="mouseOver"
      @click="imageClick"
      @mouseleave="mouseLeave"
    />
  </div>
</template>

<script setup>
import logo from "/images/pinkchichiface.png";
import logoWhite from "/images/whitechichiface.png";

import { ref } from "vue";
import { useRouter } from "vue-router";
const router = useRouter();

const isHover = ref(false);

const mouseOver = () => {
  isHover.value = true;
};
const mouseLeave = () => {
  isHover.value = false;
};
const imageClick = () => {
  router.push("/");
};
</script>

<style scoped>
.logo-img {
  width: auto;
  height: 90px;
  text-align: center;
}

.logo-img:hover {
  cursor: pointer;
}

.logo--container {
  width: 100%;
  height: 120px;
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: center;
  /* background-color: red; */
}
</style>
