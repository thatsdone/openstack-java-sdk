package com.woorea.openstack.ceilometer.v2.api;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.base.client.OpenStackRequestList;
//import com.woorea.openstack.ceilometer.QueriableCeilometerCommand;
import com.woorea.openstack.ceilometer.v2.model.Sample;
import com.woorea.openstack.ceilometer.v2.model.Meter;
import com.woorea.openstack.ceilometer.v2.model.Statistics;

public class MetersResource {
	
	private final OpenStackClient CLIENT;
	
	public MetersResource(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list() {
		return new List();
	}
	
	public Show show(String id) {
		if(id == null) {
			throw new UnsupportedOperationException("meter id is mandatory");
		}
		return new Show(id);
	}
	
	public Statistics statistics(String name) {
		if(name == null) {
			throw new UnsupportedOperationException("meter id is mandatory");
		}
		return new Statistics(name);
	}
	
	public class List extends OpenStackRequestList<Meter> {
		public List() {
			super(CLIENT, HttpMethod.GET, "/v2/meters", null, Meter.class);
		}
	}
	
	public class Show extends OpenStackRequestList<Sample> {
	
		public Show(String id) {
			super(CLIENT, HttpMethod.GET,
				  new StringBuffer("/v2/meters/").append(id), null, Sample.class);
		}
	}

	public class Statistics extends OpenStackRequestList<com.woorea.openstack.ceilometer.v2.model.Statistics> {

		public Statistics(String name) {
			super(CLIENT, HttpMethod.GET,
				  new StringBuffer("/v2/meters/").append(name).append("/statistics"), null, com.woorea.openstack.ceilometer.v2.model.Statistics.class);
		}
	}

}
