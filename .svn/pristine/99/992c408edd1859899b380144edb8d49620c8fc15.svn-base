// mutations
const mutations = {
  breadListMutations (getters, list) {
    getters.breadListState = list;
    sessionStorage.setItem('breadListStorage', list);
  },
  activeRoute (state, routers) {
    var router = routers.router.currentRoute;
    var currentUrl = router.path;
    var currentRouteName = router.name;
    if (currentUrl === '/') {
      currentRouteName = routers.router.history.pending.name;
    }

    var menuList = state.menuListState;
    for (var i = 0; i < menuList.length; i++) {
      if (currentRouteName === menuList[i].name) {
        menuList[i].active = true;
        if (menuList[i].level === 2) {
          for (var z = 0; z < menuList.length; z++) {
            if (menuList[i].parentId === menuList[z].id) {
              menuList[z].active = true;
            }
          }
        }
      } else {
        menuList[i].active = false;
      }
    }
  },
  collapse (state, router) {
    var menuList = state.menuListState;
    for (var i = 0; i < menuList.length; i++) {
      // console.log(router.name === menuList[i].name);
      if (router.name.toLowerCase() === menuList[i].name.toLowerCase()) {
        if (menuList[i].collapse === false) {
          menuList[i].collapse = true;
        } else {
          menuList[i].collapse = false;
        }
      } else {
        menuList[i].collapse = true;
      }
    }
  }
};
export default mutations;
