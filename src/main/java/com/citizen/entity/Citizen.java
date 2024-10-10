package com.citizen.entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="citizens")
public class Citizen {
	
	@Id
	private Integer appNumber;
	private String fullName;
	private Date dob;
	private String gender;
	private Integer ssn;
	private Integer planId;
	private Integer userId;
	@CreationTimestamp
	private Date createdDate;
	@UpdateTimestamp
	private Date updatedDate;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getSsn() {
		return ssn;
	}
	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Citizen(String fullName, Date dob, String gender, Integer ssn, Integer planId, Integer userId,
			Date createdDate, Date updatedDate) {
		super();
		this.fullName = fullName;
		this.dob = dob;
		this.gender = gender;
		this.ssn = ssn;
		this.planId = planId;
		this.userId = userId;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	public Citizen() {
		super();
	}
	@Override
	public String toString() {
		return "Citizen [appNumber=" + appNumber + ", fullName=" + fullName + ", dob=" + dob + ", gender=" + gender
				+ ", ssn=" + ssn + ", planId=" + planId + ", userId=" + userId + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

}
