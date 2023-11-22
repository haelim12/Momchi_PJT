<template>
  <TheHeaderNav />
  <div class="main-container">
    <div class="body-container">
      <div class="profile-container">
        <div class="profile-img">
          <div class="profile-img-left">
            <img class="img" :src="profile" />
          </div>
          <div class="profile-img-right">
            <div class="profile_name">
              <strong>{{ userStore.user.nickname }}</strong> 님의 프로필
            </div>
            <div class="streak-day">{{ streakMsg }} 일 째 운동중 .. 💢</div>
            <div class="edit-delete">
              <div class="profile-edit" @click="toEdit">수정</div>
              <div class="profile-delete" @click="toDelete">탈퇴</div>
            </div>
          </div>
        </div>
        <div class="streak-title">Streak</div>
        <div class="streak-container">
          <div class="streak-date">
            <div class="days">일</div>
            <div class="days">월</div>
            <div class="days">화</div>
            <div class="days">수</div>
            <div class="days">목</div>
            <div class="days">금</div>
            <div class="days">토</div>
          </div>
          <div class="profile-streak">
            <div v-for="(monthDays, index) in daysInYear" :key="index">
              <Streak :monthDays="monthDays" :index="index" />
            </div>
          </div>
        </div>

        <div class="streak-title">Exercise-Log</div>
        <div class="lower-container">
          <LogHeader />
          <Log
            v-for="(log, index) in recordStore.records"
            :key="index"
            :log="log"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { computed, onMounted, ref } from "vue";
import TheHeaderNav from "../components/common/TheHeaderNav.vue";
import Streak from "@/components/profile/Streak.vue";
import Log from "@/components/profile/Log.vue";
import LogHeader from "@/components/profile/LogHeader.vue";
import { useRouter } from "vue-router";
import { useUserStore } from "@/stores/userStore";
import { getStreak, getAllRecord } from "../util/RecordApi";
import { useRecordStore } from "../stores/recordStore";
import { deleteAccount } from "@/util/UserApi";

const router = useRouter();
const userStore = useUserStore();
const recordStore = useRecordStore();
const profile = "/images/profile_chichi_body.png";
const currentStreak = ref(0);

const streakMsg = computed(() => {
  if (currentStreak.value < 10) {
    return "0" + currentStreak.value;
  } else {
    return currentStreak.value;
  }
});

const toEdit = () => {
  router.push("/profile-edit");
};

const toDelete = () => {
  deleteAccount(userStore.user.userId)
    .then(() => {
      localStorage.clear();
      router.push("/").then(() => {
        window.location.reload();
      });
    })
    .catch((e) => {
      console.log(e);
    });
};

const daysInYear = ref([]);

onMounted(() => {
  getAllDaysInYear();
  getStreak(userStore.user.userId)
    .then((data) => {
      currentStreak.value = data;
    })
    .catch((e) => {
      console.log(e);
    });

  getAllRecord(userStore.user.userId)
    .then((data) => {
      recordStore.records = data.slice(0, 15);
    })
    .catch((e) => {
      console.log(e);
    });
});

const getAllDaysInYear = () => {
  const today = new Date();
  const year = today.getFullYear();
  const month = today.getMonth() + 1;

  for (let month = 1; month <= 12; month++) {
    const daysInMonth = new Date(year, month, 0).getDate();
    const daysArray = Array.from(
      { length: daysInMonth },
      (_, index) => index + 1
    );
    daysInYear.value.push(daysArray);
  }
};
</script>

<style scoped>
* {
  box-sizing: border-box;
}
.main-container {
  width: 100%;
  display: flex;
  justify-content: center;
}
.title-container {
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
  max-width: 1200px;
  padding-top: 30px;
  padding-left: 6%;
  padding-right: 6%;
}
.title {
  font-size: 20px;
}
.profile-container {
  width: 100%;
  margin-bottom: 100px;
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
  font-size: 18px;
  padding: 3px;
}
.streak-day {
  font-size: 40px;
  padding: 3px;
}

.edit-delete {
  display: flex;
  padding-left: 5px;
}

.profile-edit {
  font-size: 12px;
  flex-wrap: wrap;
  padding-right: 10px;
  color: lightgray;
}
.profile-delete {
  font-size: 12px;
  color: lightgray;
}

.profile-edit:hover {
  cursor: pointer;
  color: #333333b9;
}
.profile-delete:hover {
  cursor: pointer;
  color: #333333b9;
}

/* Profile Streak */
.streak-container {
  display: flex;
}
.streak-date {
  padding-top: 40px;
  padding-bottom: 33px;
  padding-right: 1px;
  margin-left: 5px;
  width: 32px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  height: 200px;
  color: #333333a4;
}
.days {
  font-size: 7px;
}
.lower-container {
  margin-top: 20px;
}
.streak-title {
  font-size: 16px;
  margin-top: 20px;
  padding-left: 5px;
  color: #333333c8;
}
.profile-streak {
  height: 200px;
  display: flex;
  align-items: center;
  overflow-x: scroll;
  margin-bottom: 60px;
  /* background-color: lightgreen; */
}
</style>
