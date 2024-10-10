package com.citizen.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.citizen.entity.Plan;

@FeignClient(name="PLANS-MODULE" , fallback = PlanFallBack.class)
public interface PlanFeignClient {

	@GetMapping("/plan/{id}")
	public ResponseEntity<Plan> getPlanById(@RequestHeader("his-correlation-id")String correlationId,@PathVariable Integer id);
	
}
