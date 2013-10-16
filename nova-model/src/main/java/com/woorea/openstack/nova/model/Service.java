package com.woorea.openstack.nova.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("service")
public class Service implements Serializable {

	public static final class ServiceIdentifier implements Serializable {

		@JsonProperty("host")
		private String host;
		@JsonProperty("binary")
		private String binary;

		/**
		 * set the host
		 */
		public void setHost(String host) {
			this.host = host;
		}
		/**	
		 * set the binary
		 */
		public void setBinary(String binary) {
			this.binary = binary;
		}
		@Override
		public String toString() {
			return "ServiceIdentifier [host=" + host + ", binary=" + binary + "]";
		}
	}

	private String host;
	
	@JsonProperty("updated_at")
	private String updatedAt;
	
	private String state;
	
	private String zone;
	
	private String binary;

	private String status;

	/**
	 * @return the host 
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @return the updatedAt
	 */
	public String getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @return the stete
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}

	/**
	 * @return the binary
	 */
	public String getBinary() {
		return binary;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Service [host=" + host + ", updated_at=" + updatedAt + ", state=" + state
				+ ", zone=" + zone + ", binary=" + binary+ ", status=" + status+ "]";
	}
}
