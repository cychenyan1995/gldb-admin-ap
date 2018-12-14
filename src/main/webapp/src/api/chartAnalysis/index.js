import http from '../http';
import constants from '../../config/constants';
export function getMkInboxList (params) {
  return http.get(`${constants.httpApi}/gldb-admin-ap/chartAnalysis/mkInbox`, params);
}

export function getNavRequList (params) {
  return http.get(`${constants.httpApi}/gldb-admin-ap/chartAnalysis/navRequ`, params);
}
