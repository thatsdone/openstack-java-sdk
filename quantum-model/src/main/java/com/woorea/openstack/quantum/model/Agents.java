package com.woorea.openstack.quantum.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

public class Agents implements Iterable<Agent>, Serializable{
	
	private List<Agent> agents;

	/**
	 * @return the agents
	 */
	public List<Agent> getAgents() {
		return agents;
	}

	public String toString() {
		return "Agents [" + agents + "]";
	}

	public Iterator<Agent> iterator() {
		return agents.iterator();
	}
	
}
