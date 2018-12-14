export default {
  setMonitorList (state, data) {
    state.table.list = data.data;
    state.table.total = data.pageTotal;
  },
  setLanguageList (state, data) {
    state.language.language = data.data;
    state.language.total = data.pageTotal;
  },
  setAppsvrList (state, data) {
    state.appsvr.appsvr = data.data;
    state.appsvr.total = data.pageTotal;
  }
};
