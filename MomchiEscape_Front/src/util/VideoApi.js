import axios from "axios";

const API_URL = "http://localhost:8081/videos";

function getVideos() {
  return new Promise((resolve, reject) => {
    axios
      .get(API_URL)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
      });
  });
}

function getVideosByLevel(level) {
  console.log(`${API_URL}/${level}`);
  return new Promise((resolve, reject) => {
    axios
      .get(`${API_URL}/${level}`)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
    })
  })
}

export { getVideos, getVideosByLevel };