import axios from "axios";

const API_URL = "http://localhost:8081/like";

function checkLike(userId, postId) {
    return new Promise((resolve, reject) => {
    axios
      .get(`${API_URL}?userId=${userId}&postId=${postId}`)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
      });
  });
}

function likeApi(like) {
  return new Promise((resolve, reject) => {
    axios
      .post(`${API_URL}`,like)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
      });
  });
}


export { checkLike, likeApi };