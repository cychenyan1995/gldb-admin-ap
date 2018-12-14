package com.glsx.oms.bigdata.admin.ap.monitor.service;

import java.util.List;

import javax.annotation.Resource;

import org.oreframework.web.ui.Pagination;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.glsx.oms.bigdata.admin.ap.monitor.mapper.MonitorMapper;
import com.glsx.oms.bigdata.admin.ap.monitor.model.MonitorSpot;
import com.glsx.oms.bigdata.admin.ap.userLog.service.BaseService;

@Service
public class MonitorSpotService extends BaseService<MonitorSpot> {

	@Resource
	MonitorMapper monitorMapper;

	public PageInfo<MonitorSpot> findMonitorSpot(MonitorSpot monitorSpot, Pagination pagination) {
		PageInfo<MonitorSpot> pageInfo = setPageInfo(pagination);
		Page<MonitorSpot> page = getPage(pageInfo);
		List<MonitorSpot> list = monitorMapper.findMonitorSpot(monitorSpot);
		setPageInfo(pageInfo, page, list);
		return pageInfo;
	}

	
}
