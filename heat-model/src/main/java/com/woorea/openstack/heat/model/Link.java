package com.woorea.openstack.heat.model;

import java.io.Serializable;

public class Link implements Serializable {

	private String rel;

	private String href;

	/**
	 * return the rel
	 */
	public String getRel() {
		return rel;
	}
	/**
	 * return the href
	 */
	public String getHref() {
		return href;
	}

	@Override
	public String toString() {
		return "link [href=" + href + ", rel=" + rel + "]";
	}
}
