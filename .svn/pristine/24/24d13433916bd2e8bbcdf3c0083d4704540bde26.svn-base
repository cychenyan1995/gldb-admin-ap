import {getProgramVersion, getServerLoad, getChannelState, getDeviceOnline} from '../../../../api/operateInfo';

export default {
  queryProgramVersion ({commit}, payload) {
    getProgramVersion(payload.params).then(res => {
      commit('setProgramVersion', res.data);
    }).catch(err => {
      payload.e.$notify.error({
        title: '请求失败！',
        message: err.message
      });
    });
  },
  queryServerLoad ({commit}, payload) {
    getServerLoad(payload.params).then(res => {
      payload.e.listLoading = false;
      commit('setServerLoad', res.data);
    }).catch(err => {
      payload.e.listLoading = false;
      payload.e.$notify.error({
        title: '请求失败！',
        message: err.message
      });
    });
  },
  queryChannelState ({commit}, payload) {
    getChannelState(payload.params).then(res => {
      payload.e.listLoading = false;
      commit('setChannelState', res.data);
    }).catch(err => {
      payload.e.listLoading = false;
      payload.e.$notify.error({
        title: '请求失败！',
        message: err.message
      });
    });
  },
  queryDeviceOnline ({commit}, payload) {
    getDeviceOnline(payload.params).then(res => {
      payload.e.listLoading = false;
      commit('setDeviceOnline', res.data);
    }).catch(err => {
      payload.e.listLoading = false;
      payload.e.$notify.error({
        title: '请求失败！',
        message: err.message
      });
    });
  }
};
