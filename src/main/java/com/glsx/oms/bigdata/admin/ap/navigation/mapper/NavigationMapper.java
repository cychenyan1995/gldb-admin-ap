package com.glsx.oms.bigdata.admin.ap.navigation.mapper;

import java.util.List;

import org.oreframework.boot.annotation.PrimaryMapper;

import com.glsx.oms.bigdata.admin.ap.navigation.model.NavAddInfo;
import com.glsx.oms.bigdata.admin.ap.navigation.model.NavRequInfo;

@PrimaryMapper
public interface NavigationMapper {

	List<NavAddInfo> selectNavAddList(NavAddInfo navAddInfo);

	List<NavRequInfo> selectNavRequList(NavRequInfo navRequInfo);

}
