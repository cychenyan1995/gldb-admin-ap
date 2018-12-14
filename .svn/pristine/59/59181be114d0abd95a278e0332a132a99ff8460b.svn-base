import Vue from 'vue';
import Vuex from 'vuex';
import common from '../modules/common/store';
import mkmsg from '../modules/mkmsg/store';
import operateInfo from '../modules/operateInfo/store';
import monitor from '../modules/monitor/store';
import navigation from '../modules/navigation/store';
import loginInfo from '../modules/loginInfo/store';
import chartAnalysis from '../modules/chartAnalysis/store';
Vue.use(Vuex);

// const debug = process.env.NODE_ENV !== 'production';
const debug = false;

export default new Vuex.Store({
  modules: {
    common,
    monitor,
    navigation,
    mkmsg,
    operateInfo,
    loginInfo,
    chartAnalysis
  },
  strict: debug
  // plugins: debug ? [createLogger()] : []
});
