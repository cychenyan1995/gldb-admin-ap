import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import {LoginUsers} from './data/user';
import {Contents} from './data/content';
import {NavRequInfos} from './data/navRequ';
import {NavAddInfos} from './data/navAdd';
import {Inboxs} from './data/inbox';
import {Appsvrs} from './data/appsvr';
import {Languages} from './data/language';
import {MonitorPots} from './data/monitorpot';

let _Contents = Contents;
let _NavRequests = NavRequInfos;
let _NavAddresss = NavAddInfos;
let _Inboxs = Inboxs;
let _Appsvrs = Appsvrs;
let _Languages = Languages;
let _MonitorPots = MonitorPots;

export default {
  /**
   * mock bootstrap
   */
  bootstrap () {
    let mock = new MockAdapter(axios);

    // mock success request
    mock.onGet('/success').reply(200, {
      msg: 'success'
    });

    // mock error request
    mock.onGet('/error').reply(500, {
      msg: 'failure'
    });

    // 登录getUserList
    mock.onPost('/login').reply(config => {
      let {username, password} = JSON.parse(config.data);
      return new Promise((resolve, reject) => {
        let user = null;
        setTimeout(() => {
          let hasUser = LoginUsers.some(u => {
            if (u.username === username && u.password === password) {
              user = JSON.parse(JSON.stringify(u));
              user.password = undefined;
              return true;
            }
          });

          if (hasUser) {
            resolve([200, {code: 200, msg: '请求成功', user}]);
          } else {
            resolve([200, {code: 500, msg: '账号或密码错误'}]);
          }
        }, 1000);
      });
    });
    // 获取 营销消息推送信息 列表
    mock.onGet('/inbox/list').reply(config => {
      let {appmsgId} = config.params;
      let mockInboxs = _Inboxs.filter(Inboxs => {
        if (appmsgId && Inboxs.appmsgId.indexOf(appmsgId) === -1) return false;
        return true;
      });
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            Inboxs: mockInboxs
          }]);
        }, 1000);
      });
    });

    // 获取营销消息推送信息列表（分页）
    mock.onGet('/inbox/listpage').reply(config => {
      let {page, appmsgId} = config.params;
      let mockInboxs = _Inboxs.filter(Inboxs => {
        if (appmsgId && Inboxs.appmsgId.indexOf(appmsgId) === -1) return false;
        return true;
      });
      let total = mockInboxs.length;
      mockInboxs = mockInboxs.filter((u, index) => index < 15 * page && index >= 15 * (page - 1));
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            total: total,
            Inboxs: mockInboxs
          }]);
        }, 1000);
      });
    });

    // 获取 营销消息推送内容信息 列表
    /* mock.onGet('/content/list').reply(config => {
      // 搜索词：主键context
      let {context} = config.params;
      let mockContents = _Contents.filter(content => {
        if (context && content.context.indexOf(context) === -1) return false;
        return true;
      });
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            contents: mockContents
          }]);
        }, 1000);
      });
    }); */
    mock.onGet('/content/list').reply(config => {
      // 搜索词：主键context
      let {context} = config.params;
      let mockContents = _Contents.filter(Contents => {
        if (context && Contents.context.indexOf(context) === -1) return false;
        return true;
      });
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            Contents: mockContents
          }]);
        }, 1000);
      });
    });

    // 获取内容信息列表（分页）
    mock.onGet('/content/listpage').reply(config => {
      let {page, context} = config.params;
      let mockContents = _Contents.filter(Contents => {
        if (context && Contents.context.indexOf(context) === -1) return false;
        return true;
      });
      let total = mockContents.length;
      mockContents = mockContents.filter((u, index) => index < 15 * page && index >= 15 * (page - 1));
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            total: total,
            Contents: mockContents
          }]);
        }, 1000);
      });
    });

    // 获取导航请求信息列表
    mock.onGet('/navigation/list').reply(config => {
      let {userId} = config.params;
      let mockNavs = _NavRequests.filter(NavRequInfos => {
        if (userId && NavRequInfos.userId.indexOf(userId) === -1) return false;
        return true;
      });
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            NavRequInfos: mockNavs
          }]);
        }, 1000);
      });
    });

    // 获取导航请求信息列表（分页）
    mock.onGet('/navigation/listpage').reply(config => {
      let {page, name} = config.params;
      let mockNavs = _NavRequests.filter(user => {
        if (name && user.name.indexOf(name) === -1) return false;
        return true;
      });
      let total = mockNavs.length;
      mockNavs = mockNavs.filter((u, index) => index < 15 * page && index >= 15 * (page - 1));
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            total: total,
            mockNavs: mockNavs
          }]);
        }, 1000);
      });
    });

    // 获取应用模块列表（分页）
    mock.onGet('/appsvr/listpage').reply(config => {
      let {page, appId} = config.params;
      let mockAppsvrs = _Appsvrs.filter(Appsvrs => {
        if (appId && Appsvrs.appId.indexOf(appId) === -1) return false;
        return true;
      });
      let total = mockAppsvrs.length;
      mockAppsvrs = mockAppsvrs.filter((u, index) => index < 15 * page && index >= 15 * (page - 1));
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            total: total,
            Appsvrs: mockAppsvrs
          }]);
        }, 1000);
      });
    });

    // 获取应用模块列表（分页）
    mock.onGet('/langular/listpage').reply(config => {
      let {page, lanCode} = config.params;
      let mockLanguages = _Languages.filter(Languages => {
        if (lanCode && Languages.lanCode.indexOf(lanCode) === -1) return false;
        return true;
      });
      let total = mockLanguages.length;
      mockLanguages = mockLanguages.filter((u, index) => index < 15 * page && index >= 15 * (page - 1));
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            total: total,
            Languages: mockLanguages
          }]);
        }, 1000);
      });
    });

    // 获取监测点列表（分页）
    mock.onGet('/monitorPot/listpage').reply(config => {
      let {page, keyId} = config.params;
      let mockMonitorPots = _MonitorPots.filter(MonitorPots => {
        if (keyId && MonitorPots.keyId.indexOf(keyId) === -1) return false;
        return true;
      });
      let total = mockMonitorPots.length;
      mockMonitorPots = mockMonitorPots.filter((u, index) => index < 15 * page && index >= 15 * (page - 1));
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            total: total,
            MonitorPots: mockMonitorPots
          }]);
        }, 1000);
      });
    });

    // 获取导航请求信息列表
    mock.onGet('/navAddress/list').reply(config => {
      let {userId} = config.params;
      let mockNavs = _NavAddresss.filter(NavAddInfos => {
        if (userId && NavAddInfos.userId.indexOf(userId) === -1) return false;
        return true;
      });
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            NavAddInfos: mockNavs
          }]);
        }, 1000);
      });
    });

    // 获取导航请求地址信息列表（分页）
    mock.onGet('/navAddress/listpage').reply(config => {
      let {page, userId} = config.params;
      let mockNavAddresss = _NavAddresss.filter(NavAddresss => {
        if (userId && NavAddresss.userId.indexOf(userId) === -1) return false;
        return true;
      });
      let total = mockNavAddresss.length;
      mockNavAddresss = mockNavAddresss.filter((u, index) => index < 15 * page && index >= 15 * (page - 1));
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            total: total,
            NavAddresss: mockNavAddresss
          }]);
        }, 1000);
      });
    });

    // 获取导航请求信息列表（分页）
    mock.onGet('/navRequInfo/listpage').reply(config => {
      let {page, userId} = config.params;
      let mockNavRequests = _NavRequests.filter(NavRequests => {
        if (userId && NavRequests.userId.indexOf(userId) === -1) return false;
        return true;
      });
      let total = mockNavRequests.length;
      mockNavRequests = mockNavRequests.filter((u, index) => index < 15 * page && index >= 15 * (page - 1));
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve([200, {
            total: total,
            NavRequests: mockNavRequests
          }]);
        }, 1000);
      });
    });
  }
};
