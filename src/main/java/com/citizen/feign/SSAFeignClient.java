package com.citizen.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.citizen.dto.SSARequest;
import com.citizen.dto.SSAResponse;


@FeignClient(name="SSA",fallback = SSAFallBack.class)
public interface SSAFeignClient {
	
	@GetMapping("/state")
	public ResponseEntity<SSAResponse> getStateName(@RequestHeader("his-correlation-id")String correlationId, @RequestBody SSARequest request);


}
