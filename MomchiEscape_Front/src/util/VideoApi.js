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
  return new Promise((resolve, reject) => {
    axios
      .get(`${API_URL}/level/${level}`)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
    })
  })
}

function getVideoById(videoId) {
    return new Promise((resolve, reject) => {
    axios
      .get(`${API_URL}/${videoId}`)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
    })
  })
}

function getPopularVideo() {
    return new Promise((resolve, reject) => {
    axios
      .get(`${API_URL}/popular`)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
    })
  })
}

export { getVideos, getVideosByLevel, getVideoById, getPopularVideo };