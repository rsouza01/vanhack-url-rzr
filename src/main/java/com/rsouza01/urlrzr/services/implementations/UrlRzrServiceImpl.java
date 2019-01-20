package com.rsouza01.urlrzr.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsouza01.urlrzr.exceptions.UrlNotFoundException;
import com.rsouza01.urlrzr.model.UrlRzr;
import com.rsouza01.urlrzr.repository.UrlRzrRepository;
import com.rsouza01.urlrzr.services.UrlRzrService;
import com.rsouza01.urlrzr.utils.UrlRzrUtils;


@Service
public class UrlRzrServiceImpl implements UrlRzrService {

	
	public static final int URL_SHORTENED_SIZE = 7;
	
	@Autowired
	private UrlRzrRepository urlRzrRepository;

	@Override
	public String shortenUrl(String originalUrl) {
		
		String shortenedUrl = UrlRzrUtils.url2MD5(originalUrl, UrlRzrServiceImpl.URL_SHORTENED_SIZE);

		UrlRzr urlRzrAlreadyTaken = urlRzrRepository.findOne(shortenedUrl);
		
		while(urlRzrAlreadyTaken != null)
		{
			/* MD5 and url match*/
			if(urlRzrAlreadyTaken.getOriginalURL().compareToIgnoreCase(originalUrl) == 0) {
				return urlRzrAlreadyTaken.getShortenedURL();
			} else {
				shortenedUrl = UrlRzrUtils.url2MD5(originalUrl, UrlRzrServiceImpl.URL_SHORTENED_SIZE);
				urlRzrAlreadyTaken = urlRzrRepository.findOne(shortenedUrl);
			}
		}
		
		UrlRzr urlRzr = new UrlRzr(shortenedUrl, originalUrl);  
		
		urlRzrRepository.save(urlRzr);
		
		return shortenedUrl;
	}

	@Override
	public String getOriginalUrl(String shortenedUrl) throws UrlNotFoundException {
		
		UrlRzr urlRzr = urlRzrRepository.findOne(shortenedUrl); 
		
		if(urlRzr == null) 
			throw new UrlNotFoundException();
		else 
			return urlRzr.getOriginalURL();
	}
}
