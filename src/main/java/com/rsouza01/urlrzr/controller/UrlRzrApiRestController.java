package com.rsouza01.urlrzr.controller;


import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rsouza01.urlrzr.controller.dto.UrlRequest;
import com.rsouza01.urlrzr.exceptions.UrlNotFoundException;
import com.rsouza01.urlrzr.services.UrlRzrService;
import com.rsouza01.urlrzr.utils.UrlRzrUtils;

@RestController
public class UrlRzrApiRestController {
	
	@Autowired
	private UrlRzrService urlRzrService;
	
	
    @RequestMapping(value="/", method = RequestMethod.POST)
    public ResponseEntity<String> shortenUrl(HttpServletRequest httpRequest,
    		@RequestBody @Valid UrlRequest request,
    		BindingResult bindingResult) {
    	
        try {
			if (!UrlRzrUtils.isUrlValid(request.getUrl())) {
				return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
			}
			
			if (!bindingResult.hasErrors()) {
				
				String shortenedUrl = urlRzrService.shortenUrl(request.getUrl());
				
				return new ResponseEntity<String>(shortenedUrl, HttpStatus.OK);

			} else {
				return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @RequestMapping(value = "/{shortenedUrl}", method = RequestMethod.GET)
    public ResponseEntity<Void> redirectToUrl(@PathVariable String shortenedUrl, HttpServletResponse resp) throws Exception {
    	
        String url;

        try {
			url = urlRzrService.getOriginalUrl(shortenedUrl);
	    
			if(url != null) {
				HttpHeaders headers = new HttpHeaders();
		        headers.setLocation(URI.create(url));
		        
		        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
			} else {
		    	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
        } catch (UrlNotFoundException e) {
	    	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

		} catch (Exception e) {
	    	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
        
    }
}
