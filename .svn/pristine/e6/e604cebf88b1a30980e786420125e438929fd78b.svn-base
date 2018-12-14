package com.glsx.oms.bigdata.admin.ap.monitor.service;

import java.util.List;

import javax.annotation.Resource;

import org.oreframework.web.ui.Pagination;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.glsx.oms.bigdata.admin.ap.monitor.mapper.MonitorMapper;
import com.glsx.oms.bigdata.admin.ap.monitor.model.Language;
import com.glsx.oms.bigdata.admin.ap.userLog.service.BaseService;
@Service
public class LanguageService extends BaseService<Language>{

		@Resource
		MonitorMapper monitorMapper;
		
		public PageInfo<Language> findLanguage(Language language, Pagination pagination) {
	        PageInfo<Language> pageInfo = setPageInfo(pagination);
	        Page<Language> page = getPage(pageInfo);
	        List<Language> list = monitorMapper.findLanguage(language);
	        setPageInfo(pageInfo, page, list);
	        return pageInfo;
	    }
	


}
