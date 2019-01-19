package com.rsouza01.urlrzr.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsouza01.urlrzr.repository.UrlRzrRepository;


@Service
public class UrlRzrServiceImpl {

	@Autowired
	private UrlRzrRepository urlRzrRepository;

}
