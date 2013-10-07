package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Hypervisors implements Iterable<Hypervisor>, Serializable {

	@JsonProperty("hypervisors")
	private List<Hypervisor> list;

	/**
	 * @return the list
	 */
	public List<Hypervisor> getList() {
		return list;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hypervisor [list=" + list + "]";
	}

	@Override
	public Iterator<Hypervisor> iterator() {
		return list.iterator();
	}

}