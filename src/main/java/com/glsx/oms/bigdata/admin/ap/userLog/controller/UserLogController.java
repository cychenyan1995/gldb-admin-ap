package com.glsx.oms.bigdata.admin.ap.userLog.controller;

import javax.annotation.Resource;

import org.oreframework.web.ui.Pagination;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.glsx.oms.bigdata.admin.ap.userLog.model.UserLog;
import com.glsx.oms.bigdata.admin.ap.userLog.service.UserLogService;
import com.glsx.oms.bigdata.admin.ap.vo.RespMessage;

/**
 * @ClassName UserLogController
 * @Description TODO
 * @Author yangbin
 * @Date 2018/10/10 13:59
 * @Version 1.0
 */
@RestController
@RequestMapping("/userLog")
public class UserLogController {

    @Resource
    UserLogService userLogService;

    @GetMapping("/list")
    public RespMessage list(UserLog userLog, Pagination pagination) {
        RespMessage rm = new RespMessage();
        PageInfo<UserLog> page = userLogService.getListByPage(userLog, pagination);
        rm.setData(page.getList());
        rm.setPageTotal(page.getTotal());
        return rm;
    }
}
