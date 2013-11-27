package com.woorea.openstack.nova.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

public class HostStatus implements Serializable {

	private String host;
	
	private String status;

	@JsonProperty("maintenance_mode")
	private String maintenanceMode;
	

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the maintenanceMode
	 */
	public String getMaintenanceMode() {
		return maintenanceMode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[host=" + host + ", status=" + status + ", maintenanceMode="
				+ maintenanceMode + "]";
	}

}
