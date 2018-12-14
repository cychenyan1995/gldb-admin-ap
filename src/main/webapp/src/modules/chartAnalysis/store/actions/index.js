import {getMkInboxList, getNavRequList} from '../../../../api/chartAnalysis';

export default {
  queryInboxList ({commit}, payload) {
    getMkInboxList(payload.params).then(res => {
      payload.e.listLoading = false;
      commit('setList', res.data);
      payload.callback();
    }).catch(err => {
      payload.e.listLoading = false;
      payload.e.$notify.error({
        title: '请求失败！',
        message: err.message
      });
    });
  },
  queryNavRequList ({commit}, payload) {
    getNavRequList(payload.params).then(res => {
      payload.e.listLoading = false;
      commit('setNavRequList', res.data);
      payload.callback();
    }).catch(err => {
      payload.e.listLoading = false;
      payload.e.$notify.error({
        title: '请求失败！',
        message: err.message
      });
    });
  }
};
