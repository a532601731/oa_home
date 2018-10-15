package com.luchao.entity;

public class ModuleApproval {
private Integer approvalId;
private Integer affairModuleId;
private Integer approvalOrder;
public Integer getApprovalId() {
	return approvalId;
}
public Integer getAffairModuleId() {
	return affairModuleId;
}
public void setAffairModuleId(Integer affairModuleId) {
	this.affairModuleId = affairModuleId;
}
public void setApprovalId(Integer approvalId) {
	this.approvalId = approvalId;
}


@Override
public String toString() {
	return "ModuleApproval [approvalId=" + approvalId + ", affairModuleId=" + affairModuleId + ", approvalOrder="
			+ approvalOrder + ", approvalUserId=" + approvalUserId + ", approvalStatus=" + approvalStatus + "]";
}
public Integer getApprovalOrder() {
	return approvalOrder;
}
public ModuleApproval() {
	super();
}
public void setApprovalOrder(Integer approvalOrder) {
	this.approvalOrder = approvalOrder;
}
public Integer getApprovalUserId() {
	return approvalUserId;
}
public void setApprovalUserId(Integer approvalUserId) {
	this.approvalUserId = approvalUserId;
}
public Integer getApprovalStatus() {
	return approvalStatus;
}
public void setApprovalStatus(Integer approvalStatus) {
	this.approvalStatus = approvalStatus;
}
private Integer approvalUserId;
private Integer approvalStatus;
}
