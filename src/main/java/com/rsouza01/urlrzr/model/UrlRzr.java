package com.rsouza01.urlrzr.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UrlRzr extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7414344696564671152L;

	@Id
	private String shortenedURL;

	private String originalURL;
	
	public UrlRzr() {
	}

	public UrlRzr(String shortenedURL, String originalURL) {
		this.originalURL = originalURL;
		this.shortenedURL = shortenedURL;
	}

	public String getOriginalURL() {
		return originalURL;
	}

	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}

	public String getShortenedURL() {
		return shortenedURL;
	}

	public void setShortenedURL(String shortenedURL) {
		this.shortenedURL = shortenedURL;
	}
}