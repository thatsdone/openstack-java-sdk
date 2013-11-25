package com.woorea.openstack.quantum.api.extensions;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.quantum.model.Agent;
import com.woorea.openstack.quantum.model.Agents;


public class AgentsExtension {
	
	private final OpenStackClient CLIENT;
	
	public AgentsExtension(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list() {
		return new List();
	}
	
	public Show show(String id) {
		return new Show(id);
	}

	public class List extends OpenStackRequest<Agents> {

		public List() {
			super(CLIENT, HttpMethod.GET, "v2.0/agents", null, Agents.class);
		}

	}

	public class Show extends OpenStackRequest<Agent> {
		
		public Show(String id) {
			super(CLIENT, HttpMethod.GET,
				  new StringBuffer("/v2.0/agents/").append(id).toString(),
				  null,
				  Agent.class);
		}
		
	}

	
	
}
