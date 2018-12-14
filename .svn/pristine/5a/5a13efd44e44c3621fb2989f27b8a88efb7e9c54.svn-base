import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

const routers = [
  {
    path: '/operateInfo',
    name: 'OperateInfo',
    meta: {
      title: '运营信息管理',
      breadNumber: 1
    },
    component: resolve => require(['../page/Main'], resolve),
    children: [
      {
        path: 'programVersion',
        name: 'ProgramVersion',
        meta: {
          title: '程序版本信息',
          breadNumber: 2
        },
        component: resolve => require(['../page/ProgramVersion'], resolve)
      },
      {
        path: 'serverLoad',
        name: 'ServerLoad',
        meta: {
          title: '服务器负载信息',
          breadNumber: 2
        },
        component: resolve => require(['../page/ServerLoad'], resolve)
      },
      {
        path: 'channelState',
        name: 'ChannelState',
        meta: {
          title: '程序通讯信息',
          breadNumber: 2
        },
        component: resolve => require(['../page/ChannelState'], resolve)
      },
      {
        path: 'deviceOnline',
        name: 'DeviceOnline',
        meta: {
          title: '设备在线信息',
          breadNumber: 2
        },
        component: resolve => require(['../page/DeviceOnline'], resolve)
      }
    ]
  }
];

export default routers;
