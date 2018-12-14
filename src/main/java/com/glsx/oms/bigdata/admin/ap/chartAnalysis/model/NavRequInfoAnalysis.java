package com.glsx.oms.bigdata.admin.ap.chartAnalysis.model;

import java.util.Date;

import lombok.Data;

@Data
public class NavRequInfoAnalysis {

	// d_onekeynavigate_req
	private Integer id; // 自增ID
	private Integer userId; // 原嘀嘀号
	private String imsi;
	private Date time; // 请求时时间
	private Integer status; // 请求状态
	private Integer number;  //总数
	private String beginTime;//开始时间
	private String endTime;//结束时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	

}
