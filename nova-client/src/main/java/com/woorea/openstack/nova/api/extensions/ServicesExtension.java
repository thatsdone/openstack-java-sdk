package com.woorea.openstack.nova.api.extensions;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Service;
import com.woorea.openstack.nova.model.Service.ServiceIdentifier;
import com.woorea.openstack.nova.model.Services;

public class ServicesExtension {
	
	private final OpenStackClient CLIENT;
	
	public ServicesExtension(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list() {
		return new List();
	}

	public class List extends OpenStackRequest<Services> {

		public List() {
			super(CLIENT, HttpMethod.GET, "/os-services", null, Services.class);
		}

	}

	public EnableService enableService(String host, String binary) {
		ServiceIdentifier req = new ServiceIdentifier();
		req.setHost(host);
		req.setBinary(binary);
		return new EnableService(req);
	}

	public class EnableService extends OpenStackRequest<Service> {
		public EnableService(ServiceIdentifier req) {
			super(CLIENT, HttpMethod.PUT, "/os-services/enable", Entity.json(req), Service.class);
		}
	}

	public DisableService disableService(String host, String binary) {
		ServiceIdentifier req = new ServiceIdentifier();
		req.setHost(host);
		req.setBinary(binary);
		return new DisableService(req);
	}

	public class DisableService extends OpenStackRequest<Service> {
		public DisableService(ServiceIdentifier req) {
			super(CLIENT, HttpMethod.PUT, "/os-services/disable" , Entity.json(req), Service.class);
		}
	}

}
