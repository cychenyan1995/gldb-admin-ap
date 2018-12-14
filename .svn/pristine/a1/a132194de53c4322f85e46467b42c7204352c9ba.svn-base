import Vue from 'vue';
import Router from 'vue-router';
import monitor from '../modules/monitor/router';
// import Login from '@/components/Login'
import navigation from '../modules/navigation/router';
import mkmsg from '../modules/mkmsg/router';
import operateInfo from '../modules/operateInfo/router';
import loginInfo from '../modules/loginInfo/router';
import chartAnalysis from '../modules/chartAnalysis/router';

Vue.use(Router);

export default new Router({
  mode: 'hash',
  routes: [
    {
      path: '/', // 首页
      redirect: '/mkmsg/mkinbox',
      name: 'Default'
    }, ...navigation, ...monitor, ...mkmsg, ...operateInfo, ...loginInfo, ...chartAnalysis,
    {
      path: '*', // 其他页面，强制跳转到登录页面
      redirect: '/login'
    }
  ]
});
