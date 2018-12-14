package com.glsx.oms.bigdata.admin.ap.userLog.service;

import java.util.List;

import org.oreframework.web.ui.Pagination;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 公共服务实现抽象类
 *
 * @Author yangbin
 * @Date 11:40 2018/7/31
 * @Version 1.0
 */
public abstract class BaseService<T> {

    private static int pageSize = 10;

    protected PageInfo<T> setPageInfo(Pagination pagination) {
        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setPageNum(pagination.getCurrentPage());
        pageInfo.setPageSize(pagination.getPageSize() == 0 ? pageSize : pagination.getPageSize());
        return pageInfo;
    }

    protected Page<T> getPage(PageInfo<T> pageInfo) {
        return PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
    }

    protected void setPageInfo(PageInfo<T> pageInfo, Page<T> page, List<T> list) {
        long count = page.getTotal();
        pageInfo.setList(list);
        pageInfo.setTotal(count);
    }
}