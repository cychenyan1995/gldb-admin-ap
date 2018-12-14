package com.glsx.oms.bigdata.admin.ap.monitor.service;
import java.util.List;

import javax.annotation.Resource;

import org.oreframework.web.ui.Pagination;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.glsx.oms.bigdata.admin.ap.monitor.mapper.MonitorMapper;
import com.glsx.oms.bigdata.admin.ap.monitor.model.Appsvr;
import com.glsx.oms.bigdata.admin.ap.userLog.service.BaseService;

@Service
public class AppsvrService extends BaseService<Appsvr>{
	
	@Resource
	MonitorMapper monitorMapper;
	
	public PageInfo<Appsvr> getListByPage(Appsvr appsvr, Pagination pagination) {
        PageInfo<Appsvr> pageInfo = setPageInfo(pagination);
        Page<Appsvr> page = getPage(pageInfo);
        List<Appsvr> list = monitorMapper.findAppsvr(appsvr);
        setPageInfo(pageInfo, page, list);
        return pageInfo;
    }
}
