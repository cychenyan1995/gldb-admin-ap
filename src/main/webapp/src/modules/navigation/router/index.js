import Vue from 'vue';
import Router from 'vue-router';
import Main from '../page/Main';

Vue.use(Router);

const routers = [
  {
    path: '/navigation',
    name: 'Navigation',
    meta: {
      title: '一键导航',
      breadNumber: 1
    },
    component: Main,
    children: [
      {
        path: 'navRequest',
        name: 'NavRequest',
        meta: {
          title: '一键导航请求信息',
          breadNumber: 2
        },
        component: resolve => require(['../page/NavRequInfo'], resolve)
      },
      {
        path: 'navAddress',
        name: 'NavAddress',
        meta: {
          title: '一键导航推达地址信息',
          breadNumber: 2
        },
        component: resolve => require(['../page/NavAddInfo'], resolve)
      }
    ]
  }
];

export default routers;
