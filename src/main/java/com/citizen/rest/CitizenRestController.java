package com.citizen.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.citizen.dto.ApplicationsDto;
import com.citizen.dto.CitizenDto;
import com.citizen.dto.SSARequest;
import com.citizen.entity.Citizen;
import com.citizen.exception.ResourceNotFoundException;
import com.citizen.service.CitizenService;

@RestController
public class CitizenRestController {
	
	@Autowired
	private CitizenService citizenService;
	
	private Logger logger=LoggerFactory.getLogger(CitizenRestController.class);
	
	@PostMapping("/create")
	public ResponseEntity<String> createApplication(@RequestHeader("his-correlation-id") String correlationId, @RequestBody CitizenDto citizenDto){ 
		logger.info("his correlation id : "+correlationId);
		String application = citizenService.createApplication(citizenDto,correlationId);
	return new ResponseEntity<String>(application,HttpStatus.OK); }
	 
	
	@PostMapping("/stateName")
	public ResponseEntity<String> getStateName(@RequestHeader("his-correlation-id") String correlationId,@RequestBody SSARequest ssaRequest){
		logger.info("his correlation id : "+correlationId);
		String stateName = citizenService.getStateName(correlationId,ssaRequest);
		return new ResponseEntity<String>(stateName,HttpStatus.OK);
	}
	
	@GetMapping("/view")
	public ResponseEntity<List<ApplicationsDto>> viewApplications(@RequestHeader("his-correlation-id") String correlationId){
		logger.info("his correlation id : "+correlationId);
		List<ApplicationsDto> viewApplications = citizenService.viewApplications(correlationId);
		return new ResponseEntity<List<ApplicationsDto>>(viewApplications,HttpStatus.OK);
	}
	
	@GetMapping("/application/{id}")
	public ResponseEntity<ApplicationsDto> viewApplication(@RequestHeader("his-correlation-id") String correlationId,@PathVariable Integer id) throws ResourceNotFoundException{
		logger.info("his correlation id : "+correlationId);
		ApplicationsDto application = citizenService.viewApplication(id,correlationId);
		return new ResponseEntity<ApplicationsDto>(application,HttpStatus.OK);
	}
	
	@GetMapping("/citizen/{appNumber}")
	public ResponseEntity<Citizen> getCitizenByAppNumber(@RequestHeader("his-correlation-id") String correlationId,@PathVariable Integer appNumber) throws ResourceNotFoundException{
		logger.info("his correlation id : "+correlationId);
		Citizen citizen = citizenService.getCitizenByAppNumber(appNumber);
		return new ResponseEntity<Citizen>(citizen,HttpStatus.OK);
	}
	
	
}
