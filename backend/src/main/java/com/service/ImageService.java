package com.service;

import org.springframework.web.multipart.MultipartFile;

import com.entity.Image;

public interface ImageService 
{
	Image addimage(MultipartFile file);

}