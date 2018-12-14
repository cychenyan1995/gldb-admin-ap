import axios from 'axios';

// 创建axios默认请求
// axios.defaults.baseURL = 'http://xxxxxx.com';
// 配置超时时间
axios.defaults.timeout = 100000;
// 配置请求拦截
axios.interceptors.request.use(config => {
  // config.setHeaders([
  //   // 在这里设置请求头与携带token信息
  // ]);
  return config;
});
// 添加响应拦截器
axios.interceptors.response.use(
  function (response) {
    console.log(response);
    return response;
  },
  function (error) {
    // 对响应错误做点什么
    return Promise.reject(error);
  }
);
/**
 * get请求
 * @method get
 * @param {url, params, loading} 请求地址，请求参数，是否需要加载层
 */
let get = function (url, params) {
  return new Promise((resolve, reject) => {
    axios
      .get(url, {
        params: params
      })
      .then(res => {
        resolve(res);
      })
      .catch(err => {
        reject(err);
      });
  });
};
/**
 * post请求
 * @method post
 * @param {url, params} 请求地址，请求参数，是否需要加载层
 */
let post = function (url, data) {
  return new Promise((resolve, reject) => {
    axios
      .post(url, JSON.stringify(data))
      .then(res => {
        resolve(res);
      })
      .catch(err => {
        reject(err);
      });
  });
};
export default {get, post};
