<template>
  <div>
    <TheHeaderNav />
    <div class="body-container">
      <div class="title-container">
          <div class="title">Board</div>
          <button class="button" @click="toCreate">글 작성</button>
      </div>
      <div class="contents-container">
        <div class="small-title">영상 추천 👍</div>
        <div  class="contents">
          <div v-for="post in recommend" :key="post.id">
            <Post :post="post"/>
          </div>
        </div>
      </div>
      <div class="contents-container">
        <div class="small-title">후기 💪</div>
        <div class="contents">
          <div v-for="post in review">
            <Post :post="post"/>
          </div>
        </div>
      </div>
      <div class="contents-container">
        <div class="small-title">꿀팁 🍯</div>
        <div class="contents">
          <div v-for="post in honeytip">
            <Post :post="post"/>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import TheHeaderNav from "../components/common/TheHeaderNav.vue";
import Post from "@/components/board/Post.vue";
import { useRouter } from "vue-router";
import { onMounted, ref } from "vue";
import { getPostsByCategory } from "@/util/PostApi.js";

const router = useRouter();

const recommend = ref([]);
const review = ref([]);
const honeytip = ref([]);

onMounted(() => {
  getPostsByCategory(1)
    .then((data) => {
      recommend.value = data;
    }).catch((e) => {
    });

  getPostsByCategory(2)
    .then((data) => {
      review.value = data;
    }).catch((e) => {
    });
    
  getPostsByCategory(3)
    .then((data) => {
      honeytip.value = data;
    }).catch((e) => {
    });
})

 
const toCreate = () => {
  router.push("/create");
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
  /* background-color: red; */
  
}
.body-container {
  width: 100%;
  height: 120vh;
  padding-top: 30px;
  padding-left: 6%;
  padding-right: 6%;
  box-sizing: border-box;
  /* background-color: yellow; */
}
.title {
  font-size: 20px;
}
.small-title{
  height: 10%;
  min-height: 35px;
  font-size: 18px;
  display: flex;
  align-items: center;
  padding-left: 10px;
  margin-bottom: 10px;
  background-color: rgb(236, 236, 236);
    /* background-color: #fce8f0; */
}
.contents-container{
  height: 25%;
  min-height: 350px;
  width: 100%;
  margin-bottom: 40px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  border-top: solid 2px #33333348;
  /* background-color: rgb(227, 227, 227); */
}
.contents{
  width: 100%;
  height: 88%; 
  display: flex;
  flex-wrap: nowrap;
  overflow-x: auto;
}
.button {
  width: 65px;
  height: 30px;
  font-size: 14px;
  border-radius: 20px;
  border: 0;
  background-color: #fce8f0;
  color: #333333b9;
  margin: 2px;
}
.button:hover {
  background-color: rgb(189, 188, 188);
  color: white;
  cursor: pointer;
}
.title {
  font-size: 20px;
}
</style>
