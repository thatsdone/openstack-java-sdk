package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("hypervisor")
public class Hypervisor implements Serializable {

	private Integer id;

	@JsonProperty("hypervisor_hostname")
	private String hypervisorHostname;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the hypervisor_hostname
	 */
	public String getHypervisorHostname() {
		return hypervisorHostname;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hypervisor [id=" + id + ", hypervisorHostname="
			+ hypervisorHostname + "]";
	}

}
