package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

//@JsonRootName("hypervisors")
public class Hypervisors implements Iterable<Hypervisors.SimpleHypervisor>, Serializable {

	public static final class SimpleHypervisor {

		private Integer id;

		@JsonProperty("hypervisor_hostname")
		private String hypervisorHostname;

		public Integer getId() {
			return id;
		}

		public String getHypervisorHostname() {
			return hypervisorHostname;
		}

		@Override
		public String toString() {
			return "Service [id=" + id
				+ ", hypervisor_hostname=" + hypervisorHostname + "]";
		}
	}


	@JsonProperty("hypervisors")
	private List<SimpleHypervisor> list;

	/**
	 * @return the list
	 */
	public List<SimpleHypervisor> getList() {
		return list;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hypervisors [list=" + list + "]";
	}

	@Override
	public Iterator<SimpleHypervisor> iterator() {
		return list.iterator();
	}

}