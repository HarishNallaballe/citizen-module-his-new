package com.citizen.feign;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.citizen.entity.Plan;

@Component
public class PlanFallBack implements PlanFeignClient{

	@Override
	public ResponseEntity<Plan> getPlanById(String correlationId, Integer id) {
		return null;
	}

}
