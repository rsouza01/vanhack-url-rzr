package com.rsouza01.urlrzr.services;

import com.rsouza01.urlrzr.exceptions.UrlNotFoundException;

public interface UrlRzrService {
	
	String shortenUrl(String originalUrl);
	
	String getOriginalUrl(String shortenedUrl) throws UrlNotFoundException;
}
