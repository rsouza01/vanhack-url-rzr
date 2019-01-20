package com.rsouza01.urlrzr.model;

import java.util.List;

public class Statistics {

	private long totalUrls;
	private List<DomainUsage> domainUsage;
	

	public long getTotalUrls() {
		return totalUrls;
	}

	public void setTotalUrls(long totalUrls) {
		this.totalUrls = totalUrls;
	}

	public List<DomainUsage> getDomainUsage() {
		return domainUsage;
	}

	public void setDomainUsage(List<DomainUsage> domainUsage) {
		this.domainUsage = domainUsage;
	}
}