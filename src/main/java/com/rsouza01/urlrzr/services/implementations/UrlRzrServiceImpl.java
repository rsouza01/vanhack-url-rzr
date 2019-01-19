package com.rsouza01.urlrzr.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsouza01.urlrzr.model.UrlRzr;
import com.rsouza01.urlrzr.repository.UrlRzrRepository;
import com.rsouza01.urlrzr.services.UrlRzrService;


@Service
public class UrlRzrServiceImpl implements UrlRzrService {

	@Autowired
	private UrlRzrRepository urlRzrRepository;

	@Override
	public String shortenUrl(String originalUrl) {
		
		String shortenedUrl = originalUrl + "-url-shortened-rzr";
		
		UrlRzr urlRzr = new UrlRzr(shortenedUrl, originalUrl);  
		
		urlRzrRepository.save(urlRzr);
		
		return shortenedUrl;
	}

	@Override
	public String getOriginalUrl(String shortenedUrl) {
		
		return urlRzrRepository.findOne(shortenedUrl).getOriginalURL();
	}

}
