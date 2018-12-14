package com.glsx.oms.bigdata.admin.ap.chartAnalysis.model;


public class MkInboxAnalysis {

	// d_mk_msg_inbox
	private Integer id; // 自增ID
	private Integer appMsgId; // 营销ID
	private Integer sender; // 发送ID
	private Integer receiver; // 接收者ID
	private Integer status; // 0 未推送 1 已推送 2 过期
	private String receiverTime; // 推送时间
	private String createTime;
	private String updateTime;
	private String batchNumber; // 批次号
	private String beginTime;//开始时间
	private String endTime;//结束时间
	private Integer number; //总数
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAppMsgId() {
		return appMsgId;
	}
	public void setAppMsgId(Integer appMsgId) {
		this.appMsgId = appMsgId;
	}
	public Integer getSender() {
		return sender;
	}
	public void setSender(Integer sender) {
		this.sender = sender;
	}
	public Integer getReceiver() {
		return receiver;
	}
	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getReceiverTime() {
		return receiverTime;
	}
	public void setReceiverTime(String receiverTime) {
		this.receiverTime = receiverTime;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
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
