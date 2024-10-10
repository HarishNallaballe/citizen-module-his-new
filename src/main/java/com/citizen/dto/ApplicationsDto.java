package com.citizen.dto;


public class ApplicationsDto {
	
	private Integer appNumber;
	private String fullName;
	private Integer ssn;
	private String planName;
	
	public Integer getAppNumber() {
		return appNumber;
	}
	public void setAppNumber(Integer appNumber) {
		this.appNumber = appNumber;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Integer getSsn() {
		return ssn;
	}
	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
}
