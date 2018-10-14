package com.luchao.entity;

public class AffairModuleModuleOptions {
private Integer affairModuleModuleOptionsId;
private Integer affairModuleId;
private Integer moduleOptionsId;
private Integer order;
public Integer getAffairModuleModuleOptionsId() {
	return affairModuleModuleOptionsId;
}
public void setAffairModuleModuleOptionsId(Integer affairModuleModuleOptionsId) {
	this.affairModuleModuleOptionsId = affairModuleModuleOptionsId;
}
public Integer getAffairModuleId() {
	return affairModuleId;
}
public void setAffairModuleId(Integer affairModuleId) {
	this.affairModuleId = affairModuleId;
}
public Integer getModuleOptionsId() {
	return moduleOptionsId;
}
public AffairModuleModuleOptions() {
	super();
}
@Override
public String toString() {
	return "AffairModuleModuleOptions [affairModuleModuleOptionsId=" + affairModuleModuleOptionsId + ", affairModuleId="
			+ affairModuleId + ", moduleOptionsId=" + moduleOptionsId + ", order=" + order + ", moduleOptionsName="
			+ moduleOptionsName + ", moduleOptionsData=" + moduleOptionsData + "]";
}
public void setModuleOptionsId(Integer moduleOptionsId) {
	this.moduleOptionsId = moduleOptionsId;
}
public Integer getOrder() {
	return order;
}
public void setOrder(Integer order) {
	this.order = order;
}
public String getModuleOptionsName() {
	return moduleOptionsName;
}
public void setModuleOptionsName(String moduleOptionsName) {
	this.moduleOptionsName = moduleOptionsName;
}
public String getModuleOptionsData() {
	return moduleOptionsData;
}
public void setModuleOptionsData(String moduleOptionsData) {
	this.moduleOptionsData = moduleOptionsData;
}
private String moduleOptionsName;
private String moduleOptionsData;
}
