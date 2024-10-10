package com.citizen.dto;

public class SSARequest {
	
	private Integer ssn;

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public SSARequest(Integer ssn) {
		super();
		this.ssn = ssn;
	}

	public SSARequest() {
		super();
	}

	@Override
	public String toString() {
		return "SSARequest [ssn=" + ssn + "]";
	}
}
