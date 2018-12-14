package com.glsx.oms.bigdata.admin.ap.userLog.service;

import java.util.List;

import javax.annotation.Resource;

import org.oreframework.web.ui.Pagination;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.glsx.oms.bigdata.admin.ap.userLog.mapper.UserLogMapper;
import com.glsx.oms.bigdata.admin.ap.userLog.model.UserLog;

/**
 * @ClassName UserLogService
 * @Description TODO
 * @Author yangbin
 * @Date 2018/10/10 13:53
 * @Version 1.0
 */
@Service
public class UserLogService extends BaseService<UserLog> {

    @Resource
    UserLogMapper userLogMapper;

    public PageInfo<UserLog> getListByPage(UserLog userLog, Pagination pagination) {
        PageInfo<UserLog> pageInfo = setPageInfo(pagination);
        Page<UserLog> page = getPage(pageInfo);
        List<UserLog> list = userLogMapper.selectList(userLog);
        setPageInfo(pageInfo, page, list);
        return pageInfo;
    }
}
