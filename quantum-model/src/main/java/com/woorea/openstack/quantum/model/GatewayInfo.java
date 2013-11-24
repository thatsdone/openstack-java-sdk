package com.woorea.openstack.quantum.model;

import java.util.List;
import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class GatewayInfo implements Serializable {

	@JsonProperty("network_id")
	private String networkId;

	@JsonProperty("enable_snat")
	private boolean enableSnat;

	public String getNetworkId() {
		return networkId;
	}

	public void setNetworkId(String id) {
		this.networkId = id;
	}

	public boolean getEnableSnat() {
		return enableSnat;
	}

	public void setEnableSnat(boolean enableSnat) {
		this.enableSnat = enableSnat;
	}

	@Override public String toString() {
		return "[networkId=" + networkId + ", enableSnat=" + enableSnat + "]";
	}
}
