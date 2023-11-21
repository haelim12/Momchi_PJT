import axios from "axios";

const API_URL = "http://localhost:8081/record";

function registRecordApi(record) {
  return new Promise((resolve, reject) => {
    axios
      .post(`${ API_URL }`, record)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
      });
  });
}

function getMontlyStreak(date, userId) {
  return new Promise((resolve, reject) => {
    axios
      .get(`${ API_URL }/streak/month?date=${date}&userId=${userId}`)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
      });
  });
}

function getStreak(userId) {
    return new Promise((resolve, reject) => {
    axios
      .get(`${ API_URL }/streak/${userId}`)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
      });
  });
}

function getAllRecord(userId) {
    return new Promise((resolve, reject) => {
    axios
      .get(`${ API_URL }/${userId}`)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
      });
  });
}

function deleteRecord(recordId) {
    return new Promise((resolve, reject) => {
    axios
      .delete(`${ API_URL }/${recordId}`)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
      });
  });
}

export { registRecordApi, getMontlyStreak, getStreak, getAllRecord, deleteRecord };