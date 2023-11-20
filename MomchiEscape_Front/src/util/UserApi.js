import axios from "axios";

const API_URL = "http://localhost:8080";

function registApi(user) {
  return new Promise((resolve, reject) => {
    axios
      .post(API_URL, user)
      .then((response) => {
        resolve(response.data);
      })
      .catch((e) => {
        reject(e);
      });
  });
}

export { registApi };
