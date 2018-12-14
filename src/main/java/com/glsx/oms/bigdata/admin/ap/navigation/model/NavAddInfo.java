package com.glsx.oms.bigdata.admin.ap.navigation.model;

import java.util.Date;

import lombok.Data;

/**
 * 一键导航推达地址信息表 实例
 * 
 * @author chenxd
 *
 *         2018年10月10日 下午6:31:16
 */
@Data
public class NavAddInfo {

	// d_onekeynavigate_rsp
	private Integer id; // 自增ID
	private Integer userId; // 原嘀嘀号
	private Integer msgId; // 消息ID
	private String longItude; // 目的地经度
	private String latItude; // 目的地纬度
	private String title; // 搜索关键字
	private String address; // 目的地地址
	private Integer feedBack; // 推送结果
	private Date createTime;
	private Date updateTime;

}
