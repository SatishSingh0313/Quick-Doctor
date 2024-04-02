package com.service;

import java.util.List;

import com.entity.Marchant;



public interface MarchantService {
	
	Object SignUp(Marchant m);

	Object login(String email, String password);
	
	Object ForgotPassword(String email, String password);
	
	Object FindByMarchantname(String marchantName);
	
	Object FindByEmail(String emailId);

	List<Marchant> Findall();
}
