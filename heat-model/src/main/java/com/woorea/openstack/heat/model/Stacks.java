package com.woorea.openstack.heat.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Stacks implements Iterable<Stack>, Serializable {

	private List<Stack> stacks;

	/**
	 * @return the list
	 */
	public List<Stack> getStacks() {
		return stacks;
	}
	
	@Override
	public String toString() {
		return "Stacks [stacks=" + stacks + "]";
	}

	@Override
	public Iterator<Stack> iterator() {
		return stacks.iterator();
	}
	
}
