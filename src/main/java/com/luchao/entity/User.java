package com.luchao.entity;

import java.util.List;

public class User {
	private Integer userId;
	private String username;
	private String password;
	private String nickname;
	private Integer leaderId;
	private String avater;
	private User leader;
	private List<User> subordinates;
	
	private List<Operate> operates;
	
	public List<Operate> getOperates() {
		return operates;
	}
	public List<User> getSubordinates() {
		return subordinates;
	}
	public void setSubordinates(List<User> subordinates) {
		this.subordinates = subordinates;
	}
	public void setOperates(List<Operate> operates) {
		this.operates = operates;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
	
	

	private List<Menu> menus;
	
	public User getLeader() {
		return leader;
	}
	public void setLeader(User leader) {
		this.leader = leader;
	}
	public Integer getUserId() {
		return userId;
	}
	
	
	
	


	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", leaderId=" + leaderId + ", avater=" + avater + ", leader=" + leader + ", subordinates="
				+ subordinates + ", operates=" + operates + ", menus=" + menus + "]";
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
