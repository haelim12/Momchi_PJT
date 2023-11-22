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

function updatePost(post) {
    return new Promise((resolve, reject) => {
      axios
        .put(`${API_URL}`,post)
        .then((response) => {
          resolve(response.data);
        })
        .catch((e) => {
          reject(e);
        });
    });
}

function deletePost(postId) {
    return new Promise((resolve, reject) => {
      axios
        .delete(`${API_URL}/${postId}`)
        .then((response) => {
          resolve(response.data);
        })
        .catch((e) => {
          reject(e);
        });
    });
}


export { savePost, getPostsByCategory,updatePost,deletePost };