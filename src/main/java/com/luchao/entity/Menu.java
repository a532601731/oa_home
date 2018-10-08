package com.luchao.entity;

public class Menu {

	private Integer menuId;
	private String menuName;
	public Integer getMenuId() {
		return menuId;
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", menuUrl=" + menuUrl + ", pid=" + pid + "]";
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Menu() {
		super();
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Menu(Integer menuId, String menuName, String menuUrl, Integer pid) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.pid = pid;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	private String menuUrl;
	private Integer pid;
}
