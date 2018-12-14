import {getLoginInfoList} from '../../../../api/loginInfo';

export default {
  queryList ({commit}, payload) {
    getLoginInfoList(payload.params).then(res => {
      payload.e.listLoading = false;
      commit('setList', res.data);
    }).catch(err => {
      payload.e.listLoading = false;
      payload.e.$notify.error({
        title: '请求失败！',
        message: err.message
      });
    });
  }
};
