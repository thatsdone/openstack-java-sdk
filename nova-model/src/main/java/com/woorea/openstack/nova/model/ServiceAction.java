package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

public interface ServiceAction extends Serializable {

	public static final class ServiceUpdateReq implements  ServiceAction{

		@JsonProperty("host")
		private String host;
		@JsonProperty("binary")
		private String binary;

		public ServiceUpdateReq () {
			super();
		}
		/**
		 * s	et the binary
		 */
		public void setHost(String host) {
			this.host = host;
		}
		/**	
		 * set t	he binary
		 */
		public void setBinary(String binary) {
			this.binary = binary;
		}
	}

}
