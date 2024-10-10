package com.citizen.feign;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.citizen.dto.SSARequest;
import com.citizen.dto.SSAResponse;

@Component
public class SSAFallBack implements SSAFeignClient{

	@Override
	public ResponseEntity<SSAResponse> getStateName(String correlationId, SSARequest request) {
		return null;
	}

}
