package com.glsx.oms.bigdata.admin.ap.marketing.mapper;

import java.util.List;

import org.oreframework.boot.annotation.PrimaryMapper;

import com.glsx.oms.bigdata.admin.ap.marketing.model.MkContent;
import com.glsx.oms.bigdata.admin.ap.marketing.model.MkInbox;

/**
 * 
 * @author chenxd
 *
 *         2018年10月15日 上午10:32:02
 */
@PrimaryMapper
public interface MarketingMapper {

	List<MkInbox> selectMkInboxList(MkInbox mkInbox);

	List<MkContent> selectMkContentList(MkContent mkContent);

}
