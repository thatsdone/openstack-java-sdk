package com.woorea.openstack.ceilometer.v2.api;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.base.client.OpenStackRequestList;
import com.woorea.openstack.ceilometer.QueriableCeilometerCommand;
import com.woorea.openstack.ceilometer.v2.model.Sample;
import com.woorea.openstack.ceilometer.v2.model.Meter;

public class MetersResource {
	
	private final OpenStackClient CLIENT;
	
	public MetersResource(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list() {
		return new List();
	}
	
	public Show show() {
		return new Show();
	}
	
	public Statistics statistics() {
		return new Statistics();
	}
	
	public class List extends OpenStackRequestList<Meter> {
		public List() {
			super(CLIENT, HttpMethod.GET, "/v2/meters", null, Meter.class);
		}
	}
	
	public class Show extends QueriableCeilometerCommand<Show, java.util.List<Sample>> {

		private String name;
			
		public Show name(String name) {
			this.name = name;
			return this;
		}
		
		public Show() {
//			if(name == null) {
//				throw new UnsupportedOperationException("meter id is mandatory");
//			}
//			return query(target.path("meters").path(name)).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Sample>>() {});
		}

	}

	public class Statistics extends QueriableCeilometerCommand<Statistics, java.util.List<Statistics>> {

		private String name;
			
		public Statistics name(String name) {
			this.name = name;
			return this;
		}
		
		public Statistics() {
//			if(name == null) {
//				throw new UnsupportedOperationException("meter id is mandatory");
//			}
//			return query(target.path("meters").path(name).path("statistics")).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Statistics>>(){});
		}

	}

}
