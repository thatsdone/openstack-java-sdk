package com.woorea.openstack.heat.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.heat.model.Stack;
import com.woorea.openstack.heat.model.Stacks;

public class StacksResource {

	private final OpenStackClient CLIENT;

	public StacksResource(OpenStackClient client) {
		CLIENT = client;
	}

	public List list() {
		return new List();
	}

	public class List extends OpenStackRequest<Stacks> {

		public List() {
			super(CLIENT, HttpMethod.GET, "/stacks", null, Stacks.class);
		}
	}

}
