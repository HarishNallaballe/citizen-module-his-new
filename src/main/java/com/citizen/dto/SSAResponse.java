package com.citizen.dto;

public class SSAResponse {
	
	private Integer ssn;
	
	private String stateName;

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public SSAResponse(Integer ssn, String stateName) {
		super();
		this.ssn = ssn;
		this.stateName = stateName;
	}

	public SSAResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SSAResponse [ssn=" + ssn + ", stateName=" + stateName + "]";
	}
}
