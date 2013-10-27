package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HypervisorServers implements Iterable<HypervisorServers.SimpleServerWrapper>, Serializable {

	public static final class SimpleServer {

		private String uuid;
		private String name;

		public String getUuid() {
			return uuid;
		}

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return "SimpleServer [uuid=" + uuid
				+ ", name=" + name + "]";
		}
	}

	public static final class SimpleServerWrapper {

		Integer id;

		@JsonProperty("hypervisor_hostname")
		private String hypervisorHostname;

		private List<SimpleServer> servers;

		public Integer getId() {
			return id;
		}

		public String getHypervisorHostname() {
			return hypervisorHostname;
		}

		public List<SimpleServer> getServers() {
			return servers;
		}
		@Override
		public String toString() {
			return "SimpleServerWrapper [id=" + id
				+ ", hypervisorHostname=" + hypervisorHostname
				+ ", servers" + servers + "]";
		}
	}

	@JsonProperty("hypervisors")
	private List<SimpleServerWrapper> hypervisors;

	/**
	 * @return the hypervisors
	 */
	public List<SimpleServerWrapper> getHypervisors() {
		return hypervisors;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HypervisorServers [hypervisors=" + hypervisors + "]";
	}

	@Override
	public Iterator<SimpleServerWrapper> iterator() {
		return hypervisors.iterator();
	}

}