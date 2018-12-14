import Vue from 'vue';
import Router from 'vue-router';
import Main from '../../monitor/page/Main';

Vue.use(Router);

const routers = [
  {
    path: '/monitor',
    name: 'Monitor',
    meta: {
      title: '服务监控模块',
      breadNumber: 1
    },
    component: Main,
    children: [
      {
        path: 'appsvr',
        name: 'Appsvr',
        meta: {
          title: '应用模块',
          breadNumber: 2
        },
        component: resolve => require(['../page/Appsvr'], resolve)
      },
      {
        path: 'language',
        name: 'Language',
        meta: {
          title: '语音标识',
          breadNumber: 2
        },
        component: resolve => require(['../page/Language'], resolve)
      },
      {
        path: 'monitorPot',
        name: 'MonitorPot',
        meta: {
          title: '监测点',
          breadNumber: 2
        },
        component: resolve => require(['../page/MonitorPot'], resolve)
      }

    ]
  }
]
;

export default routers;
