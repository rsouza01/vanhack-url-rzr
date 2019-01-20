package com.rsouza01.urlrzr.model;

public class DomainUsage {

	private String domain;
	private int count;

	public DomainUsage(String domain, int count) {
		super();
		this.domain = domain;
		this.count = count;
	}

	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}