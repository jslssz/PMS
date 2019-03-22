package com.briup.party.bean.count;

public class BranchCount {
	private String name;
	private Short storageNumber;
	private Short prepareNumber;
	private Short femaleNumber;
	private Short minorityNumber;
	/**
	 * 大专及以上学历人员个数。
	 */
	private Short collegeNumber;

	public BranchCount(){}
	public BranchCount(String name, Short storageNumber, Short prepareNumber, Short femaleNumber,
					   Short minorityNumber, Short collegeNumber) {
		super();
		this.name = name;
		this.storageNumber = storageNumber;
		this.prepareNumber = prepareNumber;
		this.femaleNumber = femaleNumber;
		this.minorityNumber = minorityNumber;
		this.collegeNumber = collegeNumber;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Short getStorageNumber() {
		return storageNumber;
	}
	public void setStorageNumber(Short storageNumber) {
		this.storageNumber = storageNumber;
	}
	public Short getPrepareNumber() {
		return prepareNumber;
	}
	public void setPrepareNumber(Short prepareNumber) {
		this.prepareNumber = prepareNumber;
	}
	public Short getFemaleNumber() {
		return femaleNumber;
	}
	public void setFemaleNumber(Short femaleNumber) {
		this.femaleNumber = femaleNumber;
	}
	public Short getMinorityNumber() {
		return minorityNumber;
	}
	public void setMinorityNumber(Short minorityNumber) {
		this.minorityNumber = minorityNumber;
	}
	public Short getCollegeNumber() {
		return collegeNumber;
	}
	public void setCollegeNumber(Short collegeNumber) {
		this.collegeNumber = collegeNumber;
	}
	
}
