package com.rsouza01.urlrzr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.rsouza01.urlrzr.services.UrlRzrService;

@RestController
public class UrlRzrApiRestController {
	
	@Autowired
	private UrlRzrService eventService;
	

}
