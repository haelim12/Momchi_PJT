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

export { registRecordApi };