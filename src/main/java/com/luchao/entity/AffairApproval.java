package com.luchao.entity;

public class AffairApproval {
private Integer affairApprovalId;
private Integer affairId;
private Integer affairApprovalOrder;
private Integer affairApprovalStatus;
private String affairApprovalComment;
private Integer affairApprovalUserId;
private User user;
public Integer getAffairApprovalId() {
	return affairApprovalId;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public void setAffairApprovalId(Integer affairApprovalId) {
	this.affairApprovalId = affairApprovalId;
}
@Override
public String toString() {
	return "AffairApproval [affairApprovalId=" + affairApprovalId + ", affairId=" + affairId + ", affairApprovalOrder="
			+ affairApprovalOrder + ", affairApprovalStatus=" + affairApprovalStatus + ", affairApprovalComment="
			+ affairApprovalComment + ", affairApprovalUserId=" + affairApprovalUserId + ", user=" + user + "]";
}
public Integer getAffairId() {
	return affairId;
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
