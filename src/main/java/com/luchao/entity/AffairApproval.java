package com.luchao.entity;

public class AffairApproval {
private Integer affairApprovalId;
private Integer affairId;
private Integer affairApprovalOrder;
private Integer affairApprovalStatus;
private String affairApprovalComment;
private Integer affairApprovalUserId;
public Integer getAffairApprovalId() {
	return affairApprovalId;
}
public void setAffairApprovalId(Integer affairApprovalId) {
	this.affairApprovalId = affairApprovalId;
}
public Integer getAffairId() {
	return affairId;
}
@Override
public String toString() {
	return "AffairApproval [affairApprovalId=" + affairApprovalId + ", affairId=" + affairId + ", affairApprovalOrder="
			+ affairApprovalOrder + ", affairApprovalStatus=" + affairApprovalStatus + ", affairApprovalComment="
			+ affairApprovalComment + ", affairApprovalUserId=" + affairApprovalUserId + "]";
}
public AffairApproval() {
	super();
}
public void setAffairId(Integer affairId) {
	this.affairId = affairId;
}
public Integer getAffairApprovalOrder() {
	return affairApprovalOrder;
}
public void setAffairApprovalOrder(Integer affairApprovalOrder) {
	this.affairApprovalOrder = affairApprovalOrder;
}
public Integer getAffairApprovalStatus() {
	return affairApprovalStatus;
}
public void setAffairApprovalStatus(Integer affairApprovalStatus) {
	this.affairApprovalStatus = affairApprovalStatus;
}
public String getAffairApprovalComment() {
	return affairApprovalComment;
}
public void setAffairApprovalComment(String affairApprovalComment) {
	this.affairApprovalComment = affairApprovalComment;
}
public Integer getAffairApprovalUserId() {
	return affairApprovalUserId;
}
public void setAffairApprovalUserId(Integer affairApprovalUserId) {
	this.affairApprovalUserId = affairApprovalUserId;
}
}
