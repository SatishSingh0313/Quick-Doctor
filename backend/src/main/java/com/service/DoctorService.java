package com.service;

import java.util.List;

import com.entity.Doctor;

public interface DoctorService {

	Object SignUp(Doctor d);

	Object login(String email, String password);
	
	Object ForgotPassword(String email, String password);
	
	Object FindByDoctorname(String doctorName);
	
	Object FindByEmail(String emailId);

	List<Doctor> Findall();

}
