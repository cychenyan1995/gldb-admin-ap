package com.glsx.oms.bigdata.admin.ap.monitor.model;

public class MonitorSpot {
	//标示id
	private Integer id;
	//监测点id
	private Integer keyId;
	//监测点描述 
	private String des;
	//监测点备注
	private String remark;
	//服务器id
	private int appId;
	//对应C++头文件宏标示
	private String cMarco;
	//创建时间
    private String createTime;
    //修改时间
    private String updateTime;
	//检测点类型0:频次检测  1:发生错误检测
    private int type;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getKeyId() {
		return keyId;
	}
	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getcMarco() {
		return cMarco;
	}
	public void setcMarco(String cMarco) {
		this.cMarco = cMarco;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
    
    

}
