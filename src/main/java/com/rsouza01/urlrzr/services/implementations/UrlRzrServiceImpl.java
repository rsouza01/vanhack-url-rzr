package com.rsouza01.urlrzr.services.implementations;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsouza01.urlrzr.exceptions.UrlNotFoundException;
import com.rsouza01.urlrzr.model.DomainUsage;
import com.rsouza01.urlrzr.model.Statistics;
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

	@Override
	public Statistics getStatistics() {
		
		Statistics statistics = new Statistics();
		
		
		Map<String, DomainUsage> hash = new HashMap<String, DomainUsage>();


		Iterable<UrlRzr> links = urlRzrRepository.findAll();
		
		for(UrlRzr url: links) {
			
			try {
				URI uri = new URI(url.getOriginalURL());

				DomainUsage domainUsage = hash.get(uri.getHost());
				
				if(domainUsage == null) {
					hash.put(uri.getHost(), new DomainUsage(uri.getHost(), 1));
				} else {
					domainUsage.setCount(domainUsage.getCount()+1);
				}

			} catch (URISyntaxException e) {
			}
		}
		
		statistics.setTotalUrls(urlRzrRepository.count());
		statistics.setDomainUsage(new ArrayList<DomainUsage>(hash.values()));
		
		return statistics;
	}
}
