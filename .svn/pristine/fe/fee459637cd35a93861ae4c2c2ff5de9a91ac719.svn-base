package com.glsx.oms.bigdata.admin.ap.chartAnalysis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glsx.oms.bigdata.admin.ap.chartAnalysis.model.MkInboxAnalysis;
import com.glsx.oms.bigdata.admin.ap.chartAnalysis.model.NavRequInfoAnalysis;
import com.glsx.oms.bigdata.admin.ap.chartAnalysis.service.ChartAnalysisService;

@RestController
@RequestMapping(value = "/chartAnalysis")
public class ChartAnalysisController {


	@Autowired
	private ChartAnalysisService chartAnalysisService;

	@RequestMapping(value = "/mkInbox")
	public List<MkInboxAnalysis> getMkInboxList(MkInboxAnalysis mkInboxAnalysis) {
		List<MkInboxAnalysis> contentsList = new ArrayList<MkInboxAnalysis>();
		contentsList = chartAnalysisService.getMkInboxList(mkInboxAnalysis);
		return contentsList;
	}
	
	@RequestMapping(value = "/navRequ")
	public List<NavRequInfoAnalysis> getNavRequList(NavRequInfoAnalysis navRequInfoAnalysis) {
		List<NavRequInfoAnalysis> requestsList = new ArrayList<NavRequInfoAnalysis>();
		requestsList = chartAnalysisService.getRequInfoList(navRequInfoAnalysis);
		return requestsList;
	}

}
