import Vue from 'vue';
import Router from 'vue-router';
import Main from '../../chartAnalysis/page/Main';

Vue.use(Router);

const routers = [
  {
    path: '/chartAnalysis',
    name: 'ChartAnalysis',
    meta: {
      title: '报表分析',
      breadNumber: 1
    },
    component: Main,
    children: [
      {
        path: 'mkinboxAnalysis',
        name: 'MkInboxAnalysis',
        meta: {
          title: '推送信息报表分析',
          breadNumber: 2
        },
        component: resolve => require(['../page/Chart'], resolve)
      },
      {
        path: 'navrequAnalysis',
        name: 'NavRequAnalysis',
        meta: {
          title: '一键导航报表分析',
          breadNumber: 2
        },
        component: resolve => require(['../page/NavChart'], resolve)
      }
    ]
  }
];

export default routers;
