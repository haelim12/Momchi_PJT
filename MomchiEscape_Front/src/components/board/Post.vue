<template>
  <div class="main-container">
    <div class="title">
      {{ post.title }}
    </div>
    <div class="content">
      {{ post.content }}
      <div v-if="userStore.user.userId === props.post.userId" class="edit-delete">
        <div class="edit-button" @click="postEdit">수정</div>
        <div class="delete-button" @click="postDelete">삭제</div>
      </div>
    </div>
    <div class="under-nav">
      <div>Written by : {{ writerUser.nickname }}</div>
      <img class="like_img" :src="likeImg" @click="onLikeClick" />
    </div>
  </div>
</template>

<script setup>
import { computed, onMounted, ref } from "vue";
import { getUserInfo } from "@/util/UserApi";
import { checkLike, likeApi } from "@/util/LikeApi";
import { useUserStore } from "@/stores/userStore";
import { deletePost } from "@/util/PostApi";
import { usePostStore } from "@/stores/postStore";
import { useRouter } from "vue-router";

const userStore = useUserStore();
const postStore = usePostStore();
const router = useRouter();

const writerUser = ref("");
const liking = "/images/like.png";
const unliking = "/images/unlike.png";
const logo = "/images/profile_chichi.png";
const likeCheck = ref(false);

const likeImg = computed(() => {
  if (likeCheck.value) {
    return liking;
  } else {
    return unliking;
  }
});

const props = defineProps({
  post: {
    type: Object,
    required: true,
  },
});

onMounted(() => {
  getUserPost();
});

const onLikeClick = () => {
  const user = userStore.user;
  const like = {
    userId: user.userId,
    postId: props.post.postId,
  };
  likeApi(like)
    .then(() => {
      checkLikePost();
    })
    .catch((e) => {
      console.log(e);
    });
};

async function getUserPost() {
  try {
    const data = await getUserInfo(props.post.userId);
    writerUser.value = data;
    checkLikePost();
  } catch (error) {
    console.error("Error fetching user info:", error);
  }
}
async function checkLikePost() {
  const user = userStore.user;
  if (user) {
    try {
      likeCheck.value = await checkLike(user.userId, props.post.postId);
    } catch (error) {
      console.error("Error fetching user info:", error);
    }
  }
}

const postEdit = () => {
  postStore.editingPost = props.post;
  router.push("/post-edit");
}

const postDelete = () => {
  deletePost(props.post.postId)
    .then(() => {
      alert("삭제되었습니다");
      window.location.reload();
    })
}
</script>

<style scoped>
.main-container {
  height: 100%;
  aspect-ratio: 0.9;
  margin-right: 20px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  /* background-color: brown; */
}
.title {
  height: 45px;
  font-size: 18px;
  padding-left: 10px;
  margin-bottom: 5px;
  color: #333333;
  display: flex;
  align-items: center;
  border-radius: 5px;
  background-color: #fce8f0d3;
}

.content {
  height: 100%;
  margin-top: 5px;
  padding-top: 10px;
  padding-right: 10px;
  padding-left: 10px;
  font-size: 15px;
  color: #333333db;
  border: 1px solid rgb(220, 220, 220);
  border-radius: 5px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  /* background-color: beige; */
}

.edit-delete {
  display: flex;
  font-size: 8px;
  color: lightgray;
  justify-content: flex-end;
  padding-bottom: 8px;
  padding-right: 3px;
}

.edit-button:hover {
  cursor: pointer;
  color: #333333b9;
}

.delete-button:hover {
  cursor: pointer;
  color: #333333b9;
}
.edit-button {
  padding-right:4px;
}
.under-nav {
  margin-top: 10px;
  height: 30px;
  display: flex;
  padding-right: 10px;
  padding-left: 10px;
  margin-bottom: 10px;
  font-size: 15px;
  color: #333333db;
  justify-content: space-between;
  align-items: center;
  /* background-color: blueviolet; */
}
.img {
  width: 27px;
  aspect-ratio: 1;
  padding: 2px;
}
.like_img {
  width: 25px;
  height: 23px;
}
.like_img:hover {
  cursor: pointer;
}
</style>
