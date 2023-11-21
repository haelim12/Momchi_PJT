<template>
    <TheHeaderNav />
    <div class="body-container">
      <div class="title-container">
          <div class="title">Profile</div>
      </div>
      <div class="profile-container">
        <div class="profile-img">
          <div class="profile-img-left">
            <img class="img" :src="profile"/> </div>
          <div class="profile-img-right">
            <div class="profile_name"><strong>{{ userStore.user.nickname }}</strong> 님의 프로필</div>
            <div class="streak-day">00 일 째 운동중 .. 💢</div>
            <div class = "edit-delete">
              <div class="profile-edit" @click="toEdit">수정</div>
              <div class="profile-delete" @click="toDelete">탈퇴</div>
            </div>
          </div>
        </div>
        <div class="streak-title">Streak</div>
        <div class="profile-streak">
          <div v-for="(monthDays, index) in daysInYear" :key="index">
            <Streak :monthDays="monthDays" :index="index" />
          </div>
        </div>
        <div class="streak-title">Exercise-Log</div>
        <div class="lower-container">
          <LogHeader/>
          <Log/>
          <Log/>
          <Log/>
        </div>
      </div>
    </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import TheHeaderNav from "../components/common/TheHeaderNav.vue";
import Streak from "@/components/profile/Streak.vue";
import Log from "@/components/profile/Log.vue";
import LogHeader from "@/components/profile/LogHeader.vue";
import { useRouter } from "vue-router";
import { useUserStore } from "@/stores/userStore";

const router = useRouter();
const userStore= useUserStore();
const profile = "/images/profile_chichi_body.png";

const toEdit = () => {
  router.push("/profile-edit");
}

const toDelete = () => {
  router.push("/profile-delete");
}

const daysInYear = ref([]);

onMounted(() => {
  getAllDaysInYear();
})

const getAllDaysInYear = () => {
  const today = new Date();
  const year = today.getFullYear();
  const month = today.getMonth() + 1;

  for (let month = 1; month <= 12; month++) {
    const daysInMonth = new Date(year, month, 0).getDate();
    const daysArray = Array.from({ length: daysInMonth }, (_, index) => index + 1);
    daysInYear.value.push(daysArray);
  }
};
</script>

<style scoped>
* {
  box-sizing: border-box;
}
.title-container{
  display: flex;
  align-items: center;
  height: 40px;
  width: 100%;
  margin-bottom: 20px;
  margin-right: 10px;
  justify-content: space-between;
  
}
.body-container {
  width: 100%;
  height: 120vh;
  padding-top: 30px;
  padding-left: 6%;
  padding-right: 6%;
  /* background-color: yellow; */
}
.title {
  font-size: 20px;
}
.profile-container {
  width: 100%;
  height: 100%;
  /* background-color: aqua; */
}

/* Profile-img */
.profile-img {
  height: 210px;
  background-color: white;
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  padding-bottom: 30px;
  /* background-color: aqua; */
  border-bottom: 2px solid rgba(211, 211, 211, 0.438);
}
.img {
  width: 170px;
  height: auto;
  /* background-color:black; */
  border: 1px solid white;
  border-radius: 200px;
}

.profile-name {
  font-size : 18px
}
.streak-day {
  font-size: 40px;
}

.edit-delete {
  display: flex;
}

.profile-edit {
  font-size: 12px;
  flex-wrap: wrap;
  padding-right: 10px;
}
.profile-delete {
  font-size: 12px;
}

/* Profile Streak */
.lower-container{
  margin-top: 20px;
}
.streak-title{
font-size: 16px;
margin-top: 20px;
padding-left: 5px;
color: #333333c8;
}
.profile-streak{
  height: 200px;
  display: flex;
  align-items: center;
  overflow-x: scroll;
  margin-bottom: 60px;
  /* background-color: lightgreen; */
}
</style>
