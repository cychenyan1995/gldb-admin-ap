package com.glsx.oms.bigdata.admin.ap.marketing.service;

import java.util.List;

import javax.annotation.Resource;

import org.oreframework.web.ui.Pagination;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.glsx.oms.bigdata.admin.ap.marketing.mapper.MarketingMapper;
import com.glsx.oms.bigdata.admin.ap.marketing.model.MkContent;
import com.glsx.oms.bigdata.admin.ap.userLog.service.BaseService;
@Service
public class MkContentService extends BaseService<MkContent> {

	@Resource
	MarketingMapper marketingMapper;

	public PageInfo<MkContent> getMkContentListByPage(MkContent mkContent, Pagination pagination) {
		PageInfo<MkContent> pageInfo = setPageInfo(pagination);
		Page<MkContent> page = getPage(pageInfo);
		List<MkContent> list = marketingMapper.selectMkContentList(mkContent);
		setPageInfo(pageInfo, page, list);
		return pageInfo;
	}

}
