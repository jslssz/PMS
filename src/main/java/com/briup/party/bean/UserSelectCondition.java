package com.briup.party.bean;

/**
 * 封装查询用户条件的pojo类
 */
public class UserSelectCondition {
	private Short branch_id;
	private String name;
	private String idcard;
	private String category;
	private String partystate;
	private Boolean isLost;
	public Short getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(Short branch_id) {
		this.branch_id = branch_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPartystate() {
		return partystate;
	}
	public void setPartystate(String partystate) {
		this.partystate = partystate;
	}
	public Boolean getIsLost() {
		return isLost;
	}
	public void setIsLost(Boolean isLost) {
		this.isLost = isLost;
	}
}
