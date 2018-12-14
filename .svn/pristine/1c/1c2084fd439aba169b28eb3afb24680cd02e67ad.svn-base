import Vue from 'vue';
import Router from 'vue-router';
import Main from '../page/Main';

Vue.use(Router);

const routers = [
  {
    path: '/mkmsg',
    name: 'MkMsg',
    meta: {
      title: '营销信息',
      breadNumber: 1
    },
    component: Main,
    children: [
      {
        path: 'mkinbox',
        name: 'MkInbox',
        meta: {
          title: '推送信息',
          breadNumber: 2
        },
        component: resolve => require(['../page/Inbox'], resolve)
      },
      {
        path: 'mkcontent',
        name: 'MkContent',
        meta: {
          title: '推送内容信息',
          breadNumber: 2
        },
        component: resolve => require(['../page/Content'], resolve)
      }
    ]
  }
];

export default routers;
