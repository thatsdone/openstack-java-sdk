package com.woorea.openstack.ceilometer.v2.api;

import java.util.List;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
//import com.woorea.openstack.ceilometer.QueriableCeilometerCommand;
import com.woorea.openstack.base.client.OpenStackRequestList;
import com.woorea.openstack.ceilometer.v2.model.Resource;

public class ResourcesResource {
	
	private final OpenStackClient CLIENT;
	
	public ResourcesResource(OpenStackClient client) {
		CLIENT = client;
	}

	
	public List list () {
		return new List();
	}

	public class List extends OpenStackRequestList<Resource> {
		public List() {
			super(CLIENT, HttpMethod.GET, "/v2/resources", null, Resource.class);
		}
	}
	
	public Show show (String id) {
		if(id == null) {
			throw new UnsupportedOperationException("resource id is mandatory");
		}
		return new Show(id);
	}


	public class Show extends OpenStackRequest<Resource> {

		public Show(String id) {
			super(CLIENT, HttpMethod.GET,
				  new StringBuffer("/v2/resources/").append(id),
				  null, Resource.class);

		}
	}

}
