package com.service;

import java.util.List;

import com.entity.Schedule;

public interface ScheduleService {
	
	Object addSchedule (Schedule sch);
	
	List<Schedule> FindAll();


}
