<template>
    <div class="container">
        <div class="info"> date</div>
        <div class="info"> time</div>
        <div class="info url"> videourl</div>
        <div class="button"> delete</div>
    </div>
</template>

<script setup>

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
    height: 33px;
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
    width: 7%;
    font-size: 14px;
    display: flex;
    align-items: center;
    border-radius: 5px;
    justify-content: center;
    background-color: lightgray;
    color: #ffffffc8;
}
</style>