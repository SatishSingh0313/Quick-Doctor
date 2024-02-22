package com.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.entity.Doctor;
import com.exception.DataNotFoundException;
import com.exception.DoctorDataAlreadyExists;
import com.exception.EmailAlreadyExists;
import com.exception.PasswordInvalid;
import com.exception.PhoneNumberAlreadyExists;
import com.exception.EmailNotFound;
import com.repo.DoctorRepo;
import com.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired(required = true)
	DoctorRepo repo;

	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

	@Override
	public Object SignUp(Doctor d) {
		Doctor d1 = repo.findByEmail(d.getD_e_mail());
		Doctor d2 = repo.findByphNo(d.getD_ph_no());

		String pass = bcrypt.encode(d.getD_password());
		d.setD_password(pass);
		if (d1 instanceof Doctor || d2 instanceof Doctor) {
			if (d1 != null) {
				try {
					throw new EmailAlreadyExists();
				} catch (EmailAlreadyExists e) {
					return e.getMessage();
				}
			} else {
				try {
					throw new PhoneNumberAlreadyExists();
				} catch (PhoneNumberAlreadyExists p) {
					return p.getMessage();
				}
			}
		}
		return repo.save(d);

	}

	@Override
	public Object login(String email, String password) {
		Doctor d3 = repo.findByEmail(email);

		if (d3 instanceof Doctor && d3.getD_e_mail().equalsIgnoreCase(email)) {
			if (bcrypt.matches(password, d3.getD_password())) {
				return d3;
			} else {
				try {
					throw new PasswordInvalid();
				} catch (PasswordInvalid p) {
					return p.getMessage();
				}
			}
		} else {
			try {
				throw new EmailNotFound();
			} catch (EmailNotFound e) {
				return e.getMessage();
			}
		}

	}

	@Override
	public List<Doctor> Findall() {

		return repo.findAll();
	}

	@Override
	public Object ForgotPassword(String email, String password) {
		Doctor d4 = repo.findByEmail(email);
		if (d4 instanceof Doctor && d4.getD_e_mail().equalsIgnoreCase(email)) {
			String pass = bcrypt.encode(password);
			d4.setD_password(pass);
			return repo.save(d4);
		} else {
			try {
				throw new EmailNotFound();
			} catch (Exception e) {
				return e.getMessage();
			}
		}

	}

	@Override
	public Object FindByDoctorname(String doctorName) {
		Doctor d5 = repo.FindByDoctorname(doctorName);
		if (d5 instanceof Doctor) {
			return d5;
		} else {
			try {
				throw new DataNotFoundException();
			} catch (DataNotFoundException d) {
				return d.getMessage();
			}
		}
	}

	@Override
	public Object FindByEmail(String emailId) {
		Doctor d6 = repo.findByEmail(emailId);
		if (d6 instanceof Doctor) {
			return d6;
		} else {
			try {
				throw new EmailNotFound();
			} catch (EmailNotFound e) {
				return e.getMessage();
			}
		}
	}

}