<template>
    <div class="month-title">{{ index+1 }}월</div>
    <div class="grass-container">
        <div v-for="(week, weekIndex) in weeks" :key="weekIndex" class="week">
            <div
            v-for="(day, dayIndex) in week"
            :key="dayIndex"
            class="square"
            :style="{
                backgroundColor:
                    record[weekIndex][dayIndex] === 1
                        ? '#D9D9D9'
                        : record[weekIndex][dayIndex] === 0
                            ? 'white'
                            : '#white',
                border:
                    record[weekIndex][dayIndex] === 1
                        ? 'solid 1px #D9D9D9'
                        : record[weekIndex][dayIndex] === 0
                            ? 'solid 1px #D9D9D9'
                            : '1px dotted #e9e9e9'}"
          > </div>
        </div>
    </div>
</template>

<script setup>
import { computed, onMounted, ref } from 'vue';
import { getMontlyStreak } from '@/util/RecordApi';
import { useUserStore } from "@/stores/userStore";

const props = defineProps(["monthDays", "index"]);
const userStore = useUserStore();

const dayString = computed(() => {
    const currentDate = new Date();
    const currentYear = currentDate.getFullYear();
    return `${currentYear}-${props.index+1}`;
})

const days = ref([]);
const weeks = ref([]);
const record = ref([[0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0]]);

onMounted(() => {
    getDays();
    splitIntoWeeks();
    getMontlyStreak(dayString.value, userStore.user.userId)
        .then((data) => {
            record.value = data;
        })
        .catch((e) => {
            console.log(e);
    })
})

function getDays() {
    const firstDayOfWeek = new Date(new Date().getFullYear(), props.index , 1).getDay();
    let currentWeek = [];
    for (let i = 0; i < firstDayOfWeek; i++) {
        currentWeek.push(0);
    }
    currentWeek = [...currentWeek,...props.monthDays];
    days.value = currentWeek;
}

function splitIntoWeeks() {
    let collectWeek = [];
    let temp = [];
    for (let i = 0; i < days.value.length; i++){
        if (i !=0 && i%7 == 0) {
            collectWeek.push(temp);
            temp = [];
        }
        temp.push(days.value[i]);
        if (i == days.value.length - 1) {
            collectWeek.push(temp);
        }
    }
    if (collectWeek[collectWeek.length-1].length < 7) {
        while (collectWeek[collectWeek.length - 1].length < 7) {
            collectWeek[collectWeek.length - 1].push(0);
        }
    }
    weeks.value = collectWeek;
}

</script>

<style scoped>
.month-title{
    font-size: 13px;
    color: #333333c4;
    padding-left: 5px;
    margin-bottom: 5px;
}
.grass-container{
    display: flex;
    border-left: 1px dotted #333333b9;;
    padding-left: 5px;
    padding-right: 5px;
}
.week {
  display: flex;
  flex-direction: column;
}
.square {
  width: 15px; 
  height: 15px;
  margin: 1px;
  border-radius: 4px;
  border: solid 1px white;
}
.full_square{
      border: solid 1px #e9e9e9;
      background-color: #E5E5E5;
}
.empty_square{
  border: solid 1px #e9e9e9;
}
</style>