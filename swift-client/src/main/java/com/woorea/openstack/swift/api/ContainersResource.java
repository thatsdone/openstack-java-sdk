package com.woorea.openstack.swift.api;


import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.base.client.OpenStackRequestList;
import com.woorea.openstack.base.client.OpenStackRequestOps;
import com.woorea.openstack.swift.model.Container;

public class ContainersResource {
	
	private final OpenStackClient CLIENT;
	
	public ContainersResource(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list() {
		return new List();
	}
	
	public Create create(String name) {
		return new Create(name);
	}
	
	public Show show(String name) {
		return new Show(name);
	}
	
	public Delete delete(String name) {
		return new Delete(name);
	}
	
	public ContainerResource container(String name) {
		return new ContainerResource(CLIENT, name);
	}
	
	public class List extends OpenStackRequestList<Container> {

		// GET /v1/{account}
		public List() {
			super(CLIENT, HttpMethod.GET, "", null, Container.class);
		}
	}


	public class Create extends OpenStackRequestOps<Void> {
		
		// PUT /v1/{account}/{container}
		public Create(String containerName) {
			super(CLIENT, HttpMethod.PUT,
				  new StringBuffer("/").append(containerName),
				  null, Void.class);
		}

	}
	public class Show extends OpenStackRequestOps<Void> {

		// HEAD /v1/{account}/{container}
		public Show(String containerName) {
			super(CLIENT, HttpMethod.HEAD,
				  new StringBuffer("/").append(containerName),
				  null, Void.class);
		}

	}
	
	public class Delete extends OpenStackRequestOps<Void> {

		// DELETE /v1/{account}/{container}		
		public Delete(String containerName) {
			super(CLIENT, HttpMethod.DELETE,
				  new StringBuffer("/").append(containerName),
				  null, Void.class);
		}

	}
	
}
