package com.glsx.oms.bigdata.admin.ap.userLog.mapper;

import java.util.List;

import org.oreframework.boot.annotation.PrimaryMapper;

import com.glsx.oms.bigdata.admin.ap.userLog.model.UserLog;


@PrimaryMapper
public interface UserLogMapper {
    List<UserLog> selectList(UserLog userLog);
}