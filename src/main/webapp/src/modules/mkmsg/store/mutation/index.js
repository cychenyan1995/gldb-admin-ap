// mutations
const mutations = {
  setCurrentPage (state, payload) {
    state.inbox.page = payload.page;
  },
  setList (state, payload) {
    state.inbox.inboxs = payload.inboxs;
    state.inbox.total = payload.total;
  },
  setContentCurrentPage (state, payload) {
    state.content.page = payload.page;
  },
  setcontentList (state, payload) {
    state.content.contents = payload.contents;
    state.content.total = payload.total;
  }
};

export default mutations;
