package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Schedule;

public interface ScheduleRepo extends JpaRepository<Schedule, Integer> 
{
	

}
