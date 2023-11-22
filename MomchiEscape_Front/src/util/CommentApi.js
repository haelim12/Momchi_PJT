import axios from "axios";

const API_URL = "http://localhost:8081/comment";

function saveComment(comment) {
    return new Promise((resolve, reject) => {
    axios
      .post(`${API_URL}`,comment)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
      });
  });
}

function getCommentByPostId(postId) {
    return new Promise((resolve, reject) => {
    axios
      .get(`${API_URL}/${postId}`)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
      });
  });
}

function updateComment(comment) {
    return new Promise((resolve, reject) => {
    axios
      .put(`${API_URL}`,comment)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
      });
  });
}

function deleteComment(commentId) {
    return new Promise((resolve, reject) => {
    axios
      .delete(`${API_URL}/${commentId}`)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
      });
  });
}

export { saveComment, getCommentByPostId, updateComment, deleteComment };