export default {
  setList (state, data) {
    state.table.list = data.data;
    state.table.total = data.pageTotal;
  }
};
