package com.woorea.openstack.quantum.api;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.quantum.model.Port;
import com.woorea.openstack.quantum.model.PortForCreate;
import com.woorea.openstack.quantum.model.Ports;

public class PortsResource {

	private final OpenStackClient CLIENT;

	public PortsResource(OpenStackClient client) {
		CLIENT = client;
	}

	public List list() {
		return new List();
	}

	public Create create(PortForCreate net){
		return new Create(net);
	}

	public Delete delete(String netId){
		return new Delete(netId);
	}

	public Show show(String netId){
		return new Show(netId);
	}

	public class List extends OpenStackRequest<Ports> {

		public List() {
		    super(CLIENT, HttpMethod.GET, "v2.0/ports", null, Ports.class);
		}
	}

	public class Query extends OpenStackRequest<Ports> {

		public Query(Port port) {
			//super(port);
//			target = target.path("v2.0").path("v2.0/ports");
//			target = queryParam(target);
//			return target.request(MediaType.APPLICATION_JSON).get(Ports.class);
		}

	}


	public class Create extends OpenStackRequest<Port> {

		public Create(PortForCreate port){
		    super(CLIENT, HttpMethod.POST, "v2.0/ports", Entity.json(port), Port.class);
		}
	}

	public class Show extends OpenStackRequest<Port> {

		public Show(String id) {
		    super(CLIENT, HttpMethod.GET, buildPath("v2.0/ports/", id), null, Port.class);
		}
	}

	public class Delete extends OpenStackRequest<Void> {

		public Delete(String id){
            super(CLIENT, HttpMethod.DELETE, buildPath("v2.0/ports/", id), null, Void.class);
		}
	}
}
