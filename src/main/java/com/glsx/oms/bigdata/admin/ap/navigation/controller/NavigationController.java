package com.glsx.oms.bigdata.admin.ap.navigation.controller;

import javax.annotation.Resource;

import org.oreframework.web.ui.Pagination;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.glsx.oms.bigdata.admin.ap.navigation.model.NavAddInfo;
import com.glsx.oms.bigdata.admin.ap.navigation.model.NavRequInfo;
import com.glsx.oms.bigdata.admin.ap.navigation.service.NavAddService;
import com.glsx.oms.bigdata.admin.ap.navigation.service.NavRequService;
import com.glsx.oms.bigdata.admin.ap.vo.RespMessage;

@RestController
@RequestMapping("/navigation")
public class NavigationController {

	@Resource
	NavAddService navAddService;
	@Resource
	NavRequService navRequService;

	@GetMapping("/getNavAddListByPage")
	public RespMessage getNavAddListByPage(NavAddInfo navAddInfo, Pagination pagination) {
		RespMessage rm = new RespMessage();
		PageInfo<NavAddInfo> page = navAddService.getNavAddListByPage(navAddInfo, pagination);
		rm.setData(page.getList());
		rm.setPageTotal(page.getTotal());
		return rm;
	}

	@GetMapping("/getNavRequListByPage")
	public RespMessage getNavAddListByPage(NavRequInfo navRequInfo, Pagination pagination) {
		RespMessage rm = new RespMessage();
		PageInfo<NavRequInfo> page = navRequService.getNavRequListByPage(navRequInfo, pagination);
		rm.setData(page.getList());
		rm.setPageTotal(page.getTotal());
		return rm;
	}

}
