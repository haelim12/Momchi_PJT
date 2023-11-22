<template>
    <TheHeaderNav />
    <div class="edit-container">
        <div class="edit-body">
            <div class="edit-title">게시글 수정중 .. 🔧</div>
            <div class="input-container">
                <div class="name">제목</div>
                <input
                v-model="postStore.editingPost.title"
                class="text-input"
                />
                <div class="name">내용</div>
                <textarea
                v-model="postStore.editingPost.content"
                class="text-input-textarea"
                ></textarea>
            </div>
            <div class="blank"></div>
            <button class="button" @click="onEditClick">수정</button>
            <div class="blank-bottom"></div>
        </div>
    </div>
</template>

<script setup>
import { onMounted } from "vue";
import TheHeaderNav from "../components/common/TheHeaderNav.vue";
import { usePostStore } from "../stores/postStore";
import { updatePost } from "@/util/PostApi";
import { useRouter } from 'vue-router';

const postStore = usePostStore();
const router = useRouter();

function onEditClick() {
    console.log(postStore.editingPost);
    updatePost(postStore.editingPost)
        .then(() => {
            console.log("good");
            router.push("/board").then(() => {
                window.location.reload();
            });
        })
        .catch((e) => {
            console.log(e);
    })
}

</script>

<style scoped>
.edit-container {
  width: 100%;
  height: 100%;
  min-height: 900px;
  padding: 70px;
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.edit-title {
  width: 50%;
  height: 50px;
  font-size: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 50px;
  color: #565959;
}
.edit-body {
  width: 70%;
  max-width: 600px;
  min-height: 630px;
  padding-top: 50px;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  border: solid 1px rgb(178, 175, 175);
  border-radius: 20px;
  box-sizing: border-box;
}
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
  margin-bottom: 30px;
  font: #999999;
  border: solid #999999 1px;
  border-radius: 5px;
}

.text-input-textarea {
  width: 340px;
  height: 200px;
  padding-left: 7px;
  padding-top: 10px;
  margin-bottom: 10px;
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

.button {
  width: 355px;
  height: 43px;
  padding-left: 10px;
  margin-top: 5px;
  margin-bottom: 5px;
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
</style>