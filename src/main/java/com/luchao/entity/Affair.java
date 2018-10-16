package com.luchao.entity;

public class Affair {

	private Integer affairId;
	private Integer affairModuleId;
	private String affairData;
	private Integer affairUserId;
	private Integer affairStatus;
	public Integer getAffairId() {
		return affairId;
	}
	@Override
	public String toString() {
		return "Affair [affairId=" + affairId + ", affairModuleId=" + affairModuleId + ", affairData=" + affairData
				+ ", affairUserId=" + affairUserId + ", affairStatus=" + affairStatus + "]";
	}
	public void setAffairId(Integer affairId) {
		this.affairId = affairId;
	}
	public Integer getAffairModuleId() {
		return affairModuleId;
	}
	public Affair() {
		super();
	}
	public void setAffairModuleId(Integer affairModuleId) {
		this.affairModuleId = affairModuleId;
	}
	public String getAffairData() {
		return affairData;
	}
	public void setAffairData(String affairData) {
		this.affairData = affairData;
	}
	public Integer getAffairUserId() {
		return affairUserId;
	}
	public void setAffairUserId(Integer affairUserId) {
		this.affairUserId = affairUserId;
	}
	public Integer getAffairStatus() {
		return affairStatus;
	}
	public void setAffairStatus(Integer affairStatus) {
		this.affairStatus = affairStatus;
	}
}
