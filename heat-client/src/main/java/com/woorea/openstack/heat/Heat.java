package com.woorea.openstack.heat;


import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.heat.api.StacksResource;

public class Heat extends OpenStackClient {

	private final StacksResource STACKS;

	public Heat(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
		STACKS = new StacksResource(this);
	}
	
	public Heat(String endpoint) {
		this(endpoint, null);
	}

	public StacksResource stacks() {
		return STACKS;
	}

}
