// import { getInboxListPage, getContentListPage} from '../../../../api/content/index';
import { getMkInboxListByPage, getMkContentListByPage } from '../../../../api/marketing/index';
// actions
const actions = {
  // 列表 actions start
  inboxList ({ dispatch }, payload) {
    payload.ref.listLoading = true;
    /* getInboxListPage(payload.param).then((res) => {
      dispatch('setList', {total: res.data.total, inboxs: res.data.Inboxs});
      payload.ref.listLoading = false;
    }); */
    getMkInboxListByPage(payload.param).then((res) => {
      dispatch('setList', {total: res.data.pageTotal, inboxs: res.data.data});
      payload.ref.listLoading = false;
    });
  },
  setList ({ commit }, payload) {
    commit('setList', payload);
  },
  setCurrentPage ({ commit }, payload) {
    commit('setCurrentPage', payload);
  },
  contentList ({ dispatch }, payload) {
    payload.ref.listLoading = true;
    /* getContentListPage(payload.param).then((res) => {
      dispatch('setcontentList', {total: res.data.total, contents: res.data.Contents});
      payload.ref.listLoading = false;
    }); */
    getMkContentListByPage(payload.param).then((res) => {
      dispatch('setcontentList', {total: res.data.pageTotal, contents: res.data.data});
      payload.ref.listLoading = false;
    });
  },
  setcontentList ({ commit }, payload) {
    commit('setcontentList', payload);
  },
  setContentCurrentPage ({ commit }, payload) {
    commit('setContentCurrentPage', payload);
  }
};

export default actions;
