package com.glsx.oms.bigdata.admin.ap.marketing.service;

import java.util.List;

import javax.annotation.Resource;

import org.oreframework.web.ui.Pagination;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.glsx.oms.bigdata.admin.ap.marketing.mapper.MarketingMapper;
import com.glsx.oms.bigdata.admin.ap.marketing.model.MkInbox;
import com.glsx.oms.bigdata.admin.ap.userLog.service.BaseService;

@Service
public class MkInboxService extends BaseService<MkInbox> {

	@Resource
	MarketingMapper marketingMapper;

	public PageInfo<MkInbox> getMkInboxListByPage(MkInbox mkInbox, Pagination pagination) {
		PageInfo<MkInbox> pageInfo = setPageInfo(pagination);
		Page<MkInbox> page = getPage(pageInfo);
		List<MkInbox> list = marketingMapper.selectMkInboxList(mkInbox);
		setPageInfo(pageInfo, page, list);
		return pageInfo;
	}

}
