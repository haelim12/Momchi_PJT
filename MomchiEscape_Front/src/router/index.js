import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import YoutubeView from "@/views/YoutubeView.vue";
import BoardView from "@/views/BoardView.vue";
import BoardCreateView from "@/views/BoardCreateView.vue";
import RecordView from "@/views/RecordView.vue";

import LoginView from "@/views/LoginView.vue";
import ProfileView from "@/views/ProfileView.vue";
import RegistView from "@/views/RegistView.vue";
import ProfileEditView from "@/views/ProfileEditView.vue";
import BoardEditView from "@/views/BoardEditView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/youtube",
      name: "youtube",
      component: YoutubeView,
    },
    {
      path: "/board",
      name: "board",
      component: BoardView,
    },
    {
      path: "/create",
      name: "create",
      component: BoardCreateView,
    },
    {
      path: "/login",
      name: "login",
      component: LoginView,
    },
    {
      path: "/profile",
      name: "profile",
      component: ProfileView,
    },
    {
      path: "/regist",
      name: "regist",
      component: RegistView,
    },
    {
      path: "/record",
      name: "record",
      component: RecordView,
    },
    {
      path: "/profile-edit",
      name: "profileEdit",
      component: ProfileEditView,
    },
    {
      path: "/post-edit",
      name: "postEdit",
      component: BoardEditView,
    },
  ],
});

export default router;
