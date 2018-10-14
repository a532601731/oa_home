package com.luchao.entity;

public class AffairModule {

	private Integer affairModuleId;
	private String affairModuleName;
	@Override
	public String toString() {
		return "AffairModule [affairModuleId=" + affairModuleId + ", affairModuleName=" + affairModuleName
				+ ", affairModuleUserId=" + affairModuleUserId + "]";
	}
	public Integer getAffairModuleId() {
		return affairModuleId;
	}
	public AffairModule() {
		super();
	}
	public void setAffairModuleId(Integer affairModuleId) {
		this.affairModuleId = affairModuleId;
	}
	public String getAffairModuleName() {
		return affairModuleName;
	}
	public void setAffairModuleName(String affairModuleName) {
		this.affairModuleName = affairModuleName;
	}
	public Integer getAffairModuleUserId() {
		return affairModuleUserId;
	}
	public void setAffairModuleUserId(Integer affairModuleUserId) {
		this.affairModuleUserId = affairModuleUserId;
	}
	private Integer affairModuleUserId;
}
