package com.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Schedule;
import com.entity.User;
import com.exception.DataNotFoundException;
import com.repo.ScheduleRepo;
import com.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired(required = true)
	ScheduleRepo screpo;
	
	@Override
	public Object addSchedule(Schedule sch) {
		
		return screpo.save(sch);
	}
	
	
	@Override
	public List<Schedule> FindAll() {
		return screpo.findAll();
	}
	

}
