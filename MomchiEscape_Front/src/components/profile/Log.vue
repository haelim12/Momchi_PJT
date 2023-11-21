<template>
    <div class="container">
        <div class="info"> {{ props.log.date }}</div>
        <div class="info"> {{ props.log.time }}</div>
        <div class="info url"> {{ videoUrl }}</div>
        <div class="button" @click="deleteClick"> 기록 삭제 </div>
    </div>
</template>

<script setup>
import { computed, onMounted, ref, watchEffect } from 'vue';
import { useRouter } from 'vue-router';
import { useRecordStore } from "@/stores/recordStore";
import { getAllRecord, deleteRecord } from "@/util/RecordApi";
import { useUserStore } from "@/stores/userStore";
import { getVideoById } from "@/util/VideoApi";

const recordStore = useRecordStore();
const userStore = useUserStore();
const videoUrl = ref("");

const props = defineProps({
    log: {
        type: Object,
        required: true,
    },
});

watchEffect(() => {
    getVideoById(props.log.videoId)
        .then((videoData) => {
            videoUrl.value = videoData.videoUrl;
        })
        .catch((error) => {
            console.error(error);
        });
});


const deleteClick = () => {
    deleteRecord(props.log.recordId)
        .then(() => {
            alert("삭제되었습니다");
            getAllRecord(userStore.user.userId)
            .then((data) => {
                recordStore.records = data.slice(0, 17);
            })
            .catch((e) => {
                console.log(e);
            })
    })
}
</script>

<style scoped>
* {
  box-sizing: border-box;
}
.container{
    margin-top: 8px;
    display: flex;
    justify-content: space-between;
}
.info{
    width: 15%;
    height: 40px;
    font-size: 14px;
    display: flex;
    align-items: center;
    justify-content: center;
    border-top: solid 1px lightgrey;
    border-bottom: solid 1px lightgrey;
    border-left: 1px dotted lightgray;
    border-right: 1px dotted lightgray;
    border-radius: 5px;
    color: #333333b4;
}
.url{
    width: 60%;
}
.button{
    width: 8%;
    font-size: 14px;
    display: flex;
    align-items: center;
    border-radius: 5px;
    justify-content: center;
    background-color: lightgray;
    color: #ffffffc8;
}
.button:hover{
    cursor: pointer;
}
</style>