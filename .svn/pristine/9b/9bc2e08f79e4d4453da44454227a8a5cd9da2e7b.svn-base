import {getMonitorPotListPage, getLanguageListPage, getAppsvrListPage} from '../../../../api/monitor';

export default {
  queryMonitorList ({commit}, payload) {
    getMonitorPotListPage(payload.params).then(res => {
      payload.e.listLoading = false;
      commit('setMonitorList', res.data);
    }).catch(err => {
      payload.e.listLoading = false;
      payload.e.$notify.error({
        title: '请求失败！',
        message: err.message
      });
    });
  },
  queryLanguageList ({commit}, payload) {
    getLanguageListPage(payload.params).then(res => {
      payload.e.listLoading = false;
      commit('setLanguageList', res.data);
    }).catch(err => {
      payload.e.listLoading = false;
      payload.e.$notify.error({
        title: '请求失败！',
        message: err.message
      });
    });
  },
  queryAppsvrList ({commit}, payload) {
    getAppsvrListPage(payload.params).then(res => {
      payload.e.listLoading = false;
      commit('setAppsvrList', res.data);
    }).catch(err => {
      payload.e.listLoading = false;
      payload.e.$notify.error({
        title: '请求失败！',
        message: err.message
      });
    });
  }
};
