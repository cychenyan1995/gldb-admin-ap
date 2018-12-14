import http from '../http';
import constants from '../../config/constants';
export function getLoginInfoList (params) {
  return http.get(`${constants.httpApi}/gldb-admin-ap/userLog/list`, params);
}
