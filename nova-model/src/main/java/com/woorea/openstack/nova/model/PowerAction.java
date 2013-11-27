package com.woorea.openstack.nova.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

public class PowerAction implements Serializable {

	private String host;
	
	@JsonProperty("power_action")
	private String powerAction;
	

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @return the powerAction
	 */
	public String getPowerAction() {
		return powerAction;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[host=" + host + ", powerAction=" + powerAction + "]";
	}

}
