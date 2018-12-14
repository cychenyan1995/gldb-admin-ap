import constants from '../../config/constants';
import http from '../http';

export function getMonitorPotListPage (params) {
  return http.get(`${constants.httpApi}/gldb-admin-ap/monitor/findMonitorSpot`, params);
};

export function getLanguageListPage (params) {
  return http.get(`${constants.httpApi}/gldb-admin-ap/monitor/findLanguage`, params);
}
export function getAppsvrListPage (params) {
  return http.get(`${constants.httpApi}/gldb-admin-ap/monitor/findAppsvr`, params);
};
