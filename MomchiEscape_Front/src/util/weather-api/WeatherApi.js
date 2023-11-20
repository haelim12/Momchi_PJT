import axios from "axios";

const API_URL_CURRENT = `http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst`;
const API_URL_DAY =
  "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
const API_KEY =
  "Gsc8g6lFzqJtUWn9q5im3d5DkD4ktxES2gBcjyZnjW2yfiBhPAGBIOpcNJ3aY9/D0RfyuIiLcoGswHRJ5OgABQ==";
const times = ["0200", "0500", "0800", "1100", "1400", "1700", "2000", "2300"];
function getTodayDate() {
  const today = new Date();
  let year = today.getFullYear();
  let month = today.getMonth() + 1;
  let day = today.getDate();

  month = month < 10 ? "0" + month : month;
  day = day < 10 ? "0" + day : day;
  return `${year}${month}${day}`;
}

function getCurrentTime() {
  const today = new Date();
  let hour = today.getHours();
  let minute = today.getMinutes();

  if (hour === 0 && minute < 45) {
    today.setDate(today.getDate() - 1);
    hour = 23;
    minute = 30;
  } else if (minute < 45) {
    hour -= 1;
  }
  hour = hour < 10 ? "0" + hour : hour;
  return hour;
}

function getAnnouncementTime() {
  const today = new Date();
  let hour = today.getHours();
  if (3<=hour && hour<6) {
    return "0200";
  }
  else if (6<=hour && hour<9) {
    return "0500";
  }
  else if (9<=hour && hour<12) {
    return "0800";
  }
  else if (12<=hour && hour<15) {
    return "1100";
  }
  else if (15<=hour && hour<16) {
    return "1400";
  }
  else if (16<=hour && hour<21) {
    return "1700";
  }
  else if (21<=hour) {
    return "2000";
  }
    else if (hour<3) {
    return "2300";
  }
}

function getCurrentWeather() {
  return new Promise((resolve, reject) => {
    const date = getTodayDate();
    const hour = getCurrentTime();
    axios
      .get(API_URL_CURRENT, {
        params: {
          serviceKey: API_KEY,
          numOfRows: 1000,
          pageNo: 1,
          dataType: "JSON",
          base_date: date,
          base_time: `${hour}30`,
          nx: 61,
          ny: 125,
        },
      })
      .then((response) => {
        resolve(response.data.response.body.items);
      })
      .catch((e) => {
        reject(e);
      });
  });
}

function getTodayWeather() {
  return new Promise((resolve, reject) => {
    const date = getTodayDate();
    const hour = getAnnouncementTime();
    axios
      .get(API_URL_DAY, {
        params: {
          serviceKey: API_KEY,
          numOfRows: 1000,
          pageNo: 1,
          dataType: "JSON",
          base_date: date,
          base_time: `${hour}`,
          nx: 61,
          ny: 125,
        },
      })
      .then((response) => {
        resolve(response.data.response.body.items);
      })
      .catch((e) => {
        reject(e);
      });
  });
}

export { getCurrentWeather, getTodayWeather };
