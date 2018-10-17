package com.luchao.entity;

public class Affair {

	private Integer affairId;
	private Integer affairModuleId;
	private String affairData;
	private Integer affairUserId;
	private Integer affairStatus;
	
	private AffairModule affairModule;
	private User user;
	
	public AffairModule getAffairModule() {
		return affairModule;
	}

	public void setAffairModule(AffairModule affairModule) {
		this.affairModule = affairModule;
	}

	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "Affair [affairId=" + affairId + ", affairModuleId=" + affairModuleId + ", affairData=" + affairData
				+ ", affairUserId=" + affairUserId + ", affairStatus=" + affairStatus + ", affairModule=" + affairModule
				+ ", user=" + user + "]";
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getAffairId() {
		return affairId;
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
