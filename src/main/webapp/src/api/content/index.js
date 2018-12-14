import axios from 'axios';

let base = '';

export const getInboxList = params => { return axios.get(`${base}/inbox/list`, { params: params }); };

export const getContentList = params => { return axios.get(`${base}/content/list`, { params: params }); };

export const getInboxListPage = params => { return axios.get(`${base}/inbox/listpage`, { params: params }); };

export const getContentListPage = params => { return axios.get(`${base}/content/listpage`, { params: params }); };
