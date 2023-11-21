<template>
    <div class="edit-profile-container">
      <div class="edit-profile-body">
        <div class="edit-profile-title">회원정보 수정 중..🤖</div>
        <div class="profile-info">
          <div class="profile-info-item">
            <span class="info-label">닉네임 :</span>
            <input 
            v-model="user.nickname"
            class="text-input" />
          </div>
          <div class="profile-info-item">
            <span class="info-label">생년월일</span>
            <input v-model="user.birthday"
            class="date-input" />
          </div>
          <div class="profile-info-item">
            <span class="info-label">레벨</span>
            <input v-model="user.level"
            class="text-input" />
          </div>
        </div>
        <div class="blank"></div>
        <button class="button" @click="updateProfile">프로필 수정</button>
      </div>
    </div>
  </template>
  
<script setup>
  import { onMounted, computed } from 'vue';
  import { useUserStore } from "@/stores/userStore";
  import { useRouter } from 'vue-router';
  
  const router = useRouter();
  const userStore = useUserStore();
  const user = computed(() => {
    return userStore.user;
  });
  
  // 프로필 수정 함수
  const updateProfile = () => {
    alert("프로필이 업데이트되었습니다.");
  
    userStore.setUser({ ...user.value });
    router.push("/profile"); 
  };
</script>

<style scoped>
.edit-profile-container {
  width: 100%;
  height: 100%;
  min-height: 900px;
  padding: 70px;
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.edit-profile-body {
  width: 70%;
  max-width: 600px;
  min-height: 850px;
  padding-top: 50px;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  border: solid 1px rgb(178, 175, 175);
  border-radius: 20px;
  box-sizing: border-box;
}

.edit-profile-title {
  width: 50%;
  height: 50px;
  font-size: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 50px;
  color: #565959;
}

.profile-info {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.profile-info-item {
  width: 100%;
  padding: 10px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.info-label {
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
  height: 50px;
}
</style>
