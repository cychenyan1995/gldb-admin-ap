package com.glsx.oms.bigdata.admin.ap.chartAnalysis.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glsx.oms.bigdata.admin.ap.chartAnalysis.controller.ChartAnalysisController;
import com.glsx.oms.bigdata.admin.ap.chartAnalysis.mapper.ChartAnalysisMapper;
import com.glsx.oms.bigdata.admin.ap.chartAnalysis.model.MkInboxAnalysis;
import com.glsx.oms.bigdata.admin.ap.chartAnalysis.model.NavRequInfoAnalysis;

@Service
public class ChartAnalysisService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ChartAnalysisController.class);

	@Autowired
	private ChartAnalysisMapper chartAnalysisMapper;

	public List<MkInboxAnalysis> getMkInboxList(MkInboxAnalysis mkInboxAnalysis) {
		
		List<MkInboxAnalysis> mkInboxAnalysisList = new ArrayList<MkInboxAnalysis>();
		//设置查询的具体时间
		mkInboxAnalysis.setBeginTime(mkInboxAnalysis.getBeginTime() + " 00:00:00");
		mkInboxAnalysis.setEndTime(mkInboxAnalysis.getEndTime() + " 23:59:59");
		LOGGER.info("查询日期:"+mkInboxAnalysis.getBeginTime() + "到" + mkInboxAnalysis.getEndTime());
		mkInboxAnalysisList = chartAnalysisMapper.getMkInboxList(mkInboxAnalysis);
		return mkInboxAnalysisList;

	}

	public List<NavRequInfoAnalysis> getRequInfoList(NavRequInfoAnalysis navRequInfoAnalysis) {
		List<NavRequInfoAnalysis> navRequInfoAnalysisList = new ArrayList<NavRequInfoAnalysis>();
		//设置查询的具体时间
		navRequInfoAnalysis.setBeginTime(navRequInfoAnalysis.getBeginTime() + " 00:00:00");
		navRequInfoAnalysis.setEndTime(navRequInfoAnalysis.getEndTime() + " 23:59:59");
		LOGGER.info("查询日期:"+navRequInfoAnalysis.getBeginTime() + "到" + navRequInfoAnalysis.getEndTime());
		navRequInfoAnalysisList = chartAnalysisMapper.getRequInfoList(navRequInfoAnalysis);
		return navRequInfoAnalysisList;
	}

}
