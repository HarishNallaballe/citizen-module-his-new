package com.citizen.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citizen.entity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Integer>{
	

}
