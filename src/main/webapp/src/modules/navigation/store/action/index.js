import {getNavAddListByPage, getNavRequListByPage} from '../../../../api/navigation/index';

// actions
const actions = {
  // 列表 actions start
  navAddInfoList ({ dispatch }, payload) {
    payload.ref.listLoading = true;
    /* getRspListPage(payload.param).then((res) => {
      dispatch('setList', {total: res.data.total, navAddresss: res.data.NavAddresss});
      payload.ref.listLoading = false;
    }); */
    getNavAddListByPage(payload.param).then((res) => {
      dispatch('setList', {total: res.data.pageTotal, navAddresss: res.data.data});
      payload.ref.listLoading = false;
    });
  },
  setList ({ commit }, payload) {
    commit('setList', payload);
  },
  setCurrentPage ({ commit }, payload) {
    commit('setCurrentPage', payload);
  },
  navRequInfoList ({ dispatch }, payload) {
    payload.ref.listLoading = true;
    /* getRequInfoListPage(payload.param).then((res) => {
      dispatch('setRequList', {total: res.data.total, navRequests: res.data.NavRequests});
      payload.ref.listLoading = false;
    }); */
    getNavRequListByPage(payload.param).then((res) => {
      dispatch('setRequList', {total: res.data.pageTotal, navRequests: res.data.data});
      payload.ref.listLoading = false;
    });
  },
  setRequList ({ commit }, payload) {
    commit('setRequList', payload);
  },
  setRequCurrentPage ({ commit }, payload) {
    commit('setRequCurrentPage', payload);
  }
  // 列表 actions end
};

export default actions;
