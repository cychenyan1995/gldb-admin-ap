// mutations
const mutations = {
  setList (state, payload) {
    state.navAdd.navAddresss = payload.navAddresss;
    state.navAdd.total = payload.total;
  },
  setCurrentPage (state, payload) {
    state.navAdd.page = payload.page;
  },
  setRequList (state, payload) {
    state.navRequ.navRequests = payload.navRequests;
    state.navRequ.total = payload.total;
  },
  setRequCurrentPage (state, payload) {
    state.navRequ.page = payload.page;
  }
};

export default mutations;
