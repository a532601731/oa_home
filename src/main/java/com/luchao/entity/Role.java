package com.luchao.entity;

import java.util.List;

public class Role {

	private Integer roleId;
	private String roleName;
	private Integer departmentId;
	
	List<Permission> permissions;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", departmentId=" + departmentId + ", permissions="
				+ permissions + "]";
	}
	public String getRoleName() {
		return roleName;
	}
	public Role() {
		super();
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	
}
