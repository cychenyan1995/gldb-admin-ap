package com.glsx.oms.bigdata.admin.ap.navigation.service;

import java.util.List;

import javax.annotation.Resource;

import org.oreframework.web.ui.Pagination;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.glsx.oms.bigdata.admin.ap.navigation.mapper.NavigationMapper;
import com.glsx.oms.bigdata.admin.ap.navigation.model.NavAddInfo;
import com.glsx.oms.bigdata.admin.ap.userLog.service.BaseService;

@Service
public class NavAddService extends BaseService<NavAddInfo> {

	@Resource
	NavigationMapper navigationMapper;

	public PageInfo<NavAddInfo> getNavAddListByPage(NavAddInfo navAddInfo, Pagination pagination) {
		PageInfo<NavAddInfo> pageInfo = setPageInfo(pagination);
		Page<NavAddInfo> page = getPage(pageInfo);
		List<NavAddInfo> list = navigationMapper.selectNavAddList(navAddInfo);
		setPageInfo(pageInfo, page, list);
		return pageInfo;
	}

}
