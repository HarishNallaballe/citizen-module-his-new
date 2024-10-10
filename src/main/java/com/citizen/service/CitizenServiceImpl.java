package com.citizen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.citizen.constants.AppConstants;
import com.citizen.dto.ApplicationsDto;
import com.citizen.dto.CitizenDto;
import com.citizen.dto.SSARequest;
import com.citizen.entity.Citizen;
import com.citizen.entity.Plan;
import com.citizen.exception.ResourceNotFoundException;
import com.citizen.feign.PlanFeignClient;
import com.citizen.feign.SSAFeignClient;
import com.citizen.repo.CitizenRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CitizenServiceImpl implements CitizenService{

	@Autowired
	private CitizenRepository citizenRepo;
	
	@Autowired
	private SSAFeignClient ssaFeignClient;
	
	@Autowired
	private PlanFeignClient planFeignClient;
	
	
	  public String createApplication(CitizenDto dto,String correlationId) { 
		  Citizen citizen = new Citizen(); 
		  BeanUtils.copyProperties(dto, citizen); 
		  citizen.setAppNumber(appNumberGenerator()); 
		  SSARequest ssaRequest = new SSARequest(dto.getSsn());
		  String stateName = ssaFeignClient.getStateName(correlationId,ssaRequest).getBody().getStateName();
		  Integer planId = dto.getPlanId();
		  String status = planFeignClient.getPlanById(correlationId,planId).getBody().getStatus();
		  if(!(status.equalsIgnoreCase("active"))) {
			  return AppConstants.PLAN_INACTIVE;
		  }
	      if(stateName.equalsIgnoreCase("Rhode Island")) { 
		  citizenRepo.save(citizen);
		  return AppConstants.APPLICATION_CREATED; 
		  }
	  return AppConstants.APPLICATION_NOT_CREATED; 
	  }
	
	
	public String getStateName(String correlationId,SSARequest ssaRequest) {
		return ssaFeignClient.getStateName(correlationId,ssaRequest).getBody().getStateName();
	}
	
	private static Integer appNumberGenerator() {
		  // Generate 4 random numbers
		  Random random = new Random();
		  int randomNumber = 1000 + random.nextInt(9000);
		  System.out.println(randomNumber);
		  return randomNumber;
    }

	@CircuitBreaker(name = "myFeignClientCircuitBreaker", fallbackMethod = "fallbackGetSomeData")
	public List<ApplicationsDto> viewApplications(String correlationId) {
		List<Citizen> citizens = citizenRepo.findAll();
		List<ApplicationsDto> applications =new ArrayList<>();;
		citizens.stream().forEach(citizen->{
			ApplicationsDto applicationsDto = new ApplicationsDto();
			BeanUtils.copyProperties(citizen, applicationsDto);
			Integer planId = citizen.getPlanId();
			String planName = planFeignClient.getPlanById(correlationId,planId).getBody().getPlanName();
			applicationsDto.setPlanName(planName);
			applications.add(applicationsDto);
		});
		
		return applications;
	}


	@Override
	public ApplicationsDto viewApplication( Integer id,String correlationId) throws ResourceNotFoundException {
		Citizen citizen = citizenRepo.findById(id).orElseThrow(()->new  ResourceNotFoundException("Citizen Not Found : "+id));
		ApplicationsDto applicationsDto = new ApplicationsDto();
		BeanUtils.copyProperties(citizen, applicationsDto);
		Integer planId = citizen.getPlanId();
		String planName = planFeignClient.getPlanById(correlationId,planId).getBody().getPlanName();
		applicationsDto.setPlanName(planName);
		return applicationsDto;
	}


	@Override
	public Citizen getCitizenByAppNumber(Integer appNumber) throws ResourceNotFoundException {
		Citizen citizen = citizenRepo.findById(appNumber).orElseThrow(()->new  ResourceNotFoundException("Citizen Not Found : "+appNumber));
		return citizen;
	}
	
	

}
