package com.glsx.oms.bigdata.admin.ap.marketing.controller;

import javax.annotation.Resource;

import org.oreframework.web.ui.Pagination;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.glsx.oms.bigdata.admin.ap.marketing.model.MkContent;
import com.glsx.oms.bigdata.admin.ap.marketing.model.MkInbox;
import com.glsx.oms.bigdata.admin.ap.marketing.service.MkContentService;
import com.glsx.oms.bigdata.admin.ap.marketing.service.MkInboxService;
import com.glsx.oms.bigdata.admin.ap.vo.RespMessage;

@RestController
@RequestMapping("/marketing")
public class MarketingController {
	@Resource
	MkContentService mkContentService;
	@Resource
	MkInboxService mkInboxService;

	@GetMapping("/getMkContentListByPage")
	public RespMessage getMkContentListByPage(MkContent mkContent, Pagination pagination) {
		RespMessage rm = new RespMessage();
		PageInfo<MkContent> page = mkContentService.getMkContentListByPage(mkContent, pagination);
		rm.setData(page.getList());
		rm.setPageTotal(page.getTotal());
		return rm;
	}

	@GetMapping("/getMkInboxListByPage")
	public RespMessage getMkInboxListByPage(MkInbox mkInbox, Pagination pagination) {
		RespMessage rm = new RespMessage();
		PageInfo<MkInbox> page = mkInboxService.getMkInboxListByPage(mkInbox, pagination);
		rm.setData(page.getList());
		rm.setPageTotal(page.getTotal());
		return rm;
	}

}
