import axios from "axios";

const API_URL = "http://localhost:8081";

function registApi(user) {
  return new Promise((resolve, reject) => {
    axios
      .post(`${ API_URL }/regist`, user)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
      });
  });
}

function loginApi(user) {
  return new Promise((resolve, reject) => {
    axios.post(`${API_URL}/login`, user)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
    })
  })
}

function getUserInfo(id) {
    return new Promise((resolve, reject) => {
    axios.get(`${API_URL}/user/${id}`)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
    })
  })
}

function getPopularUser() {
    return new Promise((resolve, reject) => {
    axios.get(`${API_URL}/user`)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
    })
  })
}
function deleteAccount(userId) {
    return new Promise((resolve, reject) => {
    axios.delete(`${API_URL}/user/${userId}`)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
    })
  })
}


export { registApi, loginApi, getUserInfo, getPopularUser,deleteAccount };
