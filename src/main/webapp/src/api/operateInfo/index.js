import http from '../http';
import constants from '../../config/constants';
export function getProgramVersion (params) {
  // return http.get('http://localhost:8099/ddBox/version', params);
  return http.get(`${constants.httpApi}/gldb-admin-ap/ddBox/version`, params);
}

export function getServerLoad (params) {
  // return http.get('http://localhost:8099/ddBox/svrloading', params);
  return http.get(`${constants.httpApi}/gldb-admin-ap/ddBox/svrloading`, params);
}

export function getChannelState (params) {
  // return http.get('http://192.168.2.171:8099/ddBox/channelstate', params);
  return http.get(`${constants.httpApi}/gldb-admin-ap/ddBox/channelstate`, params);
}

export function getDeviceOnline (params) {
  // return http.get('http://192.168.2.171:8099/ddBox/statiOnlineUsers', params);
  return http.get(`${constants.httpApi}/gldb-admin-ap/ddBox/statiOnlineUsers`, params);
}
