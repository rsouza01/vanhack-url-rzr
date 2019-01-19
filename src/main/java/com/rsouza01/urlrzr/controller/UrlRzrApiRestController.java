package com.rsouza01.urlrzr.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rsouza01.urlrzr.controller.dto.UrlRequest;
import com.rsouza01.urlrzr.services.UrlRzrService;

@RestController
public class UrlRzrApiRestController {
	
	@Autowired
	private UrlRzrService urlRzrService;
	
	
    @RequestMapping(value="/", method = RequestMethod.POST)
    public ResponseEntity<String> shortenUrl(HttpServletRequest httpRequest,
    		@RequestBody @Valid UrlRequest request,
    		BindingResult bindingResult) {
    	
    	String shortenedUrl = urlRzrService.shortenUrl(request.getUrl());
	
    	return new ResponseEntity<String>(shortenedUrl, HttpStatus.OK);
    }
    
}
