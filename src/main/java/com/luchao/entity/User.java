package com.luchao.entity;

import java.util.List;

public class User {
	private Integer userId;
	private String username;
	private String password;
	private String nickname;
	private Integer leaderId;
	private String avater;
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	private List<Menu> menus;
	
	public Integer getUserId() {
		return userId;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", leaderId=" + leaderId + ", avater=" + avater + ", menus=" + menus + "]";
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public User(Integer userId, String username, String password, String nickname, Integer leaderId, String avater) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.leaderId = leaderId;
		this.avater = avater;
	}
	public User() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(Integer leaderId) {
		this.leaderId = leaderId;
	}
	public String getAvater() {
		return avater;
	}
	public void setAvater(String avater) {
		this.avater = avater;
	}
	
	
}
