package com.glsx.oms.bigdata.admin.ap.monitor.controller;


import javax.annotation.Resource;

import org.oreframework.web.ui.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.glsx.oms.bigdata.admin.ap.monitor.model.Appsvr;
import com.glsx.oms.bigdata.admin.ap.monitor.model.Language;
import com.glsx.oms.bigdata.admin.ap.monitor.model.MonitorSpot;
import com.glsx.oms.bigdata.admin.ap.monitor.service.AppsvrService;
import com.glsx.oms.bigdata.admin.ap.monitor.service.LanguageService;
import com.glsx.oms.bigdata.admin.ap.monitor.service.MonitorSpotService;
import com.glsx.oms.bigdata.admin.ap.vo.RespMessage;

@RestController
@RequestMapping(value="/monitor")
public class MonitorController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(MonitorController.class);

	@Resource
	AppsvrService appsvrService;
	
	@Resource
	LanguageService languageService;
	
	@Resource
	MonitorSpotService monitorSpotService;
	
	@GetMapping(value="/findAppsvr")
	public RespMessage findAppsvr(Appsvr appsvr, Pagination pagination){
		RespMessage rm = new RespMessage();
        PageInfo<Appsvr> page = appsvrService.getListByPage(appsvr, pagination);
        rm.setData(page.getList());
        rm.setPageTotal(page.getTotal());
        return rm;
	}
	
	@GetMapping(value="/findLanguage")
	public RespMessage findLanguage(Language language, Pagination pagination){
		RespMessage rm = new RespMessage();
        PageInfo<Language> page = languageService.findLanguage(language, pagination);
        rm.setData(page.getList());
        rm.setPageTotal(page.getTotal());
        return rm;
	}
	
	@GetMapping("/findMonitorSpot")
	public RespMessage findMonitorSpot(MonitorSpot monitorSpot, Pagination pagination){
		RespMessage rm = new RespMessage();
        PageInfo<MonitorSpot> page = monitorSpotService.findMonitorSpot(monitorSpot, pagination);
        rm.setData(page.getList());
        rm.setPageTotal(page.getTotal());
        return rm;
	}
	
	
}
