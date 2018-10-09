package com.luchao.entity;

public class Operate {

	private Integer operateId;
	private String operateName;
	private String operateAction;
	private String operateUrl;
	private Integer pid;
	public Integer getOperateId() {
		return operateId;
	}
	public void setOperateId(Integer operateId) {
		this.operateId = operateId;
	}
	public String getOperateName() {
		return operateName;
	}
	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}
	@Override
	public String toString() {
		return "Operate [operateId=" + operateId + ", operateName=" + operateName + ", operateAction=" + operateAction
				+ ", operateUrl=" + operateUrl + ", pid=" + pid + "]";
	}
	public Operate() {
		super();
	}
	public String getOperateAction() {
		return operateAction;
	}
	public Operate(Integer operateId, String operateName, String operateAction, String operateUrl, Integer pid) {
		super();
		this.operateId = operateId;
		this.operateName = operateName;
		this.operateAction = operateAction;
		this.operateUrl = operateUrl;
		this.pid = pid;
	}
	public void setOperateAction(String operateAction) {
		this.operateAction = operateAction;
	}
	public String getOperateUrl() {
		return operateUrl;
	}
	public void setOperateUrl(String operateUrl) {
		this.operateUrl = operateUrl;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
}
