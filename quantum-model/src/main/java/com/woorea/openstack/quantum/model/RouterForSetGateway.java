package com.woorea.openstack.quantum.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("router")
public class RouterForSetGateway implements Serializable {

	@JsonProperty("external_gateway_info")
	GatewayInfo externalGatewayInfo;

	/**
	 * getExternalGatewayInfo : getter
	 */
	public GatewayInfo getExternalGatewayInfo() {
		return externalGatewayInfo;
	}

	/**
	 * setExternalGatewayInfo : setter
	 * @param gatewayInfo to set
	 */
	public void setExternalGatewayInfo(GatewayInfo gatewayInfo) {
		this.externalGatewayInfo = gatewayInfo;
	}

	@Override public String toString() {
		return "RouterForSetGateway [externalGatewayInfo=" +
			externalGatewayInfo + "]";
	}
	

}
