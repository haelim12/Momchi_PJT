import axios from "axios";

const API_URL_CURRENT = `http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst`;
const API_URL_DAY =
  "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";
const API_KEY =
  "Gsc8g6lFzqJtUWn9q5im3d5DkD4ktxES2gBcjyZnjW2yfiBhPAGBIOpcNJ3aY9%2FD0RfyuIiLcoGswHRJ5OgABQ%3D%3D";
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
    const hour = getCurrentTime();
    axios
      .get(API_URL_DAY, {
        params: {
          serviceKey: API_KEY,
          numOfRows: 1000,
          pageNo: 1,
          dataType: "JSON",
          base_date: date,
          base_time: "0500",
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
