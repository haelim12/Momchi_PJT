<template>
    <div class="streak-container">
        <div class="month-title">{{ index+1 }}월</div>
        <div class="grass-container">
            <div v-for="(week, weekIndex) in weeks" :key="weekIndex" class="week">
                <div v-for="(day, dayIndex) in week" :key="dayIndex" class="square" 
                :style="{ backgroundColor: record[weekIndex][dayIndex] === 1 ? '#E5E5E5' : 'white'}"></div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { onMounted, ref } from 'vue';

const props = defineProps(["monthDays", "index"]);
const days = ref([]);
const weeks = ref([]);
const record = ref([[0, 1, 0, 0, 1, 1, 1],
                    [0, 1, 0, 1, 1, 1, 0],
                    [0, 0, 0, 0, 1, 1, 1],
                    [1, 1, 0, 0, 0, 0, 1],
                    [0, 0, 1, 1, 1, 1, 1],
                    [1, 1, 0, 0, 1, 1, 0]]);

onMounted(() => {
    getDays();
    splitIntoWeeks();
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
.streak-container{

}
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
  border: solid 1px #e9e9e9;
  margin: 1px;
  border-radius: 4px;
}
</style>