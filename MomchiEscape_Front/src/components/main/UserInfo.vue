<template>
  <div class="main-container">
    <div v-if="!isLoggedin" >
      <div class="title">{{ userStore.user.nickname }}님, 오늘도 좋은 운동 되세요.</div>
      <div class="content-container">
        <div class="info"> 현재까지 스트릭은 {{ streakMsg }}일 입니다</div>
        <div class="encouragement"> 오늘도 몸치탈출 화이팅!</div>
      </div>
    </div>
    <div v-if="isLoggedin" >
        <div class="title">운동이.. 설마... 처음이신가요....? ;;</div>
        <div class="content-container">
          <div class="info toregist" @click="toRegist">
            회원가입 해보시는건?
          </div>
          <div class="encouragement"> 날씨만 보고 도망가시네요</div>
        </div>
      </div>
  </div>
</template>

<script setup>
import { computed, onMounted, onUpdated, ref } from "vue";
import { useUserStore } from "@/stores/userStore";
import { useRouter } from "vue-router";
import { getStreak } from "@/util/RecordApi";

const router = useRouter();
const userStore = useUserStore();
const currentStreak = ref(0);
const streakMsg = computed(() => {
  if (currentStreak.value < 10) {
    return "0" + currentStreak.value;
  }
  else {
    return currentStreak.value;
  }
})

onMounted(() => {
  if (userStore.user) {
    getStreak(userStore.user.userId)
      .then((data) => {
        currentStreak.value = data;
      })
      .catch((e) => {
        console.log(e);
      });
  }
})

const isLoggedin = computed(() => {
  if (!userStore.user) {
    return true;
  }
  else {
    return false;
  }
});

const toRegist = () => {
  router.push("/regist");
}

</script>

<style scoped>
*{
  box-sizing: border-box;
  color: #565959;
}
.main-container {
  width: 69%;
  padding-top: 20px;
  padding-left: 10px;
  /* background-color: crimson; */
}
.title{
  font-size: 25px;
  font-weight: bold;
  height: 50px;

}
.content-container{
  width: 90%;
  height: 70%;
  display: flex;
  flex-direction: column;
  margin-top: 10px;
}
.info{
  font-size: 20px;
  padding-bottom: 15px;
  width: 300px;
  color: #ffc2cd;
}
.toregist{
  width: 170px;
  cursor: pointer;
}
.encouragement{
  font-size: 15px;
}
</style>
