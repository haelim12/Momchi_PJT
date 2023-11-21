<template>
    <div class="container">
        <div class="info"> date</div>
        <div class="info"> time</div>
        <div class="info url"> videourl</div>
        <div class="button"> </div>
    </div>
</template>

<script setup>

</script>

<style scoped>
* {
  box-sizing: border-box;
}
.container{
    margin-top: 10px;
    display: flex;
    justify-content: space-between;
}
.info{
    width: 15%;
    height: 40px;
    font-size: 15px;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: #33333383;
    border-radius: 5px;
    color: #ffffffc8;
}
.url{
    width: 60%;
}
.button{
    width: 8%;
}
</style>