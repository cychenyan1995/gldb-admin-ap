package com.glsx.oms.bigdata.admin.ap.navigation.service;

import java.util.List;

import javax.annotation.Resource;

import org.oreframework.web.ui.Pagination;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.glsx.oms.bigdata.admin.ap.navigation.mapper.NavigationMapper;
import com.glsx.oms.bigdata.admin.ap.navigation.model.NavRequInfo;
import com.glsx.oms.bigdata.admin.ap.userLog.service.BaseService;

@Service
public class NavRequService extends BaseService<NavRequInfo> {

	@Resource
	NavigationMapper navigationMapper;

	public PageInfo<NavRequInfo> getNavRequListByPage(NavRequInfo navRequInfo, Pagination pagination) {
		PageInfo<NavRequInfo> pageInfo = setPageInfo(pagination);
		Page<NavRequInfo> page = getPage(pageInfo);
		List<NavRequInfo> list = navigationMapper.selectNavRequList(navRequInfo);
		setPageInfo(pageInfo, page, list);
		return pageInfo;
	}

}
