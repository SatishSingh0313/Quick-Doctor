package com.serviceImp;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Image;
import com.entity.ImageUtility;
import com.repo.ImageRepo;
import com.service.ImageService;


@Service
public class ImageServiceImplementation implements  ImageService{

	@Autowired
	ImageRepo imrepo;
	
	@Override
	public Image addimage(MultipartFile image) 
	{
		Image I = new Image();
		String filename = StringUtils.cleanPath(image.getOriginalFilename());
		if (filename.contains("..")) {
			System.out.println("Not a valid file");
		}
		try {
			I.setImage(ImageUtility.compressImage(image.getBytes()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imrepo.save(I);
	}
 
}