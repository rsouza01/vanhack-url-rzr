package com.rsouza01.urlrzr.services;

public interface UrlRzrService {
	
	String shortenUrl(String originalUrl);
	
	String getOriginalUrl(String shortenedUrl);
}
