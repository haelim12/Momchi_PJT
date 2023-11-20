import axios from "axios";

const API_URL = "http://localhost:8081/post";

function savePost(post) {
  return new Promise((resolve, reject) => {
    axios
      .post(API_URL, post)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
      });
  });
}

function getPostsByCategory(category) {
    return new Promise((resolve, reject) => {
      axios
        .get(`${API_URL}/category/${category}`)
        .then((response) => {
          resolve(response.data);
        })
        .catch((e) => {
          reject(e);
        });
    });
}

export { savePost, getPostsByCategory };