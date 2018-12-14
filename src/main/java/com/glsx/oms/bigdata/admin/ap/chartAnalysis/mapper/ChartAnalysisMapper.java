package com.glsx.oms.bigdata.admin.ap.chartAnalysis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.glsx.oms.bigdata.admin.ap.chartAnalysis.model.MkInboxAnalysis;
import com.glsx.oms.bigdata.admin.ap.chartAnalysis.model.NavRequInfoAnalysis;

@Mapper
public interface ChartAnalysisMapper {
	
	public List<MkInboxAnalysis> getMkInboxList(MkInboxAnalysis mkInboxAnalysis);
	
	public List<NavRequInfoAnalysis> getRequInfoList(NavRequInfoAnalysis navRequInfoAnalysis);

}
