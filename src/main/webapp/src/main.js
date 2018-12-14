// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import router from './router';
import App from './App';
import ElementUI from 'element-ui';

import store from './store';

// import Mock from './mock';

import 'bootstrap/dist/css/bootstrap.min.css';
import '../static/vendor/css/font-awesome.css';
import '../static/vendor/css/animate.css';
// import 'element-ui/lib/theme-chalk/index.css';
import '../static/vendor/element-ui/index.css';
import '../static/css/style.css';

// Mock.bootstrap();
// const debug = process.env.NODE_ENV === 'production';
// if (!debug) {
//   Mock.bootstrap();
// }

Vue.use(ElementUI);
Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
});
