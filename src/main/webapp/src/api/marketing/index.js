import constants from '../../config/constants';
import http from '../http';
// 营销消息 中的推送消息与推送内容消息
// let base = '';

export function getMkContentListByPage (params) {
  return http.get(`${constants.httpApi}/gldb-admin-ap/marketing/getMkContentListByPage`, params);
}

export function getMkInboxListByPage (params) {
  return http.get(`${constants.httpApi}/gldb-admin-ap/marketing/getMkInboxListByPage`, params);
}
