<template>
  <div class="main-container">
    <div class="title">000님, 오늘도 좋은 운동 되세요.</div>
    <div class="content-container">
      <div class="info"> 현재까지 스트릭은 00일 입니다</div>
      <div class="encouragement"> 오늘도 몸치탈출 화이팅!</div>
    </div>
  </div>
</template>

<script setup></script>

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
  /* justify-content: center; */
  /* background-color: aquamarine; */
}
.info{
  font-size: 20px;
  padding-bottom: 15px;
    color: #ffc2cd;
}
.encouragement{
  font-size: 15px;
}
</style>
