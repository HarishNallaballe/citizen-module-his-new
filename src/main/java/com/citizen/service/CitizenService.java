package com.citizen.service;

import java.util.List;

import com.citizen.dto.ApplicationsDto;
import com.citizen.dto.CitizenDto;
import com.citizen.dto.SSARequest;
import com.citizen.entity.Citizen;
import com.citizen.exception.ResourceNotFoundException;

public interface CitizenService {

	public String createApplication(CitizenDto dto,String correlationId);
	
	public String getStateName(String correlationid,SSARequest ssaRequest);
	
	public List<ApplicationsDto> viewApplications(String correlationId);
	
	public ApplicationsDto viewApplication(Integer id,String correlationId) throws ResourceNotFoundException;
	
	public Citizen getCitizenByAppNumber(Integer appNumber) throws ResourceNotFoundException;
}
