package com.woorea.openstack.swift.api;


import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.base.client.OpenStackRequestList;
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

		public List() {

			super(CLIENT, HttpMethod.GET, "", null, Container.class);
		}
	}


	public class Create extends OpenStackRequest<Container> {
		
		public Create(String containerName) {
			//return target.path(containerName).request().method("PUT",Entity.text("*"));
		}

	}
	
	public class Show extends OpenStackRequest<Container> {

		private String containerName;
		
		public Show(String containerName) {
//			return target.path(containerName).request(MediaType.APPLICATION_JSON).head();
		}

	}
	
	public class Delete extends OpenStackRequest<Void> {

		private String containerName;
		
		public Delete(String containerName) {
			this.containerName = containerName;
			//return target.path(containerName).request(MediaType.APPLICATION_JSON).delete();
		}

	}
	
}
